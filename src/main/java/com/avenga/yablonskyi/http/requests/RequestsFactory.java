package com.avenga.yablonskyi.http.requests;

import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RequestsFactory {

    private final RequestSpecification spec;

    public GetRequest get() {
        return new GetRequest(spec);
    }

    public DeleteRequest delete() {
        return new DeleteRequest(spec);
    }

    public PostRequest post() {
        return new PostRequest(spec);
    }

    public PutRequest put() {
        return new PutRequest(spec);
    }

    public AbstractRequest request(HttpMethod method) {
        return switch (method) {
            case GET -> get();
            case DELETE -> delete();
            case POST -> post();
            case PUT -> put();
            default -> throw new IllegalArgumentException("Unsupported Http Method: " + method);
        };
    }

}