package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By pageTitle = By.className("title");
    private By itemName = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        waitForUrlContains("cart");
        return getTextOf(pageTitle);
    }

    public String getItemName() {
        return waitForVisible(itemName).getText();
    }

    public void checkout() {
        waitForClickable(checkoutButton).click();
    }
}