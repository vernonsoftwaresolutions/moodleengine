package com.moodle.cloudengine.stack;

import com.moodle.cloudengine.stack.builder.*;
import com.moodle.cloudengine.stack.request.Request;


/**
 * Created by andrewlarsen on 5/7/17.
 */
public class StackRequestFactory {


    public static StackRequestBuilder getBuilder(Request request){

        StackRequestBuilder builder = null;
        switch (request.getTemplates()){
            case VPC:
                builder = new VPCRequestBuilder(request);
                break;
            case RDS:
                builder = new RDSRequestBuilder(request);
                break;
            case EFS:
                builder = new EFSRequestBuilder(request);
                break;
            case EC:
                builder = new ECRequestBuilder(request);
                break;
            default:
                throw new IllegalArgumentException("Cannot match template type to available request builders");
        }

        return builder;
    }
}
