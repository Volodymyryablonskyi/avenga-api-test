package com.avenga.yablonskyi.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ApplicationConfig {

    private static final Config config = ConfigFactory.load();

    public static String getBaseUri() {
        return config.getString("base.uri");
    }

    public static int getConnectionTimeout() {
        return config.getInt("http.connection.timeout");
    }

    public static int getSocketTimeout() {
        return config.getInt("http.socket.timeout");
    }

}