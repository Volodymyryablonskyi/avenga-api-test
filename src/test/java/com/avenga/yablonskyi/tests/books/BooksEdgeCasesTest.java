package com.avenga.yablonskyi.tests.books;

import com.avenga.yablonskyi.base.BaseBooksTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Books API")
@Feature("Edge cases tests for Books API")
public class BooksEdgeCasesTest extends BaseBooksTest {

    @Test(alwaysRun = true,
            description = "Verify that getting a book with zero ID returns 404",
            groups = {"regression", "api", "books", "books-negative", "get-book-zero-id"},
            priority = 1)
    @Description("Ensure the API returns 404 when book ID = 0")
    public void checkGetZeroIdBookReturns404() {
        booksApiClient.getBookRequest(0)
                .verify()
                .verifyStatusCode404();
    }

}