package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.RDS;
import com.moodle.cloudengine.stack.MoodleStack;
import com.moodle.cloudengine.template.model.Templates;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class RDSBuilder extends StackBuilder {

    private RDS rds;

    public RDSBuilder(RDS rds) {
        this.rds = rds;
    }

    public static RDSBuilder fromTemplateBody(String templateBody){
        RDS rds = new RDS();
        rds.setTemplateBody(templateBody);
        rds.setTemplates(Templates.RDS);
        return new RDSBuilder(rds);

    }

    public RDSBuilder withDBSubnetName(String dbSubnetName1, String dbSubnetName2){
        rds.setDBSubnet1Name(createParameter("DBSubnet1Name", dbSubnetName1));
        rds.setDBSubnet2Name(createParameter("DBSubnet2Name", dbSubnetName2));
        return this;
    }

    public RDSBuilder withDBInstance(String dbInstance){
        rds.setDBInstance(createParameter("DBInstance", dbInstance));
        return this;
    }

    public RDSBuilder withDBCredentials(String dbUser, String dbPassword){
        rds.setDBMasterUser(createParameter("DBMasterUser", dbUser));
        rds.setDBMasterPassword(createParameter("DBMasterPassword", dbPassword));
        return this;
    }

    public RDSBuilder withDBName(String dbName){
        rds.setDBName(createParameter("DBName", dbName));
        return this;
    }

    public RDSBuilder isMultiAZ(Boolean isMultiAZ){
        rds.setDBIsMultiZone(createParameter("DBIsMultiZone", String.valueOf(isMultiAZ)));
        return this;
    }
    public RDSBuilder withTenant(String tenant) {
        rds.setTenant(createParameter("Tenant", tenant));
        return this;
    }

    @Override
    public MoodleStack build() {
        return this.rds;
    }
}
