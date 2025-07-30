package com.avenga.yablonskyi.http.requests;

import com.avenga.yablonskyi.constants.Constants;
import com.avenga.yablonskyi.http.requests.enums.HttpMethod;
import com.avenga.yablonskyi.util.CustomLogger;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PostRequest extends AbstractRequest implements IRequestWithBody {

    private static final CustomLogger log = CustomLogger.getLogger(PostRequest.class);

    public PostRequest(RequestSpecification spec) {
        super(spec, HttpMethod.POST);
    }

    @Override
    public Response send(String uri, Object body) {
        uri = Constants.BASE_URI + uri;
        log.logRequest(HttpMethod.POST, uri, body);
        return given(spec).body(body).when().post(uri);
    }

}