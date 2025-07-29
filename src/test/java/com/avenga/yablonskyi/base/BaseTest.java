package com.avenga.yablonskyi.base;

import com.avenga.yablonskyi.config.RestAssuredConfigurator;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        RestAssuredConfigurator.configure();
    }

}