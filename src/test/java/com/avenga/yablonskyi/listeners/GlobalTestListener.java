package com.avenga.yablonskyi.listeners;

import com.avenga.yablonskyi.util.CustomLogger;
import com.avenga.yablonskyi.util.TimeUtil;
import org.testng.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class GlobalTestListener implements ITestListener, ISuiteListener {

    private LocalDate startSuiteDate;
    private LocalTime startSuiteTime;
    private LocalTime endSuiteTime;
    private long totalSuiteDuration;

    private static final CustomLogger log = CustomLogger.getLogger(GlobalTestListener.class);

    @Override
    public void onStart(ISuite suite) {
        log.setAllowAllure(false);
        log.info("Suite started: {}", suite.getName());
        startSuiteTime = Objects.isNull(startSuiteTime)
                ? TimeUtil.getCurrentTime()
                : startSuiteTime;
        startSuiteDate = Objects.isNull(startSuiteDate)
                ? TimeUtil.getCurrentDate()
                : startSuiteDate;
    }

    @Override
    public void onFinish(ISuite suite) {
        log.info("Suite finished: {}", suite.getName());
        endSuiteTime = TimeUtil.getCurrentTime();
        totalSuiteDuration = TimeUtil.getDuration(startSuiteTime, endSuiteTime);
        log.info("[TOTAL EXECUTION TIME] " + TimeUtil.makeTimeReadable(totalSuiteDuration));
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("🟢 Test started: {}.{}",
                result.getTestClass().getName(), result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("✅ Test passed: {}.{}",
                result.getTestClass().getName(), result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        /*log.error("Test failed: {}.{}",
                result.getTestClass().getName(), result.getMethod().getMethodName());
        Throwable throwable = result.getThrowable();
        if (throwable != null) {
            log.error("Failure reason: ", throwable);
        }*/
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("⚠️ Test skipped: {}.{}",
                result.getTestClass().getName(), result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional to implement
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("Test {} started", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("🔶 Test context finished: {}", context.getName());
    }

}
