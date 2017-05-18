package com.moodle.cloudengine.moodle;

import com.amazonaws.services.cloudformation.model.CreateStackResult;
import com.amazonaws.services.cloudformation.model.Stack;
import com.moodle.cloudengine.file.TemplateReader;
import com.moodle.cloudengine.ip.IPProvisioner;
import com.moodle.cloudengine.stack.MoodleStack;
import com.moodle.cloudengine.stack.builder.*;
import com.moodle.cloudengine.stack.factory.StackBuilderFactory;
import com.moodle.cloudengine.template.Template;
import com.moodle.cloudengine.template.model.Templates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * Created by andrewlarsen on 5/9/17.
 */
@Service
public class MoodleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String VPC = "VPC";
    private Template template;
    private StackBuilderFactory factory;
    private IPProvisioner provisioner;
    private TemplateReader reader;

    public MoodleService(Template template, StackBuilderFactory factory, IPProvisioner provisioner, TemplateReader reader) {
        this.template = template;
        this.factory = factory;
        this.provisioner = provisioner;
        this.reader = reader;
    }

    /**
     * Method to create infra
     * @param tenant
     * @throws IOException
     * @throws URISyntaxException
     */
    public void createInfrastructure(String tenant) throws Exception {
        //check tier?
        //get VPC Template
        //get ips
        logger.info("Starting infrastructure creation");
        List<String> ips = provisioner.getCidrBlock(28);
        MoodleStack vpcMoodleStack = VPCBuilder.fromTemplateBody(reader.getFileAsString(Optional.of(Templates.VPC)))
                            //todo-factor out
                            .withCidr("10.0.0.0/16")
                            .withWSCidr(ips.get(0), ips.get(1), ips.get(2))
                            .withAPPCidr(ips.get(3), ips.get(4), ips.get(5))
                            .withEFSCidr(ips.get(6), ips.get(7), ips.get(8))
                            .withDBCidr(ips.get(9), ips.get(10))
                            .withMCCidr(ips.get(11))
                            .withTenant(tenant)
                            .build();
        Stack vpcStack = template.buildStack(vpcMoodleStack);
        logger.info("VPC Stack Created");
        MoodleStack rdsMoodleStack = RDSBuilder.fromTemplateBody(reader.getFileAsString(Optional.of(Templates.RDS)))
                .isMultiAZ(true)
                .withDBCredentials("user", "passwordthats8")
                .withDBInstance("DBINSTANCE")
                .withDBName(tenant+"db")
                .withDBSubnetName("DBSubnet1" + tenant, "DBSubnet2" + tenant)
                .withTenant(tenant)
                .build();

        Stack rdsStack = template.buildStack(rdsMoodleStack);
        logger.info("RDS Stack Created");
        MoodleStack efsMoodleStack = EFSBuilder.fromTemplateBody(reader.getFileAsString(Optional.of(Templates.EFS)))
                .withEFSSubnet("EFSubnet1" + tenant,
                        "EFSubnet2" + tenant, "EFSubnet3"+tenant)
                .withVPCName(VPC)
                .withTenant(tenant)
                .build();
        Stack efsStack = template.buildStack(efsMoodleStack);
        logger.info("EFS Stack Created");
        MoodleStack ecMoodleStack = ElasticCacheBuilder.fromTemplateBody(reader.getFileAsString(Optional.of(Templates.EC)))
                .withTenant(tenant)
                .withMCSubnet("MCSubnet1" + tenant)
                .withVPCName(VPC)
                .build();

        Stack ecStack = template.buildStack(ecMoodleStack);
        logger.info("Elastic Cache Stack Created");
    }
}
