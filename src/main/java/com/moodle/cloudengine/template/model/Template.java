package com.moodle.cloudengine.template.model;

import java.util.Map;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class Template {

    private String AWSTemplateFormatVersion;
    private Map<String, Map> Parameters;
    private Map<String, Map> Resources;
    private Map<String, Map> Outputs;
    private Map<String, Map> Mappings;

    public Map<String, Map> getMappings() {
        return Mappings;
    }

    public void setMappings(Map<String, Map> mappings) {
        Mappings = mappings;
    }

    public String getAWSTemplateFormatVersion() {
        return AWSTemplateFormatVersion;
    }

    public void setAWSTemplateFormatVersion(String AWSTemplateFormatVersion) {
        this.AWSTemplateFormatVersion = AWSTemplateFormatVersion;
    }

    public Map<String, Map> getParameters() {
        return Parameters;
    }

    public void setParameters(Map<String, Map> parameters) {
        Parameters = parameters;
    }

    public Map<String, Map> getResources() {
        return Resources;
    }

    public void setResources(Map<String, Map> resources) {
        Resources = resources;
    }

    public Map<String, Map> getOutputs() {
        return Outputs;
    }

    public void setOutputs(Map<String, Map> outputs) {
        Outputs = outputs;
    }
}
