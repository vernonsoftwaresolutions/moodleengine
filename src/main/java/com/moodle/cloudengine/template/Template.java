package com.moodle.cloudengine.template;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.CreateStackResult;
import com.moodle.cloudengine.stack.Stack;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by andrewlarsen on 5/7/17.
 */
@Component
public class Template {

    private AmazonCloudFormation cloudFormation;

    public Template( AmazonCloudFormation cloudFormation){
        //todo-do i need anything other than default?
        this.cloudFormation = cloudFormation;
    }

    public CreateStackResult buildStack(Stack stack)
            throws IOException, URISyntaxException {
        //create stack
       // StackBuilder builder = StackBuilderFactory.getBuilder(stack);
       // return this.cloudFormation.createStack(builder.build());
        return null;
    }
}
