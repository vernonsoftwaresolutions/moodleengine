package com.moodle.cloudengine.stack;

import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.moodle.cloudengine.stack.request.Request;
import com.moodle.cloudengine.stack.request.VPCRequest;
import com.moodle.cloudengine.template.model.Templates;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class StackRequestFactoryTest {
    @Test
    public void getBuilder() throws Exception {
        VPCRequest request = new VPCRequest();
        request.setTemplateBody("body");
        request.setTemplates(Templates.VPC);
        request.setAPPSN1Cidr("CIRD");
        CreateStackRequest req = StackRequestFactory.getBuilder(request).build();
        assertThat(req.getTemplateBody(), is("body"));
    }
    @Test
    public void getBuilderAPPSN1Cidr() throws Exception {
        VPCRequest request = new VPCRequest();
        request.setTemplateBody("body");
        request.setTemplates(Templates.VPC);
        request.setAPPSN1Cidr("CIRD");
        request.setTenant("TENANT");
        CreateStackRequest req = StackRequestFactory.getBuilder(request).build();
        assertThat(req.getStackName(), is("TENANT-vpc"));
    }

}