package com.avenga.yablonskyi.tests.authors;

import com.avenga.yablonskyi.base.BaseAuthorTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Authors API")
@Feature("Edge cases tests for Authors API")
public class AuthorsEdgeCasesTest extends BaseAuthorTest {

    @Test(alwaysRun = true,
            description = "Verify that getting an author with zero ID returns 404",
            groups = {"regression", "api", "authors", "authors-edge", "get-author-zero-id"},
            priority = 1)
    @Description("Ensure the API returns 404 when author ID = 0")
    public void checkGetZeroIdAuthorReturns404() {
        authorsApiClient.getAuthorRequest(0)
                .verify()
                .verifyStatusCode404();
    }

}