package com.moodle.cloudengine.template;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.*;
import com.moodle.cloudengine.exception.MoodleStackException;
import com.moodle.cloudengine.stack.MoodleStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by andrewlarsen on 5/7/17.
 */
@Component
public class Template {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private AmazonCloudFormation cloudFormation;
    public Template(AmazonCloudFormation cloudFormation){
        this.cloudFormation = cloudFormation;
    }

    /**
     * Method to create stack in using AWS Cloudformation SDK
     * @param moodleStack
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public Stack buildStack(MoodleStack moodleStack)
            throws MoodleStackException, InterruptedException {
        String stackName =  moodleStack.getStackName();
        logger.debug("About to create stack with name ", stackName);
        CreateStackRequest stackRequest = new CreateStackRequest()
                .withCapabilities(Capability.CAPABILITY_IAM)
                .withStackName(stackName)
                .withParameters(moodleStack.getParameters())
                .withTemplateBody(moodleStack.getTemplateBody());

        //todo-if exists update?
        CreateStackResult result = this.cloudFormation.createStack(stackRequest);

        DescribeStacksResult status;
        StackStatus stackStatus;
        do {
            status = describeStack(result.getStackId());
            //todo-assume stack is one and only one result
            stackStatus = StackStatus.valueOf(status.getStacks().get(0).getStackStatus());
            logger.info("Stack {} is in status {} ", stackName, stackStatus);
            Thread.sleep(4000);
        } while(stackStatus.equals(StackStatus.CREATE_IN_PROGRESS));

        if(!stackStatus.equals(StackStatus.CREATE_COMPLETE)){
            logger.info("Error creating stack");
            //todo-delete after failure
            throw new MoodleStackException(status.getStacks().get(0).getStackStatusReason());
        }
        return status.getStacks().get(0);
    }

    /**
     * Method to return stack details
     * @param stackId
     * @return
     */
    private DescribeStacksResult describeStack(String stackId){
        logger.debug("Retrieving stack status with stackId ", stackId);
        DescribeStacksRequest request = new DescribeStacksRequest();
        request.setStackName(stackId);

        return this.cloudFormation.describeStacks(request);
    }

}
