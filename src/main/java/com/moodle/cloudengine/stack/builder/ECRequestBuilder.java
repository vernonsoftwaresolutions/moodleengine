package com.moodle.cloudengine.stack.builder;

import com.amazonaws.services.cloudformation.model.Capability;
import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.stack.request.ECRequest;
import com.moodle.cloudengine.stack.request.Request;
import com.moodle.cloudengine.stack.request.VPCRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class ECRequestBuilder extends StackRequestBuilder {

    public ECRequestBuilder(Request request) {
        super(request);
    }
    @Override
    protected List<Parameter> createParameters() {
        //todo-how bad is this?
        ECRequest request = (ECRequest) this.request;

        List<Parameter> parameters = new ArrayList<>();
        parameters.add(createParameter("VPCName", request.getVPCName()));
        parameters.add(createParameter("Tenant", request.getTenant()));
        parameters.add(createParameter("MCSubnet1Name", request.getMCSubnet1Name()));

        return parameters;
    }

}
