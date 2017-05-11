package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.EFS;
import com.moodle.cloudengine.stack.Stack;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class EFSBuilder extends StackBuilder {

    private EFS efs;

    public EFSBuilder(String templateBody){
        EFS efs = new EFS();
        efs.setTemplateBody(templateBody);
        this.efs = efs;
    }

    public EFSBuilder withVPCName(String vpcName){
        efs.setVPCName(createParameter("VPCName", vpcName));
        return this;
    }

    public EFSBuilder withEFSSubnet(String efsSubnet1, String efsSubnet2, String efsSubnet3){
        efs.setEFSubnet1Name(createParameter("EFSubnet1Name", efsSubnet1));
        efs.setEFSubnet2Name(createParameter("EFSubnet2Name", efsSubnet2));
        efs.setEFSubnet3Name(createParameter("EFSubnet3Name",efsSubnet3));
        return this;
    }

    @Override
    public StackBuilder withTenant(String tenant) {
        efs.setTenant(createParameter("Tenant", tenant));
        return this;
    }

    @Override
    public Stack build() {
        return this.efs;
    }
}
