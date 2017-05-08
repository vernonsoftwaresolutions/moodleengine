package com.moodle.cloudengine.config;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.AmazonCloudFormationClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by andrewlarsen on 5/7/17.
 */
@Configuration
public class CloudFormationConfig {

    @Bean
    public AmazonCloudFormation cloudFormation(){
        return AmazonCloudFormationClientBuilder.defaultClient();
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
