package com.avenga.yablonskyi.tests.books;

import com.avenga.yablonskyi.base.BaseBooksTest;
import org.testng.annotations.Test;

public class BooksEdgeCasesTest extends BaseBooksTest {

    @Test(alwaysRun = true,
            description = "Verify that getting a book with zero ID returns 404",
            groups = {"regression", "api", "books", "books-negative", "get-book-zero-id"},
            priority = 1)
    public void checkGetZeroIdBookReturns404() {
        booksApiClient.getBookRequest(0)
                .verify()
                .verifyStatusCode404();
    }

}
