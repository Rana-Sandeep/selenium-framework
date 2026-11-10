package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.driver.DriverFactory;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageTitleTest extends BaseTest {

    @Test
    public void verifyPageTitle() {

        driver.get(ConfigReader.get("base.url"));
        String actualTitle = DriverFactory.getDriver().getTitle();

        Assert.assertEquals(actualTitle, "Swag Labs");
    }
}