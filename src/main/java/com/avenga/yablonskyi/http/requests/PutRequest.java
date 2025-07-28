package com.avenga.yablonskyi.http.requests;

import com.avenga.yablonskyi.http.requests.enums.HttpMethod;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PutRequest extends AbstractRequest implements IRequestWithBody {

    public PutRequest(RequestSpecification spec) {
        super(spec, HttpMethod.PUT);
    }

    @Override
    public Response send(String uri, Object body) {
        return given(spec).body(body).when().put(uri);
    }

}