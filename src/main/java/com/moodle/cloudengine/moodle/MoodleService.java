package com.moodle.cloudengine.moodle;

import com.amazonaws.services.cloudformation.model.Output;
import com.amazonaws.services.cloudformation.model.Stack;
import com.moodle.cloudengine.exception.MoodleStackException;
import com.moodle.cloudengine.file.TemplateReader;
import com.moodle.cloudengine.ip.IPProvisioner;
import com.moodle.cloudengine.stack.ElasticBeanstalk;
import com.moodle.cloudengine.stack.MoodleStack;
import com.moodle.cloudengine.stack.builder.*;
import com.moodle.cloudengine.template.Template;
import com.moodle.cloudengine.template.model.Templates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by andrewlarsen on 5/9/17.
 */
@Service
public class MoodleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String VPC = "MAIN";
    private static final String MOODLE_BUCKET = "moodle-elasticbeanstalk-deployables";
    private static final String MOODLE_VERSION = "moodle/moodledeployment75.zip";
    private Template template;
    private IPProvisioner provisioner;
    private TemplateReader reader;

    public MoodleService(Template template, IPProvisioner provisioner, TemplateReader reader) {
        this.template = template;
        this.provisioner = provisioner;
        this.reader = reader;
    }

    /**
     * Method to create infra
     * @param tenant
     * @throws IOException
     * @throws URISyntaxException
     */
    public void createInfrastructure(String tenant) throws InterruptedException, MoodleStackException, IOException, URISyntaxException {
        //check tier?
        //get VPC Template
        //get ips
        logger.info("Starting infrastructure creation");
        List<String> ips = provisioner.getCidrBlock(28);
//        MoodleStack vpcMoodleStack = VPCBuilder.fromTemplateBody(reader.getFileAsString(Optional.of(Templates.VPC)))
//                //todo-factor out
//                .withVPCName(this.VPC)
//                .withPrivateRouteTable("PrivateRouteTable")
//                .withPublicRouteTable("PrivateRouteTable")
//                .withCidr("10.0.0.0/16")
//                .withWSCidr(ips.get(0), ips.get(1), ips.get(2))
//                .withAPPCidr(ips.get(3), ips.get(4), ips.get(5))
//                .withEFSCidr(ips.get(6), ips.get(7), ips.get(8))
//                .withDBCidr(ips.get(9), ips.get(10))
//                .withMCCidr(ips.get(11))
//                .withTenant(tenant)
//                .build();
//        Stack vpcStack = template.buildStack(vpcMoodleStack);
//        logger.info("VPC Stack Created");
//        MoodleStack rdsMoodleStack = RDSBuilder.fromTemplateBody(reader.getFileAsString(Optional.of(Templates.RDS)))
//                .isMultiAZ(false)
//                .withDBCredentials("user", "passwordthats8")
//                .withDBInstance("DBINSTANCE")
//                .withDBName(tenant + "db")
//                .withDBSubnetName("DBSubnet1" + tenant, "DBSubnet2" + tenant)
//                .withTenant(tenant)
//                .build();
//
//        Stack rdsStack = template.buildStack(rdsMoodleStack);
//        logger.debug("Retrieving DB URL");
//        Optional<Output> dbUrlOutput = getOutput(rdsStack,"DBUrl");
//
//        //make sure dburl is outputted, otherwise we can't continue processing
//        if(!dbUrlOutput.isPresent()){
//            logger.error("RDS Stack failed to output DB url");
//            throw new MoodleStackException("Invalid RDS output");
//        }

//        logger.info("RDS Stack Created");
//        MoodleStack efsMoodleStack = EFSBuilder.fromTemplateBody(reader.getFileAsString(Optional.of(Templates.EFS)))
//                .withEFSSubnet("EFSubnet1" + tenant,
//                        "EFSubnet2" + tenant, "EFSubnet3" + tenant)
//                .withVPCName(VPC)
//                .withTenant(tenant)
//                .build();
//        Stack efsStack = template.buildStack(efsMoodleStack);
//
//
//        logger.info("EFS Stack Created");
//
//        Optional<Output> efsOutput = getOutput(efsStack, "EFSRef");
//
//        if(!efsOutput.isPresent()){
//            logger.error("EFS Stack failed to output reference");
//            throw new MoodleStackException("Failed to retrieve EFS reference");
//        }
//        MoodleStack ecMoodleStack = ElasticCacheBuilder.fromTemplateBody(reader.getFileAsString(Optional.of(Templates.EC)))
//                .withTenant(tenant)
//                .withMCSubnet("MCSubnet1" + tenant)
//                .withVPCName(VPC)
//                .build();
//
//        Stack ecStack = template.buildStack(ecMoodleStack);
//        logger.info("Elastic Cache Stack Created");
//
//       // grab memcached url and port
//        Optional<Output> cacheUrl = getOutput(ecStack, "CacheEndpoint");
//        Optional<Output> cachePort = getOutput(ecStack, "CachePort");
//
//        if(!cacheUrl.isPresent() || !cachePort.isPresent()){
//            logger.error("Elastic Cache Stack failed to output endpoint or port");
//            throw new MoodleStackException("Invalid ElasticCache output");
//        }

        ElasticBeanstalk elasticBeanstalk = ElasticBeanstalkBuilder.fromTemplateBody(reader.getFileAsString(Optional.of(Templates.EB)))
                .withVPCName(VPC)
                .withTenant(tenant)
                .withMoodleBucket(MOODLE_BUCKET)
                .withMoodleVersion(MOODLE_VERSION)
                .withDBCredentials("user", "passwordthats8")
                .withDBName(tenant + "db")
                .withEBEC2Role("aws-elasticbeanstalk-ec2-role")
                .withEBServiceRole("aws-elasticbeanstalk-service-role")
                .withDBUrl("dbinstance.cffxov5w7rk6.us-east-1.rds.amazonaws.com")
                //.withDBUrl(dbUrlOutput.get().getOutputValue())
                .withAppSubnets("WSSubnet1" + tenant, "WSSubnet2" + tenant, "WSSubnet3" + tenant)
                .withWSSubnets("WSSubnet1" + tenant, "WSSubnet2" + tenant, "WSSubnet3" + tenant)
                .build();
        Stack ebStack = template.buildStack(elasticBeanstalk);
        logger.info("Elastic Beanstalk Created");

    }

    /**
     * Method ot retrieve output value from stack
     * @param stack
     * @param output
     * @return
     */
    private Optional<Output> getOutput(Stack stack, String output) {
        List<Output> dbUrlOutput = stack.getOutputs().stream().filter(o ->
            o.getOutputKey().equals(output)
        ).collect(Collectors.toList());
        if(dbUrlOutput.isEmpty()){
            return Optional.empty();
        }
        //todo-handle multiple outputs (which in theory shouldn't be possible)
        return Optional.of(dbUrlOutput.get(0));
    }
}
