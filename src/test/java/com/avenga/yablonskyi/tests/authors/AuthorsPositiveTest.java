package com.avenga.yablonskyi.tests.authors;

import com.avenga.yablonskyi.base.BaseAuthorTest;
import com.avenga.yablonskyi.dto.AuthorPojo;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Authors API")
@Feature("Positive tests for Authors API")
public class AuthorsPositiveTest extends BaseAuthorTest {

    @Test(alwaysRun = true,
            description = "Verify that all authors informations can be retrieved via API",
            groups = {"regression", "api", "authors", "authors-positive", "get-all-authors"},
            priority = 1)
    @Description("Ensure that the GET /Authors endpoint returns a non-empty list of authors.")
    public void checkGetAllAuthors() {
        authorsApiClient.getAllAuthorsRequest()
                .verify()
                .verifyStatusCode200()
                .verifyPojoListNotEmpty(AuthorPojo.class);
    }

    @Test(alwaysRun = true,
            description = "Verify that single author's information can be retrieved via API",
            groups = {"regression", "api", "authors", "authors-positive", "get-one-author"},
            priority = 2)
    @Description("Ensure that the GET /Authors/{id} endpoint returns the correct author by ID.")
    public void checkGetOneAuthor() {
        AuthorPojo expectedAuthor = testData.generateExisting();
        int id = expectedAuthor.getId();
        authorsApiClient.getAuthorRequest(id)
                .verify()
                .verifyStatusCode200()
                .verifyBodyEqualsToPojo(AuthorPojo.class, expectedAuthor)
                .verifyJsonValueMatchCondition("idBook", Integer.class,  bid -> bid > 0 );
    }

    @Test(alwaysRun = true,
            description = "Verify that new author can be created via API",
            groups = {"regression", "api", "authors", "authors-positive", "create-author"},
            priority = 3)
    @Description("Ensure that a new author can be successfully created using POST /Authors.")
    public void checkCreateAuthor() {
        AuthorPojo requestAuthor = testData.generateNotExisting();
        authorsApiClient.createAuthorRequest(requestAuthor)
                .verify()
                .verifyStatusCode200()
                .verifyBodyEqualsToPojo(AuthorPojo.class, requestAuthor);
    }

    @Test(alwaysRun = true,
            description = "Verify that existing author can be created via API",
            groups = {"regression", "api", "authors", "authors-positive", "update-author"},
            priority = 4)
    @Description("Ensure that an existing author's data can be updated using PUT /Authors/{id}.")
    public void checkUpdateAuthor() {
        AuthorPojo requestAuthor = testData.generateForUpdate();
        int id = requestAuthor.getId();
        authorsApiClient.updateAuthorRequest(id, requestAuthor)
                .verify()
                .verifyStatusCode200()
                .verifyBodyEqualsToPojo(AuthorPojo.class, requestAuthor);
    }

    @Test(alwaysRun = true,
            description = "Verify that author can be deleted via API",
            groups = {"regression", "api", "authors", "authors-positive", "delete-author"},
            priority = 5)
    @Description("Ensure that an author can be deleted using DELETE /Authors/{id}.")
    public void checkDeleteAuthor() {
        int id = testData.getRandomId(1, 100);
        authorsApiClient.deleteAuthorRequest(id)
                .verify()
                .verifyStatusCode200();
    }

}