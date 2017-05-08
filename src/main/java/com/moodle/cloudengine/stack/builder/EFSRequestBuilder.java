package com.moodle.cloudengine.stack.builder;

import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.stack.request.ECRequest;
import com.moodle.cloudengine.stack.request.EFSRequest;
import com.moodle.cloudengine.stack.request.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class EFSRequestBuilder extends StackRequestBuilder {

    public EFSRequestBuilder(Request request){
        super(request);
    }
    @Override
    protected List<Parameter> createParameters() {
        //todo-how bad is this?
        EFSRequest request = (EFSRequest) this.request;

        List<Parameter> parameters = new ArrayList<>();
        parameters.add(createParameter("VPCName", request.getVPCName()));
        parameters.add(createParameter("EFSubnet1Name", request.getEFSubnet1Name()));
        parameters.add(createParameter("EFSubnet2Name", request.getEFSubnet2Name()));
        parameters.add(createParameter("EFSubnet3Name", request.getEFSubnet3Name()));
        parameters.add(createParameter("Tenant", request.getTenant()));
        return parameters;

    }
}
