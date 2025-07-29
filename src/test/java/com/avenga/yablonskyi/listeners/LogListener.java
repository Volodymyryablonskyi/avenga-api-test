package com.avenga.yablonskyi.listeners;

import com.avenga.yablonskyi.util.CustomLogger;

public class LogListener {

    private static final CustomLogger log = CustomLogger.getLogger(GlobalTestListener.class);

    static {
        log.setAllowAllure(false);
    }

    static void logHeader(String message, LogLevel level) {
        String formatted = "----------- " + message + " -----------";
        switch (level) {
            case LogLevel.INFO -> log.info(formatted);
            case LogLevel.WARN -> log.warn(formatted);
            case LogLevel.ERROR -> log.error(formatted);
        }
    }

    enum LogLevel {
        INFO,
        WARN,
        ERROR
    }

}