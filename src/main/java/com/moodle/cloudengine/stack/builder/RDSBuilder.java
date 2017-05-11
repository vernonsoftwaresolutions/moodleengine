package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.RDS;
import com.moodle.cloudengine.stack.Stack;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class RDSBuilder extends StackBuilder {

    private RDS rds;


    public RDSBuilder(String templateBody){
        RDS rds = new RDS();
        rds.setTemplateBody(templateBody);
        this.rds = rds;
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
    @Override
    public StackBuilder withTenant(String tenant) {
        rds.setTenant(createParameter("Tenant", tenant));
        return this;
    }

    @Override
    public Stack build() {
        return this.rds;
    }
}
