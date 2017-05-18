package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.ElasticCache;
import com.moodle.cloudengine.stack.MoodleStack;
import com.moodle.cloudengine.template.model.Templates;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class ElasticCacheBuilder extends StackBuilder {

    private ElasticCache elasticCache;
    public ElasticCacheBuilder(ElasticCache elasticCache){
        this.elasticCache = elasticCache;
    }

    public static ElasticCacheBuilder fromTemplateBody(String templateBody){
        ElasticCache elasticCache = new ElasticCache();
        elasticCache.setTemplateBody(templateBody);
        elasticCache.setTemplates(Templates.EC);

        return new ElasticCacheBuilder(elasticCache);

    }
    public ElasticCacheBuilder withVPCName(String vpcName){
        elasticCache.setVPCName(createParameter("VPCName", vpcName));
        return this;
    }

    public ElasticCacheBuilder withMCSubnet(String mcSubnet){
        elasticCache.setMCSubnet1Name(createParameter("MCSubnet1Name",mcSubnet));
        return this;

    }
    public ElasticCacheBuilder withTenant(String tenant) {
        elasticCache.setTenant(createParameter("Tenant", tenant));
        return this;
    }

    @Override
    public MoodleStack build() {
        return this.elasticCache;
    }
}
