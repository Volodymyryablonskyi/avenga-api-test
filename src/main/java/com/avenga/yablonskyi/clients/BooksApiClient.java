package com.avenga.yablonskyi.clients;

import com.avenga.yablonskyi.endpoints.BooksEndpoints;
import com.avenga.yablonskyi.http.response.ResponseWrapper;
import com.avenga.yablonskyi.pojo.BookPojo;
import com.avenga.yablonskyi.util.CustomLogger;

public class BooksApiClient extends BaseApiClient<BooksEndpoints, BookPojo> {

    private static final CustomLogger log = CustomLogger.getLogger(BooksApiClient.class);

    public BooksApiClient() {
        super(new BooksEndpoints());
    }

    public ResponseWrapper getAllBooksRequest() {
        log.info("Getting all books");
        return getAll();
    }

    public ResponseWrapper getBookRequest(int id) {
        log.info("Getting book with ID: {}", id);
        return getOne(id);
    }

    public ResponseWrapper createBookRequest(BookPojo book) {
        log.info("Creating new book: {}", book.toString());
        return add(book);
    }

    public ResponseWrapper updateBookRequest(int id, BookPojo book) {
        log.info("Updating book with ID: {}", id);
        return update(id, book);
    }

    public ResponseWrapper deleteBookRequest(int id) {
        log.info("Deleting book with ID: {}", id);
        return delete(id);
    }

}