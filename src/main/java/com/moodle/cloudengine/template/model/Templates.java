package com.moodle.cloudengine.template.model;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public enum Templates {

    VPC("vpc"),
    EFS("efs"),
    RDS("rds"),
    EC("ec");

    private String name;

    Templates(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
