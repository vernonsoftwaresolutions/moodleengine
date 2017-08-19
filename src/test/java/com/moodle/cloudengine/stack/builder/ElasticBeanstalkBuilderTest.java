package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.ElasticBeanstalk;
import com.moodle.cloudengine.template.model.Templates;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by andrewlarsen on 5/18/17.
 */
public class ElasticBeanstalkBuilderTest {


    @Test
    public void build() throws Exception {
        ElasticBeanstalk elasticBeanstalk = ElasticBeanstalkBuilder.fromTemplateBody("TEMPLATE")
                .withVPCName("VPCNAME").build();
        assertThat(elasticBeanstalk.getTemplates(), is(Templates.EB));
    }

    @Test
    public void withVPCName() throws Exception {
        ElasticBeanstalk elasticBeanstalk = ElasticBeanstalkBuilder.fromTemplateBody("TEMPLATE")
                .withVPCName("VPCNAME").build();
        assertThat(elasticBeanstalk.getVPCName().getParameterValue(), is("VPCNAME"));
        assertThat(elasticBeanstalk.getVPCName().getParameterKey(), is("VPCName"));
    }

    @Test
    public void withTenant() throws Exception {
        ElasticBeanstalk elasticBeanstalk = ElasticBeanstalkBuilder.fromTemplateBody("TEMPLATE")
                .withTenant("TENANT").build();
        assertThat(elasticBeanstalk.getTenant().getParameterValue(), is("TENANT"));
        assertThat(elasticBeanstalk.getTenant().getParameterKey(), is("Tenant"));

    }

    @Test
    public void withMoodleBucket() throws Exception {
        ElasticBeanstalk elasticBeanstalk = ElasticBeanstalkBuilder.fromTemplateBody("TEMPLATE")
                .withMoodleBucket("MOODLEBUCKET").build();
        assertThat(elasticBeanstalk.getMoodleBucket().getParameterValue(), is("MOODLEBUCKET"));
        assertThat(elasticBeanstalk.getMoodleBucket().getParameterKey(), is("MoodleBucket"));

    }

    @Test
    public void withMoodleVersion() throws Exception {
        ElasticBeanstalk elasticBeanstalk = ElasticBeanstalkBuilder.fromTemplateBody("TEMPLATE")
                .withMoodleVersion("MOODLEVERSION").build();
        assertThat(elasticBeanstalk.getMoodleVersion().getParameterValue(), is("MOODLEVERSION"));
        assertThat(elasticBeanstalk.getMoodleVersion().getParameterKey(), is("MoodleVersion"));

    }

    @Test
    public void withAppSubnet1() throws Exception {
        ElasticBeanstalk elasticBeanstalk = ElasticBeanstalkBuilder.fromTemplateBody("TEMPLATE")
                .withAppSubnets("sub1", "sub2", "sub3").build();
        assertThat(elasticBeanstalk.getAPPSubnet1Name().getParameterValue(), is("sub1"));
        assertThat(elasticBeanstalk.getAPPSubnet1Name().getParameterKey(), is("APPSubnet1Name"));

    }
    @Test
    public void withAppSubnet2() throws Exception {
        ElasticBeanstalk elasticBeanstalk = ElasticBeanstalkBuilder.fromTemplateBody("TEMPLATE")
                .withAppSubnets("sub1", "sub2", "sub3").build();
        assertThat(elasticBeanstalk.getAPPSubnet2Name().getParameterValue(), is("sub2"));
        assertThat(elasticBeanstalk.getAPPSubnet2Name().getParameterKey(), is("APPSubnet2Name"));

    }
    @Test
    public void withAppSubnet3() throws Exception {
        ElasticBeanstalk elasticBeanstalk = ElasticBeanstalkBuilder.fromTemplateBody("TEMPLATE")
                .withAppSubnets("sub1", "sub2", "sub3").build();
        assertThat(elasticBeanstalk.getAPPSubnet3Name().getParameterValue(), is("sub3"));
        assertThat(elasticBeanstalk.getAPPSubnet3Name().getParameterKey(), is("APPSubnet3Name"));

    }
    @Test
    public void withWSSubnet3() throws Exception {
        ElasticBeanstalk elasticBeanstalk = ElasticBeanstalkBuilder.fromTemplateBody("TEMPLATE")
                .withWSSubnets("sub1", "sub2", "sub3").build();
        assertThat(elasticBeanstalk.getWSSubnet3Name().getParameterValue(), is("sub3"));
        assertThat(elasticBeanstalk.getWSSubnet3Name().getParameterKey(), is("WSSubnet3Name"));
    }
    @Test
    public void withWSSubnet2() throws Exception {
        ElasticBeanstalk elasticBeanstalk = ElasticBeanstalkBuilder.fromTemplateBody("TEMPLATE")
                .withWSSubnets("sub1", "sub2", "sub3").build();
        assertThat(elasticBeanstalk.getWSSubnet2Name().getParameterValue(), is("sub2"));
        assertThat(elasticBeanstalk.getWSSubnet2Name().getParameterKey(), is("WSSubnet2Name"));
    }
    @Test
    public void withWSSubnet1() throws Exception {
        ElasticBeanstalk elasticBeanstalk = ElasticBeanstalkBuilder.fromTemplateBody("TEMPLATE")
                .withWSSubnets("sub1", "sub2", "sub3").build();
        assertThat(elasticBeanstalk.getWSSubnet1Name().getParameterValue(), is("sub1"));
        assertThat(elasticBeanstalk.getWSSubnet1Name().getParameterKey(), is("WSSubnet1Name"));
    }
}