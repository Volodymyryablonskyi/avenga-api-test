package com.avenga.yablonskyi.http.requests;

import com.avenga.yablonskyi.http.requests.enums.HttpMethod;
import com.avenga.yablonskyi.util.CustomLogger;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PutRequest extends AbstractRequest implements IRequestWithBody {

    private static final CustomLogger log = CustomLogger.getLogger(PutRequest.class);

    public PutRequest(RequestSpecification spec) {
        super(spec, HttpMethod.PUT);
    }

    @Override
    public Response send(String uri, Object body) {
        log.logRequest(HttpMethod.POST, uri, body);
        return given(spec).body(body).when().put(uri);
    }

}