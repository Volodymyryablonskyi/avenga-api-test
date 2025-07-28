package com.avenga.yablonskyi.clients;

import com.avenga.yablonskyi.dto.BookPojo;
import com.avenga.yablonskyi.endpoints.BooksEndpoints;
import com.avenga.yablonskyi.http.response.ResponseWrapper;

public class BooksApiClient extends BaseApiClient<BooksEndpoints, BookPojo> {

    public BooksApiClient() {
        super(new BooksEndpoints());
    }

    public ResponseWrapper getAllBooksRequest() {
        return getAll();
    }

    public ResponseWrapper getBookRequest(int id) {
        return getOne(id);
    }

    public ResponseWrapper createBookRequest(BookPojo book) {
        return add(book);
    }

    public ResponseWrapper updateBookRequest(int id, BookPojo book) {
        return update(id, book);
    }

    public ResponseWrapper deleteBookRequest(int id) {
        return delete(id);
    }

}