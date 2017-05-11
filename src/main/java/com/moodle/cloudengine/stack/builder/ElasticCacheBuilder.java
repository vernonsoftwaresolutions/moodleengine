package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.ElasticCache;
import com.moodle.cloudengine.stack.Stack;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class ElasticCacheBuilder extends StackBuilder {

    private ElasticCache elasticCache;
    public ElasticCacheBuilder(String templateBody){
        ElasticCache elasticCache = new ElasticCache();
        elasticCache.setTemplateBody(templateBody);
        this.elasticCache = elasticCache;
    }

    public ElasticCacheBuilder withVPCName(String vpcName){
        elasticCache.setVPCName(createParameter("VPCName", vpcName));
        return this;
    }

    public ElasticCacheBuilder withMCSubnet(String mcSubnet){
        elasticCache.setMCSubnet1Name(createParameter("MCSubnet1Name",mcSubnet));
        return this;

    }
    @Override
    public StackBuilder withTenant(String tenant) {
        elasticCache.setTenant(createParameter("Tenant", tenant));
        return this;
    }

    @Override
    public Stack build() {
        return this.elasticCache;
    }
}
