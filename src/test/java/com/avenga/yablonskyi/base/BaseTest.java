package com.avenga.yablonskyi.base;

import com.avenga.yablonskyi.config.RestAssuredConfigurator;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private static ThreadLocal<Boolean> isRerun = ThreadLocal.withInitial(() -> Boolean.FALSE);

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        RestAssuredConfigurator.configure();
    }

    public static boolean getRerun() {
        return isRerun.get();
    }

    public static void setRerun(boolean rerun) {
        isRerun.set(rerun);
    }

}