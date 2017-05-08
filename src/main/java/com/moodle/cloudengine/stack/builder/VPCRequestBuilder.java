package com.moodle.cloudengine.stack.builder;

import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.stack.request.Request;
import com.moodle.cloudengine.stack.request.VPCRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class VPCRequestBuilder extends StackRequestBuilder {

    public VPCRequestBuilder(Request request) {
        super(request);
    }

    @Override
    protected List<Parameter> createParameters() {
        List<Parameter> parameters = new ArrayList<>();
        //todo-how bad is this?
        VPCRequest request = (VPCRequest) this.request;
        parameters.add(createParameter("APPSN1Cidr", request.getAPPSN1Cidr()));
        parameters.add(createParameter("APPSN2Cidr", request.getAPPSN2Cidr()));
        parameters.add(createParameter("APPSN3Cidr", request.getAPPSN3Cidr()));
        parameters.add(createParameter("DBSN1Cidr", request.getAPPSN1Cidr()));
        parameters.add(createParameter("DBSN2Cidr", request.getAPPSN2Cidr()));
        parameters.add(createParameter("EFSN1Cidr", request.getEFSN1Cidr()));
        parameters.add(createParameter("EFSN2Cidr", request.getEFSN2Cidr()));
        parameters.add(createParameter("EFSN3Cidr", request.getEFSN3Cidr()));
        parameters.add(createParameter("MCSN1Cidr", request.getMCSN1Cidr()));
        parameters.add(createParameter("WSSN1Cidr", request.getWSSN1Cidr()));
        parameters.add(createParameter("WSSN2Cidr", request.getWSSN2Cidr()));
        parameters.add(createParameter("WSSN3Cidr", request.getWSSN3Cidr()));
        parameters.add(createParameter("cidr", request.getCidr()));
        parameters.add(createParameter("Tenant", request.getTenant()));
        return parameters;
    }

}
