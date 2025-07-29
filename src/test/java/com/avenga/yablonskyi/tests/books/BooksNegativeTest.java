package com.avenga.yablonskyi.tests.books;

import com.avenga.yablonskyi.base.BaseBooksTest;
import com.avenga.yablonskyi.dto.BookPojo;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Books API")
@Feature("Negative tests for Books API")
public class BooksNegativeTest extends BaseBooksTest {

    @Test(alwaysRun = true,
            description = "Verify that getting a book with non-existing ID returns 404",
            groups = {"regression", "api", "books", "books-negative", "get-not-existing-book"},
            priority = 2)
    @Description("Ensure GET /Books/{id} returns 404 for non-existing book ID.")
    public void checkGetNonExistingBookReturns404() {
        int nonExistingId = testData.getNotExistingId();
        booksApiClient.getBookRequest(nonExistingId)
                .verify()
                .verifyStatusCode404();
    }

    @Test(alwaysRun = true,
            description = "Verify that deleting a non-existing book returns 404",
            groups = {"regression", "api", "books", "books-negative", "delete-not-existing-negative"},
            priority = 3)
    @Description("Ensure DELETE /Books/{id} returns 404 when book does not exist.")
    public void checkDeleteNonExistingBookReturns404() {
        int nonExistingId = testData.getNotExistingId();
        booksApiClient.deleteBookRequest(nonExistingId)
                .verify()
                .verifyStatusCode404();
    }

    @Test(alwaysRun = true,
            description = "Verify that updating a non-existing book returns 200 (fake behavior)",
            groups = {"regression", "api", "books", "books-negative", "update-not-exiting-book-nonexistent"},
            priority = 4)
    @Description("Ensure PUT /Books/{id} returns 404 when trying to update a non-existing book.")
    public void checkUpdateNonExistingBook() {
        BookPojo nonExisting = testData.generateNotExisting();
        int id = nonExisting.getId();
        booksApiClient.updateBookRequest(id, nonExisting)
                .verify()
                .verifyStatusCode404();
    }

    @Test(alwaysRun = true,
            description = "Verify that posting a book with missing required fields fails",
            groups = {"regression", "api", "books", "books-negative", "create-invalid-book"},
            priority = 5)
    @Description("Ensure POST /Books fails with 400 when required fields are missing.")
    public void checkCreateBookWithMissingFieldsReturns400() {
       BookPojo invalidBook = testData.generateInvalid();
        booksApiClient.createBookRequest(invalidBook)
                .verify()
                .verifyStatusCode400();
    }

    @Test(alwaysRun = true,
            description = "Verify that creating a book with existing ID is not allowed ",
            groups = {"regression", "api", "books", "books-negative", "create-book-existing-id"},
            priority = 6)
    @Description("Ensure POST /Books fails with proper error code when book ID already exists.")
    public void checkCreateBookWithExistingId() {
        BookPojo existingBook = testData.generateExisting();
        booksApiClient.createBookRequest(existingBook)
                .verify()
                .isStatusCodeIn(400, 403, 406, 409);
    }

}