package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.VPC;
import com.moodle.cloudengine.template.model.Templates;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by andrewlarsen on 5/10/17.
 */
public class VPCBuilderTest {

    private VPCBuilder vpcBuilder;

    @Test
    public void withAPPCidr() throws Exception {
        VPC vpc = (VPC) VPCBuilder
                .fromTemplateBody("TEMPLATE")
                .withAPPCidr("1", "2", "3")
                .build();

        assertThat(vpc.getAPPSN1Cidr().getParameterValue(), is("1"));
        assertThat(vpc.getAPPSN2Cidr().getParameterValue(), is("2"));
        assertThat(vpc.getAPPSN3Cidr().getParameterValue(), is("3"));

    }

    @Test
    public void withDBCidr() throws Exception {
        VPC vpc = (VPC) VPCBuilder
                .fromTemplateBody("TEMPLATE")
                .withDBCidr("1", "2")
                .build();

        assertThat(vpc.getDBSN1Cidr().getParameterValue(), is("1"));
        assertThat(vpc.getDBSN2Cidr().getParameterValue(), is("2"));
    }

    @Test
    public void withEFSCidr() throws Exception {
        VPC vpc = (VPC) VPCBuilder
                .fromTemplateBody("TEMPLATE")
                .withEFSCidr("1", "2", "3")
                .build();

        assertThat(vpc.getEFSN1Cidr().getParameterValue(), is("1"));
        assertThat(vpc.getEFSN2Cidr().getParameterValue(), is("2"));
        assertThat(vpc.getEFSN3Cidr().getParameterValue(), is("3"));
    }

    @Test
    public void withMCCidr() throws Exception {
        VPC vpc = (VPC) VPCBuilder
                .fromTemplateBody("TEMPLATE")
                .withMCCidr("1")
                .build();

        assertThat(vpc.getMCSN1Cidr().getParameterValue(), is("1"));

    }

    @Test
    public void withWSCidr() throws Exception {
        VPC vpc = (VPC) VPCBuilder
                .fromTemplateBody("TEMPLATE")
                .withWSCidr("1", "2", "3")
                .build();

        assertThat(vpc.getWSSN1Cidr().getParameterValue(), is("1"));
        assertThat(vpc.getWSSN2Cidr().getParameterValue(), is("2"));
        assertThat(vpc.getWSSN3Cidr().getParameterValue(), is("3"));
    }

    @Test
    public void withCidr() throws Exception {
        VPC vpc = (VPC) VPCBuilder
                .fromTemplateBody("TEMPLATE")
                .withCidr("1")
                .build();

        assertThat(vpc.getCidr().getParameterValue(), is("1"));
    }

    @Test
    public void withTenant() throws Exception {
        VPC vpc = (VPC) VPCBuilder
                .fromTemplateBody("TEMPLATE")
                .withTenant("1")
                .build();

        assertThat(vpc.getTenant().getParameterValue(), is("1"));
    }
    @Test
    public void withTemplates() throws Exception {
        VPC vpc = (VPC) VPCBuilder
                .fromTemplateBody("TEMPLATE")
                .build();

        assertThat(vpc.getTemplates(), is(Templates.VPC));
    }
}