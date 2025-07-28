package com.avenga.yablonskyi.assertions;

import org.assertj.core.api.Assertions;
import org.testng.SkipException;

public class Assertion {

    public static void fail(String message) {
        Assertions.fail(message);
    }

    public static void skip(String message) {
        throw new SkipException(message);
    }

    public static void failIfFalse(boolean result, String error) {
        if (!result) {
            fail(error);
        }
    }

    public static void failIfTrue(boolean result, String error) {
        if (result) {
            fail(error);
        }
    }

}
