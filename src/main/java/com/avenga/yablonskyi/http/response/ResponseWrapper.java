package com.avenga.yablonskyi.http.response;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper {

    protected Response response;

    public Response response() {
        return response;
    }

    public String asString() {
        return response.thenReturn().asString();
    }

    public <T> T asPojo(Class<T> clz) {
        return response.as(clz);
    }

    public <T> List<T> asListOfPojo(Class<T> clz) {
        return response.jsonPath().getList("$", clz);
    }

    public int statusCode() {
        return response.getStatusCode();
    }

    public String statusLine() {
        return response.getStatusLine();
    }

    public static ResponseWrapper of(Response response) {
        if (response == null) return ResponseWrapper.empty();
        return new ResponseWrapper(response);
    }

    public static ResponseWrapper empty() {
        return new ResponseWrapper(null);
    }
}
