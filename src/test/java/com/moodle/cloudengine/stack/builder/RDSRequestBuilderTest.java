package com.moodle.cloudengine.stack.builder;

import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.moodle.cloudengine.stack.request.RDSRequest;
import com.moodle.cloudengine.template.model.Templates;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by andrewlarsen on 5/8/17.
 */
public class RDSRequestBuilderTest {
    RDSRequestBuilder requestBuilder;
    RDSRequest request;
    @Before
    public void setup(){
        request = new RDSRequest();
        request.setTemplateBody("BODY");
        request.setTenant("TENANT");
        request.setTemplates(Templates.RDS);
        request.setDBSubnet1Name("Sub1");
        request.setDBSubnet2Name("Sub2");
        request.setDBInstance("DBInst");
        request.setDBName("DBName");
        request.setDBMasterUser("DBMasterUser");
        request.setDBMasterPassword("DBMasterPassword");
        request.setDBIsMultiZone("DBIsMultiZone");

        requestBuilder = new RDSRequestBuilder(request);

    }
    @Test
    public void createParameters() throws Exception {
        CreateStackRequest req =  requestBuilder.build();
        assertThat(req.getStackName(), is("TENANT-vpc"));
        assertThat(req.getTemplateBody(), is(request.getTemplateBody()));
    }

    @Test
    public void testCreateDBS1(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterValue().equals(request.getDBSubnet1Name());
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateDBS2(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterValue().equals(request.getDBSubnet2Name());
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateDBInstance(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterValue().equals(request.getDBInstance());
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateDBName(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterValue().equals(request.getDBName());
        }).findFirst();

        assert parameter.isPresent();
    }

    //names
    @Test
    public void testCreateDBMaster(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterKey().equals(request.getDBMasterPassword());
        }).findFirst();

        assert parameter.isPresent();
    }
    @Test
    public void testCreateDBUser(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterKey().equals(request.getDBMasterUser());
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
    public void testCreateDBMultiZOne(){
        CreateStackRequest req =  requestBuilder.build();
        Optional parameter = req.getParameters().stream().filter(para -> {
            return para.getParameterKey().equals(request.getDBIsMultiZone());
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