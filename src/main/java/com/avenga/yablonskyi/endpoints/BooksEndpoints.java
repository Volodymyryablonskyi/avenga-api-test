package com.avenga.yablonskyi.endpoints;

public class BooksEndpoints extends BaseEndpoint {

    private static final String BOOKS = API_V1 + "/Books";

    @Override
    public String getAll() {
        return BOOKS;
    }

    @Override
    public String getById(int id) {
        return BOOKS + "/" + id;
    }

}
