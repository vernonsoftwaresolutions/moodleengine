package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.ElasticCache;
import com.moodle.cloudengine.template.model.Templates;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by andrewlarsen on 5/10/17.
 */
public class ElasticCacheBuilderTest {

    private ElasticCacheBuilder elasticCacheBuilder;
    @Test
    public void withVPCName() throws Exception {
        ElasticCache elasticCache = (ElasticCache) ElasticCacheBuilder
                .fromTemplateBody("tempalte")
                .withVPCName("VPCNAME")
                .build();
        assertThat(elasticCache.getVPCName().getParameterValue(), is("VPCNAME"));
    }

    @Test
    public void withMCSubnet() throws Exception {
        ElasticCache elasticCache = (ElasticCache) ElasticCacheBuilder
                .fromTemplateBody("tempalte")
                .withMCSubnet("MCSUBNET")
                .build();
        assertThat(elasticCache.getMCSubnet1Name().getParameterValue(), is("MCSUBNET"));
    }

    @Test
    public void withTemplates() throws Exception {
        ElasticCache elasticCache = (ElasticCache) ElasticCacheBuilder
                .fromTemplateBody("tempalte")
                .build();
        assertThat(elasticCache.getTemplates(), is(Templates.EC));
    }

}