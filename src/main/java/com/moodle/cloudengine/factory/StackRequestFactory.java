package com.moodle.cloudengine.factory;

import com.amazonaws.services.cloudformation.model.Capability;
import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.amazonaws.services.cloudformation.model.Parameter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
@Component
public class StackRequestFactory {

    /**
     * Method to create AWS CreateStackRequest
     * @param stackName
     * @param parameters
     * @return
     */
    public CreateStackRequest createStackRequest(String stackName, List<Parameter> parameters, String template){
        CreateStackRequest request = new CreateStackRequest();
        request.withCapabilities(Capability.CAPABILITY_IAM);
        request.withStackName(stackName);
        request.withParameters(parameters);
        //todo-factor out to S3?
        request.withTemplateBody(template);
        return request;
    }
}
