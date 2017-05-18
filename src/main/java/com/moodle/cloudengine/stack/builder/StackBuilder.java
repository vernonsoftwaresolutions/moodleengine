package com.moodle.cloudengine.stack.builder;

import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.stack.MoodleStack;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public abstract class StackBuilder {

    protected Parameter createParameter(String key, String value){
        return new Parameter()
                .withParameterKey(key)
                .withParameterValue(value);
    }


    public abstract MoodleStack build();

}
