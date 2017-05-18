package com.moodle.cloudengine.ip;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewlarsen on 5/10/17.
 */
@Component
public class IPProvisioner {



    public List<String> getCidrBlock(int bits){
        //32 - bits
        return new ArrayList<String>(){{
            add("10.0.1.0/28");
            add("10.0.2.0/28");
            add("10.0.3.0/28");
            add("10.0.4.0/28");
            add("10.0.5.0/28");
            add("10.0.6.0/28");
            add("10.0.7.0/28");
            add("10.0.8.0/28");
            add("10.0.9.0/28");
            add("10.0.10.0/28");
            add("10.0.11.0/28");
            add("10.0.12.0/28");
            add("10.0.13.0/28");
            add("10.0.14.0/28");
            add("10.0.15.0/28");
            add("10.0.16.0/28");

        }};


    }
}
