package com.avenga.yablonskyi.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConverter {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String prettifyJson(Object object) {
        return gson.toJson(object);
    }

}
