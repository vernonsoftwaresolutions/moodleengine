package com.moodle.cloudengine.stack.request;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class ECRequest extends Request {
    private String VPCName;
    private String MCSubnet1Name;

    public String getVPCName() {
        return VPCName;
    }

    public void setVPCName(String VPCName) {
        this.VPCName = VPCName;
    }

    public String getMCSubnet1Name() {
        return MCSubnet1Name;
    }

    public void setMCSubnet1Name(String MCSubnet1Name) {
        this.MCSubnet1Name = MCSubnet1Name;
    }
}
