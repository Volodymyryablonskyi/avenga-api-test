package com.avenga.yablonskyi.listeners;

import com.avenga.yablonskyi.base.BaseTest;
import com.avenga.yablonskyi.util.CustomLogger;
import com.avenga.yablonskyi.util.TimeUtil;
import org.testng.*;
import com.avenga.yablonskyi.listeners.LogListener.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import static com.avenga.yablonskyi.listeners.LogListener.logHeader;

public class GlobalTestListener implements ITestListener, ISuiteListener {

    private LocalTime startSuiteTime;
    private LocalTime endSuiteTime;
    private long totalSuiteDuration;

    private static final CustomLogger log = CustomLogger.getLogger(GlobalTestListener.class);

    @Override
    public void onStart(ISuite suite) {
        log.setAllowAllure(false);
        startSuiteTime = TimeUtil.getCurrentTime();
        logHeader("[SUITE STARTED]: " + suite.getName(), LogLevel.INFO);
    }

    @Override
    public void onFinish(ISuite suite) {
        endSuiteTime = TimeUtil.getCurrentTime();
        totalSuiteDuration = TimeUtil.getDuration(startSuiteTime, endSuiteTime);
        logHeader("[SUITE FINISHED]: " + suite.getName(), LogLevel.INFO);
        log.info("[TOTAL EXECUTION TIME] " + TimeUtil.makeTimeReadable(totalSuiteDuration));
    }

    @Override
    public void onStart(ITestContext context) {
        logHeader("TEST CONTEXT STARTED: " + context.getName(), LogLevel.INFO);
    }

    @Override
    public void onFinish(ITestContext context) {
        logHeader("TEST CONTEXT FINISHED: " + context.getName(), LogLevel.INFO);
    }

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        if (BaseTest.getRerun()) {
            logHeader("RETRYING: " + methodName, LogLevel.INFO);
        } else {
            logHeader("STARTED: " + methodName, LogLevel.INFO);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        if (BaseTest.getRerun()) {
            logHeader("PASSED IN RETRY: " + methodName, LogLevel.INFO);
        } else {
            logHeader("PASSED: " + methodName, LogLevel.INFO);
        }
        BaseTest.setRerun(false);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        if (BaseTest.getRerun()) {
            logHeader("FAILED IN RETRY: " + methodName, LogLevel.WARN);
        } else {
            logHeader("FAILED: " + methodName, LogLevel.ERROR);
            Throwable throwable = result.getThrowable();
            if (!Objects.isNull(throwable)) {
                log.error("ERROR: ", throwable);
            }
        }
        BaseTest.setRerun(false);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        logHeader("SKIPPED: " + methodName, LogLevel.WARN);
        BaseTest.setRerun(false);
    }

}