package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    private By pageTitle = By.className("title");
    private By itemName = By.className("inventory_item_name");
    private By itemTotal = By.className("summary_subtotal_label");
    private By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
    }

    public String getPageTitle() {

        waitForUrlContains("checkout-step-two");
        return getTextOf(pageTitle);
    }
    public String getItemName() {

        return waitForVisible(itemName).getText();

    }

    public String getItemTotal() {
        return waitForVisible(itemTotal).getText();

    }
    public void clickFinish() {
        waitForClickable(finishButton).click();

    }


}
