package com.avenga.yablonskyi.base;

import com.avenga.yablonskyi.clients.BooksApiClient;
import com.avenga.yablonskyi.testdata.BooksTestData;
import org.testng.annotations.BeforeClass;

public class BaseBooksTest extends BaseTest {

    protected BooksApiClient booksApiClient;
    protected BooksTestData testData;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        super.setUp();
        this.booksApiClient = new BooksApiClient();
        this.testData = new BooksTestData();
    }

}