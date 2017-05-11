package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.ElasticCache;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by andrewlarsen on 5/10/17.
 */
public class ElasticCacheBuilderTest {

    private ElasticCacheBuilder elasticCacheBuilder;

    @Before
    public void setup(){
        elasticCacheBuilder = new ElasticCacheBuilder("TEMPLATEBODY");
    }
    @Test
    public void withVPCName() throws Exception {
        ElasticCache elasticCache = (ElasticCache) elasticCacheBuilder
                .withVPCName("VPCNAME")
                .build();
        assertThat(elasticCache.getVPCName().getParameterValue(), is("VPCNAME"));
    }

    @Test
    public void withMCSubnet() throws Exception {
        ElasticCache elasticCache = (ElasticCache) elasticCacheBuilder
                .withMCSubnet("MCSUBNET")
                .build();
        assertThat(elasticCache.getMCSubnet1Name().getParameterValue(), is("MCSUBNET"));
    }

}