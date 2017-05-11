package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.RDS;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by andrewlarsen on 5/10/17.
 */
public class RDSBuilderTest {

    private RDSBuilder rdsBuilder;

    @Before
    public void setup(){
        rdsBuilder = new RDSBuilder("TEMPLATEBODY");
    }


    @Test
    public void withDBSubnetName() throws Exception {
        RDS rds = (RDS) rdsBuilder
                .withDBSubnetName("SUBNETNAME1", "SUBNETNAME2")
                .build();
        assertThat(rds.getDBSubnet1Name().getParameterValue(), is("SUBNETNAME1"));
    }

    @Test
    public void withDBSubnetName2() throws Exception {
        RDS rds = (RDS) rdsBuilder
                .withDBSubnetName("SUBNETNAME2", "SUBNETNAME2")
                .build();
        assertThat(rds.getDBSubnet1Name().getParameterValue(), is("SUBNETNAME2"));
    }

    @Test
    public void withDBInstance() throws Exception {
        RDS rds = (RDS) rdsBuilder
                .withDBInstance("DBINSTANCE")
                .build();
        assertThat(rds.getDBInstance().getParameterValue(), is("DBINSTANCE"));
    }

    @Test
    public void withDBCredentials() throws Exception {
        RDS rds = (RDS) rdsBuilder
                .withDBCredentials("user", "password")
                .build();
        assertThat(rds.getDBMasterUser().getParameterValue(), is("user"));
    }

    @Test
    public void withDBCredentialsPassword() throws Exception {
        RDS rds = (RDS) rdsBuilder
                .withDBCredentials("user", "password")
                .build();
        assertThat(rds.getDBMasterPassword().getParameterValue(), is("password"));
    }

    @Test
    public void withDBName() throws Exception {
        RDS rds = (RDS) rdsBuilder
                .withDBName("DBNAME")
                .build();
        assertThat(rds.getDBName().getParameterValue(), is("DBNAME"));
    }

    @Test
    public void isMultiAZ() throws Exception {
        RDS rds = (RDS) rdsBuilder
                .isMultiAZ(true)
                .build();
        assertThat(rds.getDBIsMultiZone().getParameterValue(), is("true"));
    }

}