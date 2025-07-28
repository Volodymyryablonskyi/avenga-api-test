package com.avenga.yablonskyi.tests.books;

import com.avenga.yablonskyi.base.BaseBooksTest;
import com.avenga.yablonskyi.dto.BookPojo;
import org.testng.annotations.Test;

public class BooksPositiveTest extends BaseBooksTest {

    @Test(alwaysRun = true,
            description = "Verify that all books informations can be retrieved via API",
            groups = {"regression", "api", "books", "books-positive", "get-all-books"},
            priority = 1)
    public void checkGetAllBooks() {
        booksApiClient.getAllBooksRequest()
                .verify()
                .verifyStatusCode200()
                .verifyPojoListNotEmpty(BookPojo.class);
    }

    @Test(alwaysRun = true,
            description = "Verify that single book's information can be retrieved via API",
            groups = {"regression", "api", "books", "books-positive", "get-one-book"},
            priority = 2)
    public void checkGetOneBook() {
        BookPojo expectedBook = testData.generateExisting();
        int id = expectedBook.getId();
        booksApiClient.getBookRequest(id)
                .verify()
                .verifyStatusCode200()
                .verifyBodyEqualsToPojo(BookPojo.class, expectedBook)
                .verifyJsonValueMatchCondition("publishDate", String.class, s -> !s.isEmpty());
    }

    @Test(alwaysRun = true,
            description = "Verify that new book can be created via API",
            groups = {"regression", "api", "books", "books-positive", "create-book"},
            priority = 3)
    public void checkCreateBook() {
        BookPojo requestBook = testData.generateNotExisting();
        booksApiClient.createBookRequest(requestBook)
                .verify()
                .verifyStatusCode200()
                .verifyBodyEqualsToPojo(BookPojo.class, requestBook);
    }

    @Test(alwaysRun = true,
            description = "Verify that existing book can be updated via API",
            groups = {"regression", "api", "books", "books-positive", "update-book"},
            priority = 4)
    public void checkUpdateBook() {
        BookPojo requestBook = testData.generateForUpdate();
        int id = requestBook.getId();
        booksApiClient.updateBookRequest(id, requestBook)
                .verify()
                .verifyStatusCode200()
                .verifyBodyEqualsToPojo(BookPojo.class, requestBook);
    }

    @Test(alwaysRun = true,
            description = "Verify that book can be deleted via API",
            groups = {"regression", "api", "books", "books-positive", "delete-book"},
            priority = 5)
    public void checkDeleteBook() {
        int id = testData.getRandomId(1, 50);
        booksApiClient.deleteBookRequest(id)
                .verify()
                .verifyStatusCode200();
    }

}