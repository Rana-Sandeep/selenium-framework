    package com.automation.pages;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;

    public class LoginPage extends BasePage{

        private By usernameField =  By.id("user-name");
        private By passwordField = By.id("password");
        private By loginButton = By.id("login-button");
        private By errorMessage = By.cssSelector("[data-test='error']");


        public LoginPage(WebDriver driver){
            super(driver);

                }

        public void enterUsername(String username){

            waitForVisible(usernameField).sendKeys(username);
        }

        public void enterPassword(String password){
            waitForVisible(passwordField).sendKeys(password);
        }

        public void clickLogin(){
            waitForClickable(loginButton).click();
        }

        public String getErrorMessage() {
            return waitForVisible(errorMessage).getText();

        }

    }
