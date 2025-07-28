package com.avenga.yablonskyi.tests.authors;

import com.avenga.yablonskyi.base.BaseAuthorTest;
import com.avenga.yablonskyi.dto.AuthorPojo;
import org.testng.annotations.Test;

public class AuthorsNegativeTest extends BaseAuthorTest {

    @Test(alwaysRun = true,
            description = "Verify that getting an author with non-existing ID returns 404",
            groups = {"regression", "api", "authors", "authors-negative", "get-not-existing-author"},
            priority = 1)
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
    public void checkCreateAuthorWithExistingId() {
        AuthorPojo existingAuthor = testData.generateExisting();
        authorsApiClient.createAuthorRequest(existingAuthor)
                .verify()
                .isStatusCodeIn(400, 403, 406, 409);
    }

}