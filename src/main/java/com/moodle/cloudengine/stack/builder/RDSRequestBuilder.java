package com.moodle.cloudengine.stack.builder;

import com.amazonaws.services.cloudformation.model.Parameter;
import com.moodle.cloudengine.stack.request.RDSRequest;
import com.moodle.cloudengine.stack.request.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewlarsen on 5/7/17.
 */
public class RDSRequestBuilder extends StackRequestBuilder {

    public RDSRequestBuilder(Request request){
        super(request);
    }
    @Override
    protected List<Parameter> createParameters() {
        RDSRequest request = (RDSRequest) this.request;
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(createParameter("DBSubnet1Name", request.getDBSubnet1Name()));
        parameters.add(createParameter("DBSubnet2Name", request.getDBSubnet2Name()));
        parameters.add(createParameter("DBInstance", request.getDBInstance()));
        parameters.add(createParameter("DBName", request.getDBName()));
        parameters.add(createParameter("DBMasterUser", request.getDBMasterUser()));
        parameters.add(createParameter("DBMasterPassword", request.getDBMasterPassword()));
        parameters.add(createParameter("DBIsMultiZone", request.getDBIsMultiZone()));
        parameters.add(createParameter("Tenant", request.getTenant()));

        return parameters;
    }
}
