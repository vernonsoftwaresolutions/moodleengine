package com.moodle.cloudengine.stack.builder;


import com.moodle.cloudengine.stack.MoodleStack;
import com.moodle.cloudengine.stack.VPC;
import com.moodle.cloudengine.template.model.Templates;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class VPCBuilder extends StackBuilder {

    private VPC vpc;

    public VPCBuilder(VPC vpc) {
        this.vpc = vpc;
    }

    public static VPCBuilder fromTemplateBody(String templateBody) {
        VPC vpc = new VPC();
        vpc.setTemplateBody(templateBody);
        vpc.setTemplates(Templates.VPC);
        return new VPCBuilder(vpc);
    }

    @Override
    public VPC build() {
        return vpc;
    }

    public VPCBuilder withAPPCidr(String appCidr1, String appCidr2, String appCidr3){
        vpc.setAPPSN1Cidr(createParameter("APPSN1Cidr", appCidr1));
        vpc.setAPPSN2Cidr(createParameter("APPSN2Cidr", appCidr2));
        vpc.setAPPSN3Cidr(createParameter("APPSN3Cidr", appCidr3));
        return this;
    }

    public VPCBuilder withDBCidr(String dbCidr1, String dbCidr2){
        vpc.setDBSN1Cidr(createParameter("DBSN1Cidr", dbCidr1));
        vpc.setDBSN2Cidr(createParameter("DBSN2Cidr", dbCidr2));
        return this;
    }

    public VPCBuilder withEFSCidr(String efsCidr1, String efsCidr2, String efsCidr3){
        vpc.setEFSN1Cidr(createParameter("EFSN1Cidr", efsCidr1));
        vpc.setEFSN2Cidr(createParameter("EFSN2Cidr", efsCidr2));
        vpc.setEFSN3Cidr(createParameter("EFSN3Cidr", efsCidr3));
        return this;
    }

    public VPCBuilder withMCCidr(String mcCidr){
        vpc.setMCSN1Cidr(createParameter("MCSN1Cidr", mcCidr));
        return this;
    }

    public VPCBuilder withWSCidr(String wsCidr1, String wsCidr2, String wsCidr3){
        vpc.setWSSN1Cidr(createParameter("WSSN1Cidr", wsCidr1));
        vpc.setWSSN2Cidr(createParameter("WSSN2Cidr", wsCidr2));
        vpc.setWSSN3Cidr(createParameter("WSSN3Cidr", wsCidr3));
        return this;
    }

    public VPCBuilder withCidr(String cidr){
        vpc.setCidr(createParameter("CidrBlock", cidr));
        return this;
    }
    public VPCBuilder withVPCName(String name){
        vpc.setName(createParameter("VPCName",name));
        return this;
    }
    public VPCBuilder withPrivateRouteTable(String table){
        vpc.setPrivateRouteTable(createParameter("PrivateRouteTable", table));
        return this;
    }
    public VPCBuilder withPublicRouteTable(String table){
        vpc.setPublicRouteTable(createParameter("PublicRouteTable", table));
        return this;
    }
    public StackBuilder withTenant(String tenant) {
        vpc.setTenant(createParameter("Tenant", tenant));
        return this;
    }


    //todo-add validation

}
