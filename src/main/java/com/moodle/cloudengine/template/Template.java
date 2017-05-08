package com.moodle.cloudengine.template;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.CreateStackResult;
import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.file.TemplateReader;
import com.moodle.cloudengine.stack.StackRequestFactory;
import com.moodle.cloudengine.stack.builder.StackRequestBuilder;
import com.moodle.cloudengine.stack.request.Request;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
@Component
public class Template {

    private List<Parameter> parameters;

    private AmazonCloudFormation cloudFormation;
    private TemplateReader templateReader;

    public Template(TemplateReader templateReader, AmazonCloudFormation cloudFormation){
        //todo-do i need anything other than default?
        this.cloudFormation = cloudFormation;
        this.templateReader = templateReader;
    }

    public CreateStackResult buildStack(Request request)
            throws IOException, URISyntaxException {
        //create request
        StackRequestBuilder builder = StackRequestFactory.getBuilder(request);
        return this.cloudFormation.createStack(builder.build());
    }
}
