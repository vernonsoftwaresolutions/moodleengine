package com.moodle.cloudengine.sqs;

/**
 * Created by andrewlarsen on 6/4/17.
 */
public class SQSMessage {

    private String tenant;

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    @Override
    public String toString() {
        return "SQSMessage{" +
                "tenant='" + tenant + '\'' +
                '}';
    }
}
