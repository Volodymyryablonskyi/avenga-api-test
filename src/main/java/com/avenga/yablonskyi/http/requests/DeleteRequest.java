package com.avenga.yablonskyi.http.requests;

import com.avenga.yablonskyi.http.requests.enums.HttpMethod;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest extends AbstractRequest {

    public DeleteRequest(RequestSpecification spec) {
        super(spec, HttpMethod.DELETE);
    }

}
