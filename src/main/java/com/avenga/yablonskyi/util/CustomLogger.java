package com.avenga.yablonskyi.util;

import com.avenga.yablonskyi.http.requests.enums.HttpMethod;
import io.qameta.allure.Allure;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Setter
public class CustomLogger {

    private boolean allowAllure = true;
    private final Logger logger;

    private CustomLogger(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz.getSimpleName());
    }

    public static CustomLogger getLogger(Class<?> clazz) {
        return new CustomLogger(clazz);
    }

    public void info(String message, Object... args) {
        logger.info(message, args);
        logAllure(message, args);
    }

    public void debug(String message, Object... args) {
        logger.debug(message, args);
        logAllure(message, args);
    }

    public void warn(String message, Object... args) {
        logger.warn(message, args);
        logAllure(message, args);
    }

    public void error(String message, Object... args) {
        logger.error(message, args);
        logAllure(message, args);
    }

    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
        logAllure(message + ": " + throwable.getMessage());
    }

    public void logRequest(HttpMethod method, String endpoint, Object body) {
        String pretty = JsonConverter.prettifyJson(body);
        logger.info("Sending {} request to: {}", method, endpoint);
        logger.info("Request body:\n{}", pretty);
        Allure.step("Sending " + method + " request to: " + endpoint);
        AllureAttachment.attachJson("📤 Request Body", pretty);
    }

    public void logRequest(HttpMethod method, String endpoint) {
        info("Sending {} request to: {}", method, endpoint);
    }

    private void logAllure(String message, Object... args) {
        if (allowAllure) {
            try {
                Allure.step(format(message, args));
            } catch (IllegalStateException ignored) {

            }
        }
    }

    private String format(String message, Object... args) {
        if (args == null) return message;
        for (Object arg : args) {
            message = message.replaceFirst("\\{}", arg != null ? arg.toString() : "null");
        }
        return message;
    }

}