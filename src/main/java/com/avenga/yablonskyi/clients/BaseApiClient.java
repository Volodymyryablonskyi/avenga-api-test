package com.avenga.yablonskyi.clients;

import com.avenga.yablonskyi.config.ApplicationConfig;
import com.avenga.yablonskyi.dto.BasePojo;
import com.avenga.yablonskyi.endpoints.BaseEndpoint;
import com.avenga.yablonskyi.http.requests.RequestsFactory;
import com.avenga.yablonskyi.http.response.ResponseWrapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseApiClient<T extends BaseEndpoint, D extends BasePojo> {

    private static final String BASE_URI = ApplicationConfig.getBaseUri();

    protected final RequestSpecification spec;
    protected RequestsFactory requestsFactory;
    protected final T endpoints;

    public BaseApiClient(T endpoints) {
        this.endpoints = endpoints;
        this.spec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .build();
        this.requestsFactory = new RequestsFactory(spec);
    }

    protected ResponseWrapper getAll() {
        return ResponseWrapper.of(requestsFactory.get().send(endpoints.getAll()));
    }

    protected ResponseWrapper getOne(int id) {
        return ResponseWrapper.of(requestsFactory.get().send(endpoints.getById(id)));
    }

    protected ResponseWrapper add(D dto) {
        return ResponseWrapper.of(requestsFactory.post().send(endpoints.getAll(), dto));
    }

    protected ResponseWrapper update(int id, D dto) {
        return ResponseWrapper.of(requestsFactory.put().send(endpoints.getById(id), dto));
    }

    protected ResponseWrapper delete(int id) {
        return ResponseWrapper.of(requestsFactory.delete().send(endpoints.getById(id)));
    }

}