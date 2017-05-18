package com.moodle.cloudengine.stack;


import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.template.model.Templates;

import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public abstract class MoodleStack {

    private Templates templates;
    private String templateBody;
    private Parameter tenant;

    public String getStackName(){
        return this.getTemplates().getName() + this.getTenant().getParameterValue();
    }
    public abstract List<Parameter> getParameters();

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

    public Templates getTemplates() {
        return templates;
    }

    public void setTemplates(Templates templates) {
        this.templates = templates;
    }
}
