package com.avenga.yablonskyi.base;

import com.avenga.yablonskyi.clients.AuthorsApiClient;
import com.avenga.yablonskyi.testdata.AuthorsTestData;
import org.testng.annotations.BeforeClass;

public class BaseAuthorTest extends BaseTest {

    protected AuthorsApiClient authorsApiClient;
    protected AuthorsTestData testData;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        super.setUp();
        this.authorsApiClient = new AuthorsApiClient();
        this.testData = new AuthorsTestData();
    }


}
