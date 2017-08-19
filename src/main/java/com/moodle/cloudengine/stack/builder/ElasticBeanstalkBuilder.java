package com.moodle.cloudengine.stack.builder;

import com.moodle.cloudengine.stack.ElasticBeanstalk;
import com.moodle.cloudengine.stack.MoodleStack;
import com.moodle.cloudengine.template.model.Templates;

/**
 * Created by andrewlarsen on 5/17/17.
 */
public class ElasticBeanstalkBuilder extends StackBuilder {

    private ElasticBeanstalk elasticBeanstalk;

    public ElasticBeanstalkBuilder(ElasticBeanstalk elasticBeanstalk) {
        this.elasticBeanstalk = elasticBeanstalk;
    }

    @Override
    public ElasticBeanstalk build() {
        return elasticBeanstalk;
    }

    public static ElasticBeanstalkBuilder fromTemplateBody(String template){
        ElasticBeanstalk elasticBeanstalk = new ElasticBeanstalk();
        elasticBeanstalk.setTemplateBody(template);
        elasticBeanstalk.setTemplates(Templates.EB);
        return new ElasticBeanstalkBuilder(elasticBeanstalk);

    }
    public ElasticBeanstalkBuilder withDBCredentials(String dbUser, String dbPassword){
        elasticBeanstalk.setDBMasterUser(createParameter("DBMasterUser", dbUser));
        elasticBeanstalk.setDBMasterPassword(createParameter("DBMasterPassword", dbPassword));
        return this;
    }

    public ElasticBeanstalkBuilder withDBName(String dbName){
        elasticBeanstalk.setDBName(createParameter("DBName", dbName));
        return this;
    }

    public ElasticBeanstalkBuilder withDBUrl(String dbUrl){
        elasticBeanstalk.setDBUrl(createParameter("DBUrl",dbUrl));
        return this;
    }
    public ElasticBeanstalkBuilder withVPCName(String vpcName){
        elasticBeanstalk.setVPCName(createParameter("VPCName", vpcName));
        return this;
    }

    public ElasticBeanstalkBuilder withTenant(String tenant){
        elasticBeanstalk.setTenant(createParameter("Tenant", tenant));
        return this;
    }

    public ElasticBeanstalkBuilder withMoodleBucket(String bucket){
        elasticBeanstalk.setMoodleBucket(createParameter("MoodleBucket", bucket));
        return this;
    }

    public ElasticBeanstalkBuilder withMoodleVersion(String version){
        elasticBeanstalk.setMoodleVersion(createParameter("MoodleVersion", version));
        return this;
    }

    public ElasticBeanstalkBuilder withAppSubnets(String appSubnet1, String appSubnet2, String appSubnet3){
        elasticBeanstalk.setAPPSubnet1Name(createParameter("APPSubnet1Name", appSubnet1));
        elasticBeanstalk.setAPPSubnet2Name(createParameter("APPSubnet2Name", appSubnet2));
        elasticBeanstalk.setAPPSubnet3Name(createParameter("APPSubnet3Name", appSubnet3));
        return this;
    }

    public ElasticBeanstalkBuilder withWSSubnets(String wsSubnet1, String wsSubnet2, String wsSubnet3){
        elasticBeanstalk.setWSSubnet1Name(createParameter("WSSubnet1Name", wsSubnet1));
        elasticBeanstalk.setWSSubnet2Name(createParameter("WSSubnet2Name", wsSubnet2));
        elasticBeanstalk.setWSSubnet3Name(createParameter("WSSubnet3Name", wsSubnet3));
        return this;

    }

    public ElasticBeanstalkBuilder withEBEC2Role(String ebec2Role){
         elasticBeanstalk.setEBEC2Role(createParameter("EBEC2Role",ebec2Role));
         return this;
    }
    public ElasticBeanstalkBuilder withEBServiceRole(String ebServiceRole){
        elasticBeanstalk.setEBServiceRole(createParameter("EBServiceRole",ebServiceRole));
        return this;
    }
}
