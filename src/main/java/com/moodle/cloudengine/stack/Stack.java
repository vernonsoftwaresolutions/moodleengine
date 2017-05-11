package com.moodle.cloudengine.stack;


import com.amazonaws.services.cloudformation.model.Parameter;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public abstract class Stack {

    private String templateBody;
    private Parameter tenant;

    public Parameter getTenant() {
        return tenant;
    }

    public void setTenant(Parameter tenant) {
        this.tenant = tenant;
    }

    public String getTemplateBody() {
        return templateBody;
    }

    public void setTemplateBody(String templateBody) {
        this.templateBody = templateBody;
    }


}
