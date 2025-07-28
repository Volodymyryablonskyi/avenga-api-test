package com.avenga.yablonskyi.http.requests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PostRequest extends AbstractRequest implements IRequestWithBody {

    public PostRequest(RequestSpecification spec) {
        super(spec, HttpMethod.POST);
    }

    @Override
    public Response send(String uri, Object body) {
        return given(spec).body(body).when().post(uri);
    }

}