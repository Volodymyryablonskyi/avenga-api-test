package com.avenga.yablonskyi.http.requests;

import io.restassured.specification.RequestSpecification;

public class GetRequest extends AbstractRequest {

    public GetRequest(RequestSpecification spec) {
        super(spec, HttpMethod.GET);
    }

}