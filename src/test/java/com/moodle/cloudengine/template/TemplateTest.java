package com.moodle.cloudengine.template;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.model.*;
import com.moodle.cloudengine.exception.MoodleStackException;
import com.moodle.cloudengine.stack.MoodleStack;
import com.moodle.cloudengine.stack.VPC;
import com.moodle.cloudengine.template.model.Templates;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

/**
 * Created by andrewlarsen on 5/17/17.
 */
public class TemplateTest {

    private Template template;

    @Mock
    AmazonCloudFormation amazonCloudFormation;

    private String stackId = "STACKID";
    private MoodleStack moodleStack;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        moodleStack = new VPC();
        template = new Template(amazonCloudFormation);
        moodleStack.setTemplates(Templates.VPC);
        moodleStack.setTenant(new Parameter().withParameterValue("STACK").withParameterKey("KEY"));
    }
    @Test
    public void buildStack() throws Exception {

        given(amazonCloudFormation.createStack(any())).willReturn(new CreateStackResult()
        .withStackId(stackId));

        given(amazonCloudFormation.describeStacks(new DescribeStacksRequest().withStackName(stackId)))
        .willReturn(new DescribeStacksResult().withStacks(new Stack().withStackStatus(StackStatus.CREATE_COMPLETE)
        .withStackId(stackId)));

        Stack stack = template.buildStack(moodleStack);

        assertThat(stack.getStackId(), is(stackId));

    }
    @Test(expected = MoodleStackException.class)
    public void buildStackException() throws Exception {

        given(amazonCloudFormation.createStack(any())).willReturn(new CreateStackResult()
                .withStackId(stackId));

        given(amazonCloudFormation.describeStacks(new DescribeStacksRequest().withStackName(stackId)))
                .willReturn(new DescribeStacksResult().withStacks(new Stack().withStackStatus(StackStatus.CREATE_FAILED)
                        .withStackId(stackId)));

        Stack stack = template.buildStack(moodleStack);

        assertThat(stack.getStackId(), is(stackId));

    }
    @Test(expected = MoodleStackException.class)
    public void buildStackRollBackException() throws Exception {

        given(amazonCloudFormation.createStack(any())).willReturn(new CreateStackResult()
                .withStackId(stackId));

        given(amazonCloudFormation.describeStacks(new DescribeStacksRequest().withStackName(stackId)))
                .willReturn(new DescribeStacksResult().withStacks(new Stack().withStackStatus(StackStatus.ROLLBACK_FAILED)
                        .withStackId(stackId)));

        Stack stack = template.buildStack(moodleStack);

        assertThat(stack.getStackId(), is(stackId));

    }
    @Test(expected = MoodleStackException.class)
    public void buildStackInProgressThenException() throws Exception {

        given(amazonCloudFormation.createStack(any())).willReturn(new CreateStackResult()
                .withStackId(stackId));
        given(amazonCloudFormation.describeStacks(new DescribeStacksRequest().withStackName(stackId)))
                .willReturn(new DescribeStacksResult().withStacks(new Stack().withStackStatus(StackStatus.CREATE_IN_PROGRESS)
                        .withStackId(stackId)));

        given(amazonCloudFormation.describeStacks(new DescribeStacksRequest().withStackName(stackId)))
                .willReturn(new DescribeStacksResult().withStacks(new Stack().withStackStatus(StackStatus.CREATE_FAILED)
                        .withStackId(stackId)));

        Stack stack = template.buildStack(moodleStack);

        assertThat(stack.getStackId(), is(stackId));

    }
}