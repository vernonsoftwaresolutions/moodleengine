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
            add("192.168.32.0/28");
            add("192.168.33.0/28");
            add("192.168.34.0/28");
            add("192.168.35.0/28");
            add("192.168.36.0/28");
            add("192.168.37.0/28");
            add("192.168.38.0/28");
            add("192.168.39.0/28");
            add("192.168.40.0/28");
            add("192.168.41.0/28");
            add("192.168.42.0/28");
            add("192.168.43.0/28");
            add("192.168.44.0/28");
            add("192.168.45.0/28");
            add("192.168.46.0/28");
            add("192.168.47.0/28");

        }};


    }
}
