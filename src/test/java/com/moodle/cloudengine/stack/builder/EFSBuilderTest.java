package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.EFS;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by andrewlarsen on 5/10/17.
 */
public class EFSBuilderTest {
    private EFSBuilder efsBuilder;

    @Before
    public void setup(){
        efsBuilder = new EFSBuilder("TEMPLATEBODY");
    }
    @Test
    public void withVPCName() throws Exception {
        EFS efs = (EFS) efsBuilder.withVPCName("VPCNAME").build();
        assertThat(efs.getVPCName().getParameterValue(), is("VPCNAME"));

    }

    @Test
    public void withEFSSubnet1() throws Exception {
        EFS efs = (EFS) efsBuilder.withEFSSubnet("EFSSUBNET1",
                "EFSSUBNET2", "EFSSUBNET3").build();
        assertThat(efs.getEFSubnet1Name().getParameterValue(), is("EFSSUBNET1"));
    }

    @Test
    public void withEFSSubnet2() throws Exception {
        EFS efs = (EFS) efsBuilder.withEFSSubnet("EFSSUBNET1",
                "EFSSUBNET2", "EFSSUBNET3").build();
        assertThat(efs.getEFSubnet2Name().getParameterValue(), is("EFSSUBNET2"));
    }
    @Test
    public void withEFSSubnet3() throws Exception {
        EFS efs = (EFS) efsBuilder.withEFSSubnet("EFSSUBNET1",
                "EFSSUBNET2", "EFSSUBNET3").build();
        assertThat(efs.getEFSubnet3Name().getParameterValue(), is("EFSSUBNET3"));
    }
}