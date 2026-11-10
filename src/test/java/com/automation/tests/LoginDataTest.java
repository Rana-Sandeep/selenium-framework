package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataTest extends BaseTest {


    @DataProvider(name = "validUsers")
    public Object[][] validUsers() {
        return new Object[][]{

                {"standard_user"},
                {"problem_user"},
                {"visual_user"}
        };


    }

    @Test(dataProvider = "validUsers")
    public void validUsersCanLogin(String username) {
        driver.get(ConfigReader.get("base.url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
    }

    @DataProvider(name = "invalidLogins")
    public Object[][] invalidLogins() {
        return new Object[][]{

                {ConfigReader.get("username"), "wrong_password", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", ConfigReader.get("password"), "Epic sadface: Sorry, this user has been locked out."},
                {ConfigReader.get("username"), "", "Epic sadface: Password is required"},
                {"", ConfigReader.get("password"), "Epic sadface: Username is required"},

        };
    }

    @Test(dataProvider = "invalidLogins")

    public void invalidLoginShowsError(String username, String password, String expectedError) {

        driver.get(ConfigReader.get("base.url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Assert.assertEquals(loginPage.getErrorMessage(), expectedError);


    }
}
