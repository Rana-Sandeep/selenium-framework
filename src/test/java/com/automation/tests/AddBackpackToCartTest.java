package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddBackpackToCartTest extends BaseTest {

    @Test
    public void addBackpackToCartTest(){

        LoginPage loginPage = new LoginPage(driver);
        driver.get(ConfigReader.get("base.url"));
        loginPage.enterUsername(ConfigReader.get("username"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        Assert.assertEquals(inventoryPage.getCartCount(),"1");
    }


}
