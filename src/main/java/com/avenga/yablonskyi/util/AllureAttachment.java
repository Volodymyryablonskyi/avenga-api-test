package com.avenga.yablonskyi.util;

import io.qameta.allure.Attachment;

public class AllureAttachment {

    @Attachment(value = "{name}", type = "application/json")
    public static String attachJson(String name, String json) {
        return json;
    }

    @Attachment(value = "{name}", type = "text/plain")
    public static String attachText(String name, String message) {
        return message;
    }

}
