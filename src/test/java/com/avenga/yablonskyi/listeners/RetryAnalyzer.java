package com.avenga.yablonskyi.listeners;

import com.avenga.yablonskyi.base.BaseTest;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer, IAnnotationTransformer {

    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            BaseTest.setRerun(true);
            return true;
        }
        BaseTest.setRerun(false);
        return false;
    }

}