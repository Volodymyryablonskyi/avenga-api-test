package com.avenga.yablonskyi.http.requests;

import io.restassured.response.Response;

public interface IRequestWithBody {
    Response send(String uri, Object body);
}
