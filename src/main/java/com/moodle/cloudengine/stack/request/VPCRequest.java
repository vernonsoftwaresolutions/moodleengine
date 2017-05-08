package com.moodle.cloudengine.stack.request;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class VPCRequest extends Request{
    private String cidr;
    private String WSSN1Cidr;
    private String WSSN2Cidr;
    private String WSSN3Cidr;
    private String APPSN1Cidr;
    private String APPSN2Cidr;
    private String APPSN3Cidr;
    private String EFSN1Cidr;
    private String EFSN2Cidr;
    private String EFSN3Cidr;
    private String DBSN1Cidr;
    private String DBSN2Cidr;
    private String MCSN1Cidr;


    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public String getWSSN1Cidr() {
        return WSSN1Cidr;
    }

    public void setWSSN1Cidr(String WSSN1Cidr) {
        this.WSSN1Cidr = WSSN1Cidr;
    }

    public String getWSSN2Cidr() {
        return WSSN2Cidr;
    }

    public void setWSSN2Cidr(String WSSN2Cidr) {
        this.WSSN2Cidr = WSSN2Cidr;
    }

    public String getWSSN3Cidr() {
        return WSSN3Cidr;
    }

    public void setWSSN3Cidr(String WSSN3Cidr) {
        this.WSSN3Cidr = WSSN3Cidr;
    }

    public String getAPPSN1Cidr() {
        return APPSN1Cidr;
    }

    public void setAPPSN1Cidr(String APPSN1Cidr) {
        this.APPSN1Cidr = APPSN1Cidr;
    }

    public String getAPPSN2Cidr() {
        return APPSN2Cidr;
    }

    public void setAPPSN2Cidr(String APPSN2Cidr) {
        this.APPSN2Cidr = APPSN2Cidr;
    }

    public String getAPPSN3Cidr() {
        return APPSN3Cidr;
    }

    public void setAPPSN3Cidr(String APPSN3Cidr) {
        this.APPSN3Cidr = APPSN3Cidr;
    }

    public String getEFSN1Cidr() {
        return EFSN1Cidr;
    }

    public void setEFSN1Cidr(String EFSN1Cidr) {
        this.EFSN1Cidr = EFSN1Cidr;
    }

    public String getEFSN2Cidr() {
        return EFSN2Cidr;
    }

    public void setEFSN2Cidr(String EFSN2Cidr) {
        this.EFSN2Cidr = EFSN2Cidr;
    }

    public String getEFSN3Cidr() {
        return EFSN3Cidr;
    }

    public void setEFSN3Cidr(String EFSN3Cidr) {
        this.EFSN3Cidr = EFSN3Cidr;
    }

    public String getDBSN1Cidr() {
        return DBSN1Cidr;
    }

    public void setDBSN1Cidr(String DBSN1Cidr) {
        this.DBSN1Cidr = DBSN1Cidr;
    }

    public String getDBSN2Cidr() {
        return DBSN2Cidr;
    }

    public void setDBSN2Cidr(String DBSN2Cidr) {
        this.DBSN2Cidr = DBSN2Cidr;
    }

    public String getMCSN1Cidr() {
        return MCSN1Cidr;
    }

    public void setMCSN1Cidr(String MCSN1Cidr) {
        this.MCSN1Cidr = MCSN1Cidr;
    }
}
