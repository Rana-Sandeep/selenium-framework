package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.*;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest {

    @Test
    public void checkoutOverview(){
        driver.get(ConfigReader.get("base.url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(ConfigReader.get("username"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();

        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        Assert.assertEquals(checkoutInfoPage.getPageTitle(), "Checkout: Your Information");
        checkoutInfoPage.enterFirstName("Sandeep");
        checkoutInfoPage.enterLastName("Rana");
        checkoutInfoPage.enterPostalCode("122202");
        checkoutInfoPage.clickContinue();

        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(overviewPage.getPageTitle(),"Checkout: Overview");
        Assert.assertEquals(overviewPage.getItemName(),"Sauce Labs Backpack");
        Assert.assertEquals(overviewPage.getItemTotal(),"Item total: $29.99");

        overviewPage.clickFinish();

    }


}
