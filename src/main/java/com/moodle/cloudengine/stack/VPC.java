package com.moodle.cloudengine.stack;

import com.amazonaws.services.cloudformation.model.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class VPC extends MoodleStack {

    private Parameter name;
    private Parameter publicRouteTable;
    private Parameter privateRouteTable;
    private Parameter cidr;
    private Parameter WSSN1Cidr;
    private Parameter WSSN2Cidr;
    private Parameter WSSN3Cidr;
    private Parameter APPSN1Cidr;
    private Parameter APPSN2Cidr;
    private Parameter APPSN3Cidr;
    private Parameter EFSN1Cidr;
    private Parameter EFSN2Cidr;
    private Parameter EFSN3Cidr;
    private Parameter DBSN1Cidr;
    private Parameter DBSN2Cidr;
    private Parameter MCSN1Cidr;


    public Parameter getCidr() {
        return cidr;
    }

    public void setCidr(Parameter cidr) {
        this.cidr = cidr;
    }

    public Parameter getWSSN1Cidr() {
        return WSSN1Cidr;
    }

    public void setWSSN1Cidr(Parameter WSSN1Cidr) {
        this.WSSN1Cidr = WSSN1Cidr;
    }

    public Parameter getWSSN2Cidr() {
        return WSSN2Cidr;
    }

    public void setWSSN2Cidr(Parameter WSSN2Cidr) {
        this.WSSN2Cidr = WSSN2Cidr;
    }

    public Parameter getWSSN3Cidr() {
        return WSSN3Cidr;
    }

    public void setWSSN3Cidr(Parameter WSSN3Cidr) {
        this.WSSN3Cidr = WSSN3Cidr;
    }

    public Parameter getAPPSN1Cidr() {
        return APPSN1Cidr;
    }

    public void setAPPSN1Cidr(Parameter APPSN1Cidr) {
        this.APPSN1Cidr = APPSN1Cidr;
    }

    public Parameter getAPPSN2Cidr() {
        return APPSN2Cidr;
    }

    public void setAPPSN2Cidr(Parameter APPSN2Cidr) {
        this.APPSN2Cidr = APPSN2Cidr;
    }

    public Parameter getAPPSN3Cidr() {
        return APPSN3Cidr;
    }

    public void setAPPSN3Cidr(Parameter APPSN3Cidr) {
        this.APPSN3Cidr = APPSN3Cidr;
    }

    public Parameter getEFSN1Cidr() {
        return EFSN1Cidr;
    }

    public void setEFSN1Cidr(Parameter EFSN1Cidr) {
        this.EFSN1Cidr = EFSN1Cidr;
    }

    public Parameter getEFSN2Cidr() {
        return EFSN2Cidr;
    }

    public void setEFSN2Cidr(Parameter EFSN2Cidr) {
        this.EFSN2Cidr = EFSN2Cidr;
    }

    public Parameter getEFSN3Cidr() {
        return EFSN3Cidr;
    }

    public void setEFSN3Cidr(Parameter EFSN3Cidr) {
        this.EFSN3Cidr = EFSN3Cidr;
    }

    public Parameter getDBSN1Cidr() {
        return DBSN1Cidr;
    }

    public void setDBSN1Cidr(Parameter DBSN1Cidr) {
        this.DBSN1Cidr = DBSN1Cidr;
    }

    public Parameter getDBSN2Cidr() {
        return DBSN2Cidr;
    }

    public void setDBSN2Cidr(Parameter DBSN2Cidr) {
        this.DBSN2Cidr = DBSN2Cidr;
    }

    public Parameter getMCSN1Cidr() {
        return MCSN1Cidr;
    }

    public void setMCSN1Cidr(Parameter MCSN1Cidr) {
        this.MCSN1Cidr = MCSN1Cidr;
    }

    public Parameter getName() {
        return name;
    }

    public void setName(Parameter name) {
        this.name = name;
    }

    public Parameter getPublicRouteTable() {
        return publicRouteTable;
    }

    public void setPublicRouteTable(Parameter publicRouteTable) {
        this.publicRouteTable = publicRouteTable;
    }

    public Parameter getPrivateRouteTable() {
        return privateRouteTable;
    }

    public void setPrivateRouteTable(Parameter privateRouteTable) {
        this.privateRouteTable = privateRouteTable;
    }

    @Override
    public List<Parameter> getParameters() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(this.getPrivateRouteTable());
        parameters.add(this.getPublicRouteTable());
        parameters.add(this.getAPPSN1Cidr());
        parameters.add(this.getAPPSN2Cidr());
        parameters.add(this.getAPPSN3Cidr());
        parameters.add(this.getCidr());
        parameters.add(this.getDBSN1Cidr());
        parameters.add(this.getDBSN2Cidr());
        parameters.add(this.getEFSN1Cidr());
        parameters.add(this.getEFSN2Cidr());
        parameters.add(this.getEFSN3Cidr());
        parameters.add(this.getMCSN1Cidr());
        parameters.add(this.getWSSN1Cidr());
        parameters.add(this.getWSSN2Cidr());
        parameters.add(this.getWSSN3Cidr());
        parameters.add(this.getTenant());
        parameters.add(this.getName());
        return parameters;
    }
}
