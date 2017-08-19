package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.EFS;
import com.moodle.cloudengine.stack.MoodleStack;
import com.moodle.cloudengine.template.model.Templates;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class EFSBuilder extends StackBuilder {

    private EFS efs;

    public EFSBuilder(EFS efs) {
        this.efs = efs;
    }

    public static EFSBuilder fromTemplateBody(String templateBody){
        EFS efs = new EFS();
        efs.setTemplateBody(templateBody);
        efs.setTemplates(Templates.EFS);
        return new EFSBuilder(efs);
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

    public EFSBuilder withTenant(String tenant) {
        efs.setTenant(createParameter("Tenant", tenant));
        return this;
    }

    @Override
    public EFS build() {
        return this.efs;
    }
}
