package com.avenga.yablonskyi.clients;

import com.avenga.yablonskyi.dto.BookPojo;
import com.avenga.yablonskyi.endpoints.BooksEndpoints;
import com.avenga.yablonskyi.http.response.ResponseWrapper;

import java.util.List;

public class BookApiClient extends BaseApiClient<BooksEndpoints, BookPojo> {

    public BookApiClient() {
        super(new BooksEndpoints());
    }

    public List<BookPojo> getAllBooks() {
        return getAll().asListOfPojo(BookPojo.class);
    }

    public BookPojo getBookById(int id) {
        return getOne(id).asPojo(BookPojo.class);
    }

    public ResponseWrapper createBook(BookPojo book) {
        return add(book);
    }

    public ResponseWrapper updateBook(int id, BookPojo book) {
        return update(id, book);
    }

    public ResponseWrapper deleteBook(int id) {
        return delete(id);
    }

}