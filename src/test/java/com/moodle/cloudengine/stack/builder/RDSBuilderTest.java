package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.RDS;
import com.moodle.cloudengine.template.Template;
import com.moodle.cloudengine.template.model.Templates;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by andrewlarsen on 5/10/17.
 */
public class RDSBuilderTest {

    private RDSBuilder rdsBuilder;


    @Test
    public void withDBSubnetName() throws Exception {
        RDS rds = (RDS) RDSBuilder
                .fromTemplateBody("TEMPLATE")
                .withDBSubnetName("SUBNETNAME1", "SUBNETNAME2")
                .build();
        assertThat(rds.getDBSubnet1Name().getParameterValue(), is("SUBNETNAME1"));
    }

    @Test
    public void withDBSubnetName2() throws Exception {
        RDS rds = (RDS) RDSBuilder
                .fromTemplateBody("TEMPLATE")
                .withDBSubnetName("SUBNETNAME2", "SUBNETNAME2")
                .build();
        assertThat(rds.getDBSubnet1Name().getParameterValue(), is("SUBNETNAME2"));
    }

    @Test
    public void withDBInstance() throws Exception {
        RDS rds = (RDS) RDSBuilder
                .fromTemplateBody("TEMPLATE")
                .withDBInstance("DBINSTANCE")
                .build();
        assertThat(rds.getDBInstance().getParameterValue(), is("DBINSTANCE"));
    }

    @Test
    public void withDBCredentials() throws Exception {
        RDS rds = (RDS) RDSBuilder
                .fromTemplateBody("TEMPLATE")
                .withDBCredentials("user", "password")
                .build();
        assertThat(rds.getDBMasterUser().getParameterValue(), is("user"));
    }

    @Test
    public void withDBCredentialsPassword() throws Exception {
        RDS rds = (RDS) RDSBuilder
                .fromTemplateBody("TEMPLATE")
                .withDBCredentials("user", "password")
                .build();
        assertThat(rds.getDBMasterPassword().getParameterValue(), is("password"));
    }

    @Test
    public void withDBName() throws Exception {
        RDS rds = (RDS) RDSBuilder
                .fromTemplateBody("TEMPLATE")
                .withDBName("DBNAME")
                .build();
        assertThat(rds.getDBName().getParameterValue(), is("DBNAME"));
    }

    @Test
    public void isMultiAZ() throws Exception {
        RDS rds = (RDS) RDSBuilder
                .fromTemplateBody("TEMPLATE")
                .isMultiAZ(true)
                .build();
        assertThat(rds.getDBIsMultiZone().getParameterValue(), is("true"));
    }

    @Test
    public void withTemplates(){
        RDS rds = (RDS) RDSBuilder
                .fromTemplateBody("TEMPLATE")
                .build();
        assertThat(rds.getTemplates(), is(Templates.RDS));
    }

}