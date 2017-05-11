package com.moodle.cloudengine.stack;


import com.amazonaws.services.cloudformation.model.Parameter;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class EFS extends Stack {
    private Parameter VPCName;
    private Parameter EFSubnet1Name;
    private Parameter EFSubnet2Name;
    private Parameter EFSubnet3Name;

    public Parameter getVPCName() {
        return VPCName;
    }

    public void setVPCName(Parameter VPCName) {
        this.VPCName = VPCName;
    }

    public Parameter getEFSubnet1Name() {
        return EFSubnet1Name;
    }

    public void setEFSubnet1Name(Parameter EFSubnet1Name) {
        this.EFSubnet1Name = EFSubnet1Name;
    }

    public Parameter getEFSubnet2Name() {
        return EFSubnet2Name;
    }

    public void setEFSubnet2Name(Parameter EFSubnet2Name) {
        this.EFSubnet2Name = EFSubnet2Name;
    }

    public Parameter getEFSubnet3Name() {
        return EFSubnet3Name;
    }

    public void setEFSubnet3Name(Parameter EFSubnet3Name) {
        this.EFSubnet3Name = EFSubnet3Name;
    }
}
