package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{


    private By pageTitle = By.className("title");
    private By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartLink = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        waitForUrlContains("inventory");
        waitForVisible(backpackAddButton);
        return getTextOf(pageTitle);
    }

    public void addBackpackToCart() {

        waitForClickable(backpackAddButton).click();

    }

    public String getCartCount() {
        return waitForVisible(cartBadge).getText();
    }
    public void goToCart() {
        waitForClickable(cartLink).click();
    }

}