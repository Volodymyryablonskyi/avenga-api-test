package com.avenga.yablonskyi.http.requests;

import com.avenga.yablonskyi.clients.BaseApiClient;
import com.avenga.yablonskyi.http.requests.enums.HttpMethod;
import com.avenga.yablonskyi.util.CustomLogger;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;

import static io.restassured.RestAssured.given;

@AllArgsConstructor
public abstract class AbstractRequest {

    private static final CustomLogger log = CustomLogger.getLogger(AbstractRequest.class);

    protected final RequestSpecification spec;
    protected final HttpMethod method;

    public final Response send(String uri) {
        log.logRequest(method, uri);
        return given(spec).when().request(method.name(), uri);
    }

}