package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automation.driver.DriverFactory.driver;

public class FailingDemoTest extends BaseTest {

    @Test
    public void failingDemo() {
        driver.get(ConfigReader.get("base.url"));
        Assert.assertEquals(driver.getTitle(), "Wrong Title");
    }
}