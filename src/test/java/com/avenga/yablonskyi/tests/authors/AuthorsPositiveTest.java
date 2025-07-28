package com.avenga.yablonskyi.tests.authors;

import com.avenga.yablonskyi.base.BaseAuthorTest;
import com.avenga.yablonskyi.dto.AuthorPojo;
import org.testng.annotations.Test;

public class AuthorsPositiveTest extends BaseAuthorTest {

    @Test(alwaysRun = true,
            description = "Verify that all authors informations can be retrieved via API",
            groups = {"regression", "api", "authors", "authors-positive", "get-all-authors"},
            priority = 1)
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
    public void checkDeleteAuthor() {
        int id = testData.getRandomId(1, 100);
        authorsApiClient.deleteAuthorRequest(id)
                .verify()
                .verifyStatusCode200();
    }

}