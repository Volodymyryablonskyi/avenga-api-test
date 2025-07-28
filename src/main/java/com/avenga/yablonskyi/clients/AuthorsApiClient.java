package com.avenga.yablonskyi.clients;

import com.avenga.yablonskyi.dto.AuthorPojo;
import com.avenga.yablonskyi.endpoints.AuthorsEndpoints;
import com.avenga.yablonskyi.http.response.ResponseWrapper;

public class AuthorsApiClient extends BaseApiClient<AuthorsEndpoints, AuthorPojo> {

    public AuthorsApiClient() {
        super(new AuthorsEndpoints());
    }

    public ResponseWrapper getAllAuthorsRequest() {
        return getAll();
    }

    public ResponseWrapper getAuthorRequest(int id) {
        return getOne(id);
    }

    public ResponseWrapper createAuthorRequest(AuthorPojo author) {
        return add(author);
    }

    public ResponseWrapper updateAuthorRequest(int id, AuthorPojo author) {
        return update(id, author);
    }

    public ResponseWrapper deleteAuthorRequest(int id) {
        return delete(id);
    }

}