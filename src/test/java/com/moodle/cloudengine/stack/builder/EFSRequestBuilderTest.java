package com.moodle.cloudengine.stack.builder;

import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.stack.request.EFSRequest;
import com.moodle.cloudengine.template.model.Templates;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class EFSRequestBuilderTest {
    EFSRequestBuilder requestBuilder;
    EFSRequest request;
    @Before
    public void setup(){
        request = new EFSRequest();
        request.setVPCName("VPC");
        request.setTemplateBody("BODY");
        request.setTenant("TENANT");
        request.setTemplates(Templates.EFS);
        request.setEFSubnet1Name("EFS1");
        request.setEFSubnet2Name("EFS2");
        request.setEFSubnet3Name("EFS3");
        requestBuilder = new EFSRequestBuilder(request);

    }
    @Test
    public void createParameters() throws Exception {
       CreateStackRequest req =  requestBuilder.build();
       assertThat(req.getStackName(), is("TENANT-vpc"));
       assertThat(req.getTemplateBody(), is(request.getTemplateBody()));
    }

    @Test
    public void testCreateEFS1(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterValue().equals(request.getEFSubnet1Name());
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateEFS2(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterValue().equals(request.getEFSubnet2Name());
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateEFS3(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterValue().equals(request.getEFSubnet3Name());
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateVPC(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterValue().equals(request.getVPCName());
        }).findFirst();

        assert parameter.isPresent();
    }

    //names
    @Test
    public void testCreateEFS1Name(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterKey().equals("EFSubnet1Name");
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateEFS2Name(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterKey().equals("EFSubnet2Name");
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateEFS3Name(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterKey().equals("EFSubnet3Name");
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateVPCName(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterKey().equals("VPCName");
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateTenantName(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterKey().equals("Tenant");
        }).findFirst();

        assert parameter.isPresent();
    }
}