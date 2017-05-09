package com.moodle.cloudengine.stack.builder;

import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.moodle.cloudengine.stack.request.VPCRequest;
import com.moodle.cloudengine.template.model.Templates;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by andrewlarsen on 5/8/17.
 */
public class VPCRequestBuilderTest {
    VPCRequestBuilder requestBuilder;
    VPCRequest request;
    @Before
    public void setup(){
        request = new VPCRequest();
        request.setCidr("CIDR");
        request.setTemplateBody("BODY");
        request.setTenant("TENANT");
        request.setTemplates(Templates.EFS);
        request.setAPPSN1Cidr("APPSN1Cidr");
        request.setAPPSN2Cidr("APPSN2Cidr");
        request.setAPPSN3Cidr("APPSN3Cidr");
        request.setEFSN1Cidr("EFSN1Cidr");
        requestBuilder = new VPCRequestBuilder(request);

    }
    @Test
    public void createParameters() throws Exception {
        CreateStackRequest req =  requestBuilder.build();
        assertThat(req.getStackName(), is("TENANT-vpc"));
        assertThat(req.getTemplateBody(), is(request.getTemplateBody()));
    }

    @Test
    public void testCreateAPPSN1Cidr(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterValue().equals(request.getAPPSN1Cidr());
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateAPPSN2Cidr(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterValue().equals(request.getAPPSN2Cidr());
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateAPPSN3Cidr(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterValue().equals(request.getAPPSN3Cidr());
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateCidr(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            if(para.getParameterKey() == null || para.getParameterValue() == null){
                return false;
            }
            return para.getParameterValue().equals(request.getCidr());
        }).findFirst();

        assert parameter.isPresent();
    }

    //names
    @Test
    public void testCreateAPPSN1CidrName(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterKey().equals("APPSN1Cidr");
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateAPPSN2CidrName(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterKey().equals("APPSN2Cidr");
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateAPPSN3CidrName(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterKey().equals("APPSN2Cidr");
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