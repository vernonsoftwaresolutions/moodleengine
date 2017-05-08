package com.moodle.cloudengine.template.impl;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.amazonaws.services.cloudformation.model.CreateStackResult;
import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.factory.StackRequestFactory;
import com.moodle.cloudengine.file.TemplateReader;
import com.moodle.cloudengine.template.AbstractTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
@Component
public class VPCTemplate extends AbstractTemplate {

    private static final String VPC_TEMPLATE = "vpc_template.yaml";
    private Regions region;
    private Parameter tenant;
    private Parameter cidr;
    private Parameter WSSN1Cidr;
    private Parameter WSSN2Cidr;
    private Parameter WSSN3Cidr;
    private Parameter APPSN1Cidr;
    private Parameter APPSN2Cidr;
    private Parameter APPSN3Cidr;
    private Parameter EFSN1Cidr;
    private Parameter EFSN2Cidr;
    private Parameter EFSN3Cidr;
    private Parameter DBSN1Cidr;
    private Parameter DBSN2Cidr;
    private Parameter MCSN1Cidr;

    public VPCTemplate(StackRequestFactory factory, TemplateReader templateReader, AmazonCloudFormation cloudFormation){
        super(factory, templateReader, cloudFormation);
    }

    @Override
    public CreateStackResult buildStack() throws IOException, URISyntaxException {
        //create stack name
        String stackName = tenant.getParameterValue() + "-vpc";
        //create parameters
        List<Parameter> parameters = createParameters();
        //create template
        String template = templateReader.getFileAsString(VPC_TEMPLATE);
        //create request
        CreateStackRequest request = factory.createStackRequest(stackName, parameters, template);
        //create stack
        return this.cloudFormation.createStack(request);
    }

    /**
     * Add parameters to parameter list
     * @return
     */
    private List<Parameter> createParameters(){
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(this.APPSN1Cidr);
        parameters.add(this.APPSN2Cidr);
        parameters.add(this.APPSN3Cidr);
        parameters.add(this.DBSN1Cidr);
        parameters.add(this.DBSN2Cidr);
        parameters.add(this.EFSN1Cidr);
        parameters.add(this.EFSN2Cidr);
        parameters.add(this.EFSN3Cidr);
        parameters.add(this.MCSN1Cidr);
        parameters.add(this.WSSN1Cidr);
        parameters.add(this.WSSN2Cidr);
        parameters.add(this.WSSN3Cidr);
        parameters.add(this.cidr);
        parameters.add(this.tenant);
        return parameters;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public void setTenant(Parameter tenant) {
        this.tenant = tenant;
    }

    public void setCidr(Parameter cidr) {
        this.cidr = cidr;
    }

    public void setWSSN1Cidr(Parameter WSSN1Cidr) {
        this.WSSN1Cidr = WSSN1Cidr;
    }

    public void setWSSN2Cidr(Parameter WSSN2Cidr) {
        this.WSSN2Cidr = WSSN2Cidr;
    }

    public void setWSSN3Cidr(Parameter WSSN3Cidr) {
        this.WSSN3Cidr = WSSN3Cidr;
    }

    public void setAPPSN1Cidr(Parameter APPSN1Cidr) {
        this.APPSN1Cidr = APPSN1Cidr;
    }

    public void setAPPSN2Cidr(Parameter APPSN2Cidr) {
        this.APPSN2Cidr = APPSN2Cidr;
    }

    public void setAPPSN3Cidr(Parameter APPSN3Cidr) {
        this.APPSN3Cidr = APPSN3Cidr;
    }

    public void setEFSN1Cidr(Parameter EFSN1Cidr) {
        this.EFSN1Cidr = EFSN1Cidr;
    }

    public void setEFSN2Cidr(Parameter EFSN2Cidr) {
        this.EFSN2Cidr = EFSN2Cidr;
    }

    public void setEFSN3Cidr(Parameter EFSN3Cidr) {
        this.EFSN3Cidr = EFSN3Cidr;
    }

    public void setDBSN1Cidr(Parameter DBSN1Cidr) {
        this.DBSN1Cidr = DBSN1Cidr;
    }

    public void setDBSN2Cidr(Parameter DBSN2Cidr) {
        this.DBSN2Cidr = DBSN2Cidr;
    }

    public void setMCSN1Cidr(Parameter MCSN1Cidr) {
        this.MCSN1Cidr = MCSN1Cidr;
    }
}
