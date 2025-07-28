package com.avenga.yablonskyi.clients;

import com.avenga.yablonskyi.dto.AuthorPojo;
import com.avenga.yablonskyi.endpoints.AuthorsEndpoints;
import com.avenga.yablonskyi.http.response.ResponseWrapper;

import java.util.List;

public class AuthorsApiClient extends BaseApiClient<AuthorsEndpoints, AuthorPojo> {

    public AuthorsApiClient() {
        super(new AuthorsEndpoints());
    }

    public List<AuthorPojo> getAllAuthors() {
        return getAll().asListOfPojo(AuthorPojo.class);
    }

    public AuthorPojo getAuthorById(int id) {
        return getOne(id).asPojo(AuthorPojo.class);
    }

    public ResponseWrapper createAuthor(AuthorPojo author) {
        return add(author);
    }

    public ResponseWrapper updateAuthor(int id, AuthorPojo author) {
        return update(id, author);
    }

    public ResponseWrapper deleteAuthor(int id) {
        return delete(id);
    }



}