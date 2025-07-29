package com.avenga.yablonskyi.clients;

import com.avenga.yablonskyi.dto.AuthorPojo;
import com.avenga.yablonskyi.endpoints.AuthorsEndpoints;
import com.avenga.yablonskyi.http.response.ResponseWrapper;
import com.avenga.yablonskyi.util.CustomLogger;

public class AuthorsApiClient extends BaseApiClient<AuthorsEndpoints, AuthorPojo> {

    private static final CustomLogger log = CustomLogger.getLogger(AuthorsApiClient.class);

    public AuthorsApiClient() {
        super(new AuthorsEndpoints());
    }

    public ResponseWrapper getAllAuthorsRequest() {
        log.info("Getting all authors");
        return getAll();
    }

    public ResponseWrapper getAuthorRequest(int id) {
        log.info("Getting author with ID: {}", id);
        return getOne(id);
    }

    public ResponseWrapper createAuthorRequest(AuthorPojo author) {
        log.info("Creating new author: {}", author.toString());
        return add(author);
    }

    public ResponseWrapper updateAuthorRequest(int id, AuthorPojo author) {
        log.info("Updating author with ID: {}", id);
        return update(id, author);
    }

    public ResponseWrapper deleteAuthorRequest(int id) {
        log.info("Deleting author with ID: {}", id);
        return delete(id);
    }

}