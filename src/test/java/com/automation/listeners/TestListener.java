package com.automation.listeners;

import com.automation.driver.DriverFactory;
import com.automation.utils.ScreenshotUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        String path = ScreenshotUtils.takeScreenshot(DriverFactory.getDriver(), testName);
        System.out.println("Screenshot saved: " + path);
    }
}