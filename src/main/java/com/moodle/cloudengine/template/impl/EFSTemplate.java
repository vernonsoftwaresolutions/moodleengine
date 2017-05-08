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
public class EFSTemplate extends AbstractTemplate {
    private static String EFS_TEMPLATE = "efs_mount_template.yaml";

    private Parameter VPCName;
    private Parameter EFSubnet1Name;
    private Parameter EFSubnet2Name;
    private Parameter EFSubnet3Name;
    private Parameter tenant;
    public EFSTemplate(StackRequestFactory factory, TemplateReader templateReader, AmazonCloudFormation cloudFormation){
        super(factory, templateReader, cloudFormation);
    }
    @Override
    public CreateStackResult buildStack() throws IOException, URISyntaxException {
        //create stack name
        String stackName = tenant.getParameterValue() + "-vpc";
        //create parameters
        List<Parameter> parameters = createParameters();
        //create template
        String template = templateReader.getFileAsString(EFS_TEMPLATE);
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
        parameters.add(this.EFSubnet1Name);
        parameters.add(this.tenant);
        parameters.add(this.EFSubnet2Name);
        parameters.add(this.EFSubnet3Name);
        return parameters;
    }
    public void setVPCName(Parameter VPCName) {
        this.VPCName = VPCName;
    }

    public void setEFSubnet1Name(Parameter EFSubnet1Name) {
        this.EFSubnet1Name = EFSubnet1Name;
    }

    public void setEFSubnet2Name(Parameter EFSubnet2Name) {
        this.EFSubnet2Name = EFSubnet2Name;
    }

    public void setEFSubnet3Name(Parameter EFSubnet3Name) {
        this.EFSubnet3Name = EFSubnet3Name;
    }

    public void setTenant(Parameter tenant) {
        this.tenant = tenant;
    }
}
