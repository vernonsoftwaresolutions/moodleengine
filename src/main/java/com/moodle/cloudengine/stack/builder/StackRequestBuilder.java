package com.moodle.cloudengine.stack.builder;

import com.amazonaws.services.cloudformation.model.Capability;
import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.stack.request.Request;

import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public abstract class StackRequestBuilder {

    protected CreateStackRequest stackRequest;
    protected Request request;
    protected abstract List<Parameter> createParameters();

    protected Parameter createParameter(String key, String value){
        return new Parameter()
                .withParameterKey(key)
                .withParameterValue(value);
    }

    StackRequestBuilder(Request request){
        this.request = request;
    }

    public CreateStackRequest build(){
        //create stack name
        String stackName =  request.getTenant() + "-vpc";
        //create template
        String template = request.getTemplateBody();
        //create request
        CreateStackRequest stackRequest = new CreateStackRequest();
        stackRequest.withCapabilities(Capability.CAPABILITY_IAM);
        stackRequest.withStackName(stackName);
        stackRequest.withParameters(createParameters());
        //todo-factor out to S3?
        stackRequest.withTemplateBody(template);
        return stackRequest;
    }
}
