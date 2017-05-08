package com.moodle.cloudengine.template.impl;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.amazonaws.services.cloudformation.model.CreateStackResult;
import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.factory.StackRequestFactory;
import com.moodle.cloudengine.file.TemplateReader;
import com.moodle.cloudengine.template.AbstractTemplate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class VPCTemplateTest {

    private VPCTemplate template;

    @Mock
    private TemplateReader reader;
    @Mock
    private StackRequestFactory factory;
    @Mock
    private AmazonCloudFormation cloudFormation;
    CreateStackResult result;
    private CreateStackRequest request;
    private String stackName;
    private List<Parameter> parameters;
    private String templateBody;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        template = new VPCTemplate(factory, reader, cloudFormation);
        template.setTenant(new Parameter()
                .withParameterKey("Tenant")
                .withParameterValue("TENANT"));
        stackName = "TENANT-vpc";
        templateBody = "TEMPLATE BODY";
        request = new CreateStackRequest();
        result = new CreateStackResult();
    }
    @Test
    public void buildStack() throws Exception {
        given(reader.getFileAsString("vpc_template.yaml")).willReturn(templateBody);
        given(factory.createStackRequest(eq(stackName), Mockito.any(), eq(templateBody))).willReturn(request);
        given(cloudFormation.createStack(request)).willReturn(result);

        CreateStackResult output = template.buildStack();
        assertThat(output, is(result));
    }

}