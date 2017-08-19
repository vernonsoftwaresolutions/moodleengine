package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.EFS;
import com.moodle.cloudengine.template.model.Templates;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by andrewlarsen on 5/10/17.
 */
public class EFSBuilderTest {


    @Before
    public void setup(){

    }
    @Test
    public void withVPCName() throws Exception {
        EFS efs = (EFS) EFSBuilder.fromTemplateBody("template").withVPCName("VPCNAME").build();
        assertThat(efs.getVPCName().getParameterValue(), is("VPCNAME"));

    }

    @Test
    public void withEFSSubnet1() throws Exception {
        EFS efs = (EFS) EFSBuilder.fromTemplateBody("template").withEFSSubnet("EFSSUBNET1",
                "EFSSUBNET2", "EFSSUBNET3").build();
        assertThat(efs.getEFSubnet1Name().getParameterValue(), is("EFSSUBNET1"));
    }

    @Test
    public void withEFSSubnet2() throws Exception {
        EFS efs = (EFS) EFSBuilder.fromTemplateBody("template").withEFSSubnet("EFSSUBNET1",
                "EFSSUBNET2", "EFSSUBNET3").build();
        assertThat(efs.getEFSubnet2Name().getParameterValue(), is("EFSSUBNET2"));
    }
    @Test
    public void withEFSSubnet3() throws Exception {
        EFS efs = (EFS) EFSBuilder.fromTemplateBody("template").withEFSSubnet("EFSSUBNET1",
                "EFSSUBNET2", "EFSSUBNET3").build();
        assertThat(efs.getEFSubnet3Name().getParameterValue(), is("EFSSUBNET3"));
    }
    @Test
    public void withEFSTemplates() throws Exception {
        EFS efs = (EFS) EFSBuilder.fromTemplateBody("template").build();
        assertThat(efs.getTemplates(), is(Templates.EFS));
    }
}