package com.avenga.yablonskyi.tests.authors;

import com.avenga.yablonskyi.base.BaseAuthorTest;
import org.testng.annotations.Test;

public class AuthorsEdgeCasesTest extends BaseAuthorTest {

    @Test(alwaysRun = true,
            description = "Verify that getting an author with zero ID returns 404",
            groups = {"regression", "api", "authors", "authors-edge", "get-author-zero-id"},
            priority = 1)
    public void checkGetZeroIdAuthorReturns404() {
        authorsApiClient.getAuthorRequest(0)
                .verify()
                .verifyStatusCode404();
    }


}
