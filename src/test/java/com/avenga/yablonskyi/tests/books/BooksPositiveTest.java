package com.avenga.yablonskyi.tests.books;

import com.avenga.yablonskyi.base.BaseBooksTest;
import com.avenga.yablonskyi.dto.BookPojo;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Books API")
@Feature("Positive tests for Books API")
public class BooksPositiveTest extends BaseBooksTest {

    @Test(alwaysRun = true,
            description = "Verify that all books informations can be retrieved via API",
            groups = {"regression", "api", "books", "books-positive", "get-all-books"},
            priority = 1)
    @Description("Ensure that the GET /Books endpoint returns a non-empty list of books.")
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
    @Description("Ensure that the GET /Books/{id} endpoint returns the correct book by ID.")
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
    @Description("Ensure that a new book can be successfully created using POST /Books.")
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
    @Description("Ensure that an existing book's data can be updated using PUT /Books/{id}.")
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
    @Description("Ensure that a book can be deleted using DELETE /Books/{id}.")
    public void checkDeleteBook() {
        int id = testData.getRandomId(1, 50);
        booksApiClient.deleteBookRequest(id)
                .verify()
                .verifyStatusCode200();
    }

}