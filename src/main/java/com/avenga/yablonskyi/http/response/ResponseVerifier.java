package com.avenga.yablonskyi.http.response;

import com.avenga.yablonskyi.assertions.Assertion;
import com.avenga.yablonskyi.util.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class ResponseVerifier {

    private static final CustomLogger log = CustomLogger.getLogger(ResponseVerifier.class);

    private final ResponseWrapper responseWrapper;

    public ResponseVerifier hasStatusCode(int expected) {
        log.info("Verify that Response status code is equal to - {}", expected);
        int actual = responseWrapper.statusCode();
        Assertions.assertThat(actual)
                .as(actual + " Status Code not equal to - " + expected)
                .isEqualTo(expected);
        return this;
    }

    public ResponseVerifier verifyStatusCode200() {
        return hasStatusCode(200);
    }

    public ResponseVerifier verifyStatusCode404() {
        return hasStatusCode(404);
    }

    public ResponseVerifier verifyStatusCode400() {
        return hasStatusCode(400);
    }

    public ResponseVerifier isStatusCodeIn(int... expectedStatusCodes) {
        log.info("Verify that Response status code is in {}", Arrays.toString(expectedStatusCodes));
        int actualStatus = responseWrapper.statusCode();
        Assertions.assertThat(expectedStatusCodes)
                .as("Actual Status Code " + actualStatus + " is not in - " + Arrays.toString(expectedStatusCodes))
                .contains(actualStatus);
        return this;
    }

    public <T> ResponseVerifier verifyJsonValueMatchCondition(String fieldName, Class<T> type, Predicate<T> condition, String description) {
        log.info("Verify that response JSON Param {} matches with patter {}", fieldName, description);
        T value = responseWrapper.getJsonPath().getObject(fieldName, type);
        Assertions.assertThat(value)
                .as("Json Value '" + fieldName + "' is missing")
                .isNotNull();
        Assertion.failIfFalse(condition.test(value), "Json Value  '" + fieldName + "' not match with condition - " + description);
        return this;
    }

    public <T> ResponseVerifier verifyBodyEqualsToPojo(Class<T> clazz, T expected) {
        log.info("Verify that Response JSON is equal to {}", expected.toString());
        T actual = responseWrapper.asPojo(clazz);
        Assertions.assertThat(actual)
                .as("Response body not equals to - " + expected).
                isEqualTo(expected);
        return this;
    }

    public <T> ResponseVerifier verifyPojoListNotEmpty(Class<T> clazz) {
        log.info("Verify that JSON List in Response Body is not empty");
        List<T> list = responseWrapper.asListOfPojo(clazz);
        Assertions.assertThat(list)
                .as("JSON List in Response Body is not empty - " + list.toString())
                .isNotNull()
                .isNotEmpty();
        return this;
    }

}