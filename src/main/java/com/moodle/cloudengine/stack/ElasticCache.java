package com.moodle.cloudengine.stack;


import com.amazonaws.services.cloudformation.model.Parameter;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class ElasticCache extends Stack {
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
}
