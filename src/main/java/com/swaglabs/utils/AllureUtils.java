package com.swaglabs.utils;

import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {

    public static final String ALLURE_RESULTS_PATH = "test-outputs/allure-results";
    private AllureUtils(){
        super();
    }
    public static void attachLogsToAllureReport(){
        try {
            File logFile = FilesUtils.getlatestFile(LogsUtil.LOG_PATH);
            if (!logFile.exists()) {
                LogsUtil.warn("Log file does not exist" + LogsUtil.LOG_PATH);
                return;
            }
            Allure.addAttachment("logs.log", Files.readString(Path.of(logFile.getPath())));
            LogsUtil.info("Logs attached to allure report");
        }
        catch (Exception e){
            LogsUtil.error("Failed to attach logs to allure report " + e.getMessage());
        }
    }
    public static void attachScreenshotToAllureReport(String screenshotName, String screenshotPath){
        try {
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotPath)));
        } catch (Exception e) {
            LogsUtil.error("Failed to attach screenshot to allure report " + e.getMessage());
        }
    }
}
