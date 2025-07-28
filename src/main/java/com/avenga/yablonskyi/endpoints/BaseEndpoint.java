package com.avenga.yablonskyi.endpoints;

public abstract class BaseEndpoint {

    protected static final String API_V1 = "/api/v1";

    public abstract String getAll();

    public abstract String getById(int id);

}

