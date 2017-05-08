package com.moodle.cloudengine.stack.request;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class RDSRequest extends Request {
    
    private String DBSubnet1Name;
    private String DBSubnet2Name;
    private String DBInstance;
    private String DBName;
    private String DBMasterUser;
    private String DBMasterPassword;
    private String DBIsMultiZone;

    public String getDBSubnet1Name() {
        return DBSubnet1Name;
    }

    public void setDBSubnet1Name(String DBSubnet1Name) {
        this.DBSubnet1Name = DBSubnet1Name;
    }

    public String getDBSubnet2Name() {
        return DBSubnet2Name;
    }

    public void setDBSubnet2Name(String DBSubnet2Name) {
        this.DBSubnet2Name = DBSubnet2Name;
    }

    public String getDBInstance() {
        return DBInstance;
    }

    public void setDBInstance(String DBInstance) {
        this.DBInstance = DBInstance;
    }

    public String getDBName() {
        return DBName;
    }

    public void setDBName(String DBName) {
        this.DBName = DBName;
    }

    public String getDBMasterUser() {
        return DBMasterUser;
    }

    public void setDBMasterUser(String DBMasterUser) {
        this.DBMasterUser = DBMasterUser;
    }

    public String getDBMasterPassword() {
        return DBMasterPassword;
    }

    public void setDBMasterPassword(String DBMasterPassword) {
        this.DBMasterPassword = DBMasterPassword;
    }

    public String getDBIsMultiZone() {
        return DBIsMultiZone;
    }

    public void setDBIsMultiZone(String DBIsMultiZone) {
        this.DBIsMultiZone = DBIsMultiZone;
    }
}
