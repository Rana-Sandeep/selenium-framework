package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutCompletePage extends BasePage {

    private By pageTitle = By.className("title");
    private By confirmationMessage = By.className("complete-header");
    private By homeButton = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver){
    super(driver);

    }

    public String getPageTitle() {
        waitForUrlContains("checkout-complete");
        waitForVisible(homeButton);
        return getTextOf(pageTitle);
    }

    public String getConfirmationMessage(){

        return waitForVisible(confirmationMessage).getText();


    }

    public void clickHome() {
        waitForClickable(homeButton).click();

    }
}
