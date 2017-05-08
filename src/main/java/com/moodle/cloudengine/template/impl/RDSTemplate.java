package com.moodle.cloudengine.template.impl;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.amazonaws.services.cloudformation.model.CreateStackResult;
import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.factory.StackRequestFactory;
import com.moodle.cloudengine.file.TemplateReader;
import com.moodle.cloudengine.template.AbstractTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class RDSTemplate extends AbstractTemplate {
    private static String RDS_TEMPLATE = "rds_db_template.yaml";

    private Parameter DBSubnet1Name;
    private Parameter DBSubnet2Name;
    private Parameter tenant;
    private Parameter DBInstance;
    private Parameter DBName;
    private Parameter DBMasterUser;
    private Parameter DBMasterPassword;
    private Parameter DBIsMultiZone;

    public RDSTemplate(StackRequestFactory factory, TemplateReader templateReader, AmazonCloudFormation cloudFormation){
        super(factory, templateReader, cloudFormation);
    }
    @Override
    public CreateStackResult buildStack() throws IOException, URISyntaxException {
        //create stack name
        String stackName = tenant.getParameterValue() + "-vpc";
        //create parameters
        List<Parameter> parameters = createParameters();
        //create template
        String template = templateReader.getFileAsString(RDS_TEMPLATE);
        //create request
        CreateStackRequest request = factory.createStackRequest(stackName, parameters, template);
        return this.cloudFormation.createStack(request);
    }


    /**
     * Add parameters to parameter list
     * @return
     */
    private List<Parameter> createParameters(){
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(this.DBSubnet1Name);
        parameters.add(this.DBSubnet2Name);
        parameters.add(this.tenant);
        parameters.add(this.DBInstance);
        parameters.add(this.DBName);
        parameters.add(this.DBMasterUser);
        parameters.add(this.DBMasterPassword);
        parameters.add(this.DBIsMultiZone);
        return parameters;
    }

    public void setDBSubnet1Name(Parameter DBSubnet1Name) {
        this.DBSubnet1Name = DBSubnet1Name;
    }

    public void setDBSubnet2Name(Parameter DBSubnet2Name) {
        this.DBSubnet2Name = DBSubnet2Name;
    }

    public void setTenant(Parameter tenant) {
        this.tenant= tenant;
    }

    public void setDBInstance(Parameter DBInstance) {
        this.DBInstance = DBInstance;
    }

    public void setDBName(Parameter DBName) {
        this.DBName = DBName;
    }

    public void setDBMasterUser(Parameter DBMasterUser) {
        this.DBMasterUser = DBMasterUser;
    }

    public void setDBMasterPassword(Parameter DBMasterPassword) {
        this.DBMasterPassword = DBMasterPassword;
    }

    public void setDBIsMultiZone(Parameter DBIsMultiZone) {
        this.DBIsMultiZone = DBIsMultiZone;
    }
}
