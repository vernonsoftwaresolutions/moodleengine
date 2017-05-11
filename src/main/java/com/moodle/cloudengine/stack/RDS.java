package com.moodle.cloudengine.stack;


import com.amazonaws.services.cloudformation.model.Parameter;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class RDS extends Stack {
    
    private Parameter DBSubnet1Name;
    private Parameter DBSubnet2Name;
    private Parameter DBInstance;
    private Parameter DBName;
    private Parameter DBMasterUser;
    private Parameter DBMasterPassword;
    private Parameter DBIsMultiZone;

    public Parameter getDBSubnet1Name() {
        return DBSubnet1Name;
    }

    public void setDBSubnet1Name(Parameter DBSubnet1Name) {
        this.DBSubnet1Name = DBSubnet1Name;
    }

    public Parameter getDBSubnet2Name() {
        return DBSubnet2Name;
    }

    public void setDBSubnet2Name(Parameter DBSubnet2Name) {
        this.DBSubnet2Name = DBSubnet2Name;
    }

    public Parameter getDBInstance() {
        return DBInstance;
    }

    public void setDBInstance(Parameter DBInstance) {
        this.DBInstance = DBInstance;
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

    public Parameter getDBIsMultiZone() {
        return DBIsMultiZone;
    }

    public void setDBIsMultiZone(Parameter DBIsMultiZone) {
        this.DBIsMultiZone = DBIsMultiZone;
    }
}
