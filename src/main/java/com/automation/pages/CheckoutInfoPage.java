package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage {

    private By pageTitle = By.className("title");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");


    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        waitForUrlContains("checkout-step-one");
        return getTextOf(pageTitle);
    }

    public void enterFirstName(String firstName) {
        waitForVisible(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        waitForVisible(lastNameField).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        waitForVisible(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinue() {

        waitForClickable(continueButton).click();

    }
}
