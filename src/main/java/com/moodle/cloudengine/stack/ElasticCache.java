package com.moodle.cloudengine.stack;


import com.amazonaws.services.cloudformation.model.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class ElasticCache extends MoodleStack {
    private Parameter VPCName;
    private Parameter MCSubnet1Name;

    public Parameter getVPCName() {
        return VPCName;
    }

    public void setVPCName(Parameter VPCName) {
        this.VPCName = VPCName;
    }

    public Parameter getMCSubnet1Name() {
        return MCSubnet1Name;
    }

    public void setMCSubnet1Name(Parameter MCSubnet1Name) {
        this.MCSubnet1Name = MCSubnet1Name;
    }

    @Override
    public List<Parameter> getParameters() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(this.getMCSubnet1Name());
        parameters.add(this.getVPCName());
        parameters.add(this.getTenant());
        return parameters;
    }
}
