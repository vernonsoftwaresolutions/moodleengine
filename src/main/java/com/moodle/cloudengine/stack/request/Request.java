package com.moodle.cloudengine.stack.request;

import com.moodle.cloudengine.template.model.Templates;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public abstract class Request {

    private Templates templates;
    private String templateBody;
    private String tenant;

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
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
