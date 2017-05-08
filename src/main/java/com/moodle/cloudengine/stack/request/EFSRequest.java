package com.moodle.cloudengine.stack.request;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class EFSRequest extends Request{
    private String VPCName;
    private String EFSubnet1Name;
    private String EFSubnet2Name;
    private String EFSubnet3Name;

    public String getVPCName() {
        return VPCName;
    }

    public void setVPCName(String VPCName) {
        this.VPCName = VPCName;
    }

    public String getEFSubnet1Name() {
        return EFSubnet1Name;
    }

    public void setEFSubnet1Name(String EFSubnet1Name) {
        this.EFSubnet1Name = EFSubnet1Name;
    }

    public String getEFSubnet2Name() {
        return EFSubnet2Name;
    }

    public void setEFSubnet2Name(String EFSubnet2Name) {
        this.EFSubnet2Name = EFSubnet2Name;
    }

    public String getEFSubnet3Name() {
        return EFSubnet3Name;
    }

    public void setEFSubnet3Name(String EFSubnet3Name) {
        this.EFSubnet3Name = EFSubnet3Name;
    }
}
