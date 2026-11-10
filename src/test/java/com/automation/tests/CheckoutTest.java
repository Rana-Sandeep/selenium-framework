package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutInfoPage;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test

    public void checkoutTest(){


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
        Assert.assertEquals(checkoutInfoPage.getPageTitle(),"Checkout: Your Information");
        checkoutInfoPage.enterFirstName("Sandeep");
        checkoutInfoPage.enterLastName("Rana");
        checkoutInfoPage.enterPostalCode("122002");
        checkoutInfoPage.clickContinue();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));




    }

}
