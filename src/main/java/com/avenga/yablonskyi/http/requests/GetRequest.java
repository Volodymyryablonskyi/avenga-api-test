package com.avenga.yablonskyi.http.requests;

import com.avenga.yablonskyi.http.requests.enums.HttpMethod;
import io.restassured.specification.RequestSpecification;

public class GetRequest extends AbstractRequest {

    public GetRequest(RequestSpecification spec) {
        super(spec, HttpMethod.GET);
    }

}