    package com.automation.tests;

    import com.automation.base.BaseTest;
    import com.automation.pages.CartPage;
    import com.automation.pages.InventoryPage;
    import com.automation.pages.LoginPage;
    import com.automation.utils.ConfigReader;
    import org.testng.Assert;
    import org.testng.annotations.Test;

    import static com.automation.driver.DriverFactory.*;
    public class CartTest extends BaseTest {

        @Test

        public void cartTest(){

            driver.get(ConfigReader.get("base.url"));
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUsername(ConfigReader.get("username"));
            loginPage.enterPassword(ConfigReader.get("password"));
            loginPage.clickLogin();

            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.addBackpackToCart();
            inventoryPage.goToCart();

            CartPage cartPage = new CartPage(driver);
            Assert.assertEquals(cartPage.getPageTitle(), "Your Cart");
            Assert.assertEquals(cartPage.getItemName(),"Sauce Labs Backpack");
            cartPage.checkout();

        }

    }
