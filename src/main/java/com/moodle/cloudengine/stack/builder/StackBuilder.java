package com.moodle.cloudengine.stack.builder;

import com.amazonaws.services.cloudformation.model.Capability;
import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.stack.Stack;

import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public abstract class StackBuilder {

    protected Parameter createParameter(String key, String value){
        return new Parameter()
                .withParameterKey(key)
                .withParameterValue(value);
    }


    public abstract StackBuilder withTenant(String tenant);
    public abstract Stack build();
//    public CreateStackRequest build(){
//        //create stack name
//        String stackName =  stack.getTenant() + "-vpc";
//        //create template
//        String template = stack.getTemplateBody();
//        //create stack
//        CreateStackRequest stackRequest = new CreateStackRequest();
//        stackRequest.withCapabilities(Capability.CAPABILITY_IAM);
//        stackRequest.withStackName(stackName);
//        stackRequest.withParameters(createParameters());
//        //todo-factor out to S3?
//        stackRequest.withTemplateBody(template);
//        return stackRequest;
//    }
}
