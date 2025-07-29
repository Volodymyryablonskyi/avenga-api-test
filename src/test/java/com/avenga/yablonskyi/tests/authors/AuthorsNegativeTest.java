package com.avenga.yablonskyi.tests.authors;

import com.avenga.yablonskyi.base.BaseAuthorTest;
import com.avenga.yablonskyi.dto.AuthorPojo;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Authors API")
@Feature("Negative tests for Authors API")
public class AuthorsNegativeTest extends BaseAuthorTest {

    @Test(alwaysRun = true,
            description = "Verify that getting an author with non-existing ID returns 404",
            groups = {"regression", "api", "authors", "authors-negative", "get-not-existing-author"},
            priority = 1)
    @Description("Ensure that GET /Authors/{id} returns 404 when the author ID does not exist.")
    public void checkGetNonExistingAuthorReturns404() {
        int nonExistingId = testData.getNotExistingId();
        authorsApiClient.getAuthorRequest(nonExistingId)
                .verify()
                .verifyStatusCode404();
    }

    @Test(alwaysRun = true,
            description = "Verify that deleting a non-existing author returns 404",
            groups = {"regression", "api", "authors", "authors-negative", "delete-not-existing-author"},
            priority = 2)
    @Description("Ensure that DELETE /Authors/{id} returns 404 when trying to delete a non-existing author.")
    public void checkDeleteNonExistingAuthorReturns404() {
        int nonExistingId = testData.getNotExistingId();
        authorsApiClient.deleteAuthorRequest(nonExistingId)
                .verify()
                .verifyStatusCode404();
    }

    @Test(alwaysRun = true,
            description = "Verify that updating a non-existing author returns 404",
            groups = {"regression", "api", "authors", "authors-negative", "update-not-existing-author"},
            priority = 3)
    @Description("Ensure that PUT /Authors/{id} returns 404 when updating a non-existing author.")
    public void checkUpdateNonExistingAuthorReturns404() {
        AuthorPojo nonExisting = testData.generateNotExisting();
        int id = nonExisting.getId();
        authorsApiClient.updateAuthorRequest(id, nonExisting)
                .verify()
                .verifyStatusCode404();
    }

    @Test(alwaysRun = true,
            description = "Verify that creating an author with missing required fields fails",
            groups = {"regression", "api", "authors", "authors-negative", "create-invalid-author"},
            priority = 4)
    @Description("Ensure that POST /Authors returns 400 when required fields are missing.")
    public void checkCreateAuthorWithMissingFieldsReturns400() {
        AuthorPojo invalidAuthor = testData.generateInvalid();
        authorsApiClient.createAuthorRequest(invalidAuthor)
                .verify()
                .verifyStatusCode400();
    }

    @Test(alwaysRun = true,
            description = "Verify that creating an author with existing ID is not allowed",
            groups = {"regression", "api", "authors", "authors-negative", "create-author-existing-id"},
            priority = 5)
    @Description("Ensure that POST /Authors returns an error when trying to create an author with an existing ID.")
    public void checkCreateAuthorWithExistingId() {
        AuthorPojo existingAuthor = testData.generateExisting();
        authorsApiClient.createAuthorRequest(existingAuthor)
                .verify()
                .isStatusCodeIn(400, 403, 406, 409);
    }

}