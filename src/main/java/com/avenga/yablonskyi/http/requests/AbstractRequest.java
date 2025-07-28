package com.avenga.yablonskyi.http.requests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;

import static io.restassured.RestAssured.given;

@AllArgsConstructor
public abstract class AbstractRequest {

    protected final RequestSpecification spec;
    protected final HttpMethod method;

    public final Response send(String uri) {
        return given(spec).when().request(method.name(), uri);
    }

}