package com.swaglabs.listeners;

import com.swaglabs.utils.*;
import org.testng.*;

import java.io.File;

import static com.swaglabs.utils.PropertiesUtils.loadProperties;

public class TestNGListeners implements IExecutionListener, ITestListener, IInvokedMethodListener {
    // variables
    File allure_results = new File("test-outputs/allure-results");
    File logs = new File("test-outputs/Logs");
    File screenshots = new File("test-outputs/screenshots");

    @Override
    public void onExecutionStart() {

        LogsUtil.info("Test Execution started");
        loadProperties();
        FilesUtils.deleteFiles(allure_results);
        FilesUtils.cleanDirectory(logs);
        FilesUtils.cleanDirectory(screenshots);

    }

    @Override
    public void onExecutionFinish() {

        LogsUtil.info("Test Execution finished");

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()){
            try {
                CustomSoftAssertion.customAssertAll();
            }catch (AssertionError error){
                testResult.setStatus(ITestResult.FAILURE);
                testResult.setThrowable(error);
            }

            switch (testResult.getStatus()){
                case ITestResult.SUCCESS -> ScreenshotsUtils.takeScreenshot("passed-"+ testResult.getName());
                case ITestResult.FAILURE -> ScreenshotsUtils.takeScreenshot("failed-"+ testResult.getName());
                case ITestResult.SKIP -> ScreenshotsUtils.takeScreenshot("skipped-"+ testResult.getName());
            }
        }
        AllureUtils.attachLogsToAllureReport();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogsUtil.info("Test Case", result.getName(), "passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogsUtil.info("Test Case", result.getName(), "failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogsUtil.info("Test Case", result.getName(), "skipped");
    }
}
