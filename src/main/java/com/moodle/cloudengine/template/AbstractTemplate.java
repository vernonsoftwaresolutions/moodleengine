package com.moodle.cloudengine.template;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.AmazonCloudFormationClientBuilder;
import com.amazonaws.services.cloudformation.model.CreateStackResult;
import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.factory.StackRequestFactory;
import com.moodle.cloudengine.file.TemplateReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public abstract class AbstractTemplate {

    protected AmazonCloudFormation cloudFormation;
    protected StackRequestFactory factory;
    protected TemplateReader templateReader;
    public AbstractTemplate(StackRequestFactory factory, TemplateReader templateReader, AmazonCloudFormation cloudFormation){
        //todo-do i need anything other than default?
        this.cloudFormation = cloudFormation;
        this.factory = factory;
        this.templateReader = templateReader;
    }

    public abstract CreateStackResult buildStack() throws IOException, URISyntaxException;

}
