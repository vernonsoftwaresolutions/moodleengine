package com.moodle.cloudengine.factory;

import com.amazonaws.services.cloudformation.model.Capability;
import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.amazonaws.services.cloudformation.model.Parameter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class StackRequestFactoryTest {

    private StackRequestFactory factory;
    private String stackName;
    private List<Parameter> parameters;
    private String template;

    @Before
    public void setup(){
        factory = new StackRequestFactory();
        parameters = new ArrayList<>();
        stackName = "STACKNAME";
        template = "TEMPLATE BODY";
    }

    @Test
    public void createStackRequest() throws Exception {
        CreateStackRequest request = factory.createStackRequest(stackName, parameters, template);
        assertThat(request.getCapabilities().get(0), is(Capability.CAPABILITY_IAM.toString()));
    }
    @Test
    public void createStackRequestStackName(){
        CreateStackRequest request = factory.createStackRequest(stackName, parameters, template);
        assertThat(request.getStackName(), is(stackName));
    }

    @Test
    public void createStackRequestParameters(){
        CreateStackRequest request = factory.createStackRequest(stackName, parameters, template);
        assertThat(request.getParameters(), is(parameters));
    }

    @Test
    public void createStackRequestTemplate(){
        CreateStackRequest request = factory.createStackRequest(stackName, parameters, template);
        assertThat(request.getTemplateBody(), is(template));
    }

}