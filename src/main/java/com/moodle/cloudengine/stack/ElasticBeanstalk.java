package com.moodle.cloudengine.stack;

import com.amazonaws.services.cloudformation.model.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewlarsen on 5/17/17.
 */
public class ElasticBeanstalk extends MoodleStack {

    private Parameter VPCName;
    private Parameter MoodleBucket;
    private Parameter MoodleVersion;
    private Parameter APPSubnet1Name;
    private Parameter APPSubnet2Name;
    private Parameter APPSubnet3Name;
    private Parameter WSSubnet1Name;
    private Parameter WSSubnet2Name;
    private Parameter WSSubnet3Name;
    private Parameter DBName;
    private Parameter DBMasterUser;
    private Parameter DBMasterPassword;
    private Parameter DBUrl;
    private Parameter EBEC2Role;
    private Parameter EBServiceRole;
    @Override
    public List<Parameter> getParameters() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(this.VPCName);
        parameters.add(this.tenant);
        parameters.add(this.MoodleBucket);
        parameters.add(this.MoodleVersion);
        parameters.add(this.APPSubnet1Name);
        parameters.add(this.APPSubnet2Name);
        parameters.add(this.APPSubnet3Name);
        parameters.add(this.WSSubnet1Name);
        parameters.add(this.WSSubnet2Name);
        parameters.add(this.WSSubnet3Name);
        parameters.add(this.DBName);
        parameters.add(this.DBMasterUser);
        parameters.add(this.DBMasterPassword);
        parameters.add(this.DBUrl);
        parameters.add(this.EBEC2Role);
        parameters.add(this.EBServiceRole);
        return parameters;
    }
    public Parameter getVPCName() {
        return VPCName;
    }

    public void setVPCName(Parameter VPCName) {
        this.VPCName = VPCName;
    }

    public Parameter getEBServiceRole() {
        return EBServiceRole;
    }

    public void setEBServiceRole(Parameter EBServiceRole) {
        this.EBServiceRole = EBServiceRole;
    }

    public Parameter getMoodleBucket() {
        return MoodleBucket;
    }

    public void setMoodleBucket(Parameter moodleBucket) {
        MoodleBucket = moodleBucket;
    }

    public Parameter getMoodleVersion() {
        return MoodleVersion;
    }

    public void setMoodleVersion(Parameter moodleVersion) {
        MoodleVersion = moodleVersion;
    }

    public Parameter getAPPSubnet1Name() {
        return APPSubnet1Name;
    }

    public void setAPPSubnet1Name(Parameter APPSubnet1Name) {
        this.APPSubnet1Name = APPSubnet1Name;
    }

    public Parameter getAPPSubnet2Name() {
        return APPSubnet2Name;
    }

    public void setAPPSubnet2Name(Parameter APPSubnet2Name) {
        this.APPSubnet2Name = APPSubnet2Name;
    }

    public Parameter getAPPSubnet3Name() {
        return APPSubnet3Name;
    }

    public void setAPPSubnet3Name(Parameter APPSubnet3Name) {
        this.APPSubnet3Name = APPSubnet3Name;
    }

    public Parameter getWSSubnet1Name() {
        return WSSubnet1Name;
    }

    public void setWSSubnet1Name(Parameter WSSubnet1Name) {
        this.WSSubnet1Name = WSSubnet1Name;
    }

    public Parameter getWSSubnet2Name() {
        return WSSubnet2Name;
    }

    public void setWSSubnet2Name(Parameter WSSubnet2Name) {
        this.WSSubnet2Name = WSSubnet2Name;
    }

    public Parameter getWSSubnet3Name() {
        return WSSubnet3Name;
    }

    public void setWSSubnet3Name(Parameter WSSubnet3Name) {
        this.WSSubnet3Name = WSSubnet3Name;
    }

    public Parameter getDBName() {
        return DBName;
    }

    public void setDBName(Parameter DBName) {
        this.DBName = DBName;
    }

    public Parameter getDBMasterUser() {
        return DBMasterUser;
    }

    public void setDBMasterUser(Parameter DBMasterUser) {
        this.DBMasterUser = DBMasterUser;
    }

    public Parameter getDBMasterPassword() {
        return DBMasterPassword;
    }

    public void setDBMasterPassword(Parameter DBMasterPassword) {
        this.DBMasterPassword = DBMasterPassword;
    }

    public Parameter getDBUrl() {
        return DBUrl;
    }

    public void setDBUrl(Parameter DBUrl) {
        this.DBUrl = DBUrl;
    }

    public Parameter getEBEC2Role() {
        return EBEC2Role;
    }

    public void setEBEC2Role(Parameter EBEC2Role) {
        this.EBEC2Role = EBEC2Role;
    }
}
