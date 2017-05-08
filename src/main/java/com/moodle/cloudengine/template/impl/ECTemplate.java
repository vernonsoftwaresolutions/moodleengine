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
public class ECTemplate extends AbstractTemplate {
    private static String EC_TEMPLATE = "ec_memcached_template.yaml";

    private Parameter VPCName;
    private Parameter MCSubnet1Name;
    private Parameter tenant;

    public ECTemplate(StackRequestFactory factory, TemplateReader templateReader, AmazonCloudFormation cloudFormation){
        super(factory, templateReader, cloudFormation);
    }

    @Override
    public CreateStackResult buildStack() throws IOException, URISyntaxException {
        //create stack name
        String stackName = tenant.getParameterValue() + "-vpc";
        //create parameters
        List<Parameter> parameters = createParameters();
        //create template
        String template = templateReader.getFileAsString(EC_TEMPLATE);
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
        parameters.add(this.VPCName);
        parameters.add(this.tenant);
        parameters.add(this.MCSubnet1Name);
        return parameters;
    }
    public void setVPCName(Parameter VPCName) {
        this.VPCName = VPCName;
    }

    public void setMCSubnet1Name(Parameter MCSubnet1Name) {
        this.MCSubnet1Name = MCSubnet1Name;
    }

    public void setTenant(Parameter tenant) {
        this.tenant = tenant;
    }
}
