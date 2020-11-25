package com.gmail.vovanoid89;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class LoginPage
    {

        public WebDriver driver;

        public LoginPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver; }

        @FindBy(xpath = "//input[@name='login_email']")
        private WebElement loginField;

        @FindBy(xpath = "//button[@value='Next']")
        private WebElement nextButton;

        @FindBy(xpath = "//input[@name='login_password']")
        private WebElement passwordField;

        @FindBy(xpath = "//button[@value='Login']")
        private WebElement loginButton;


        public void inputLogin(String login)
        {
            loginField.sendKeys(login);
        }

        public void clickNextButton()
        {
            nextButton.click();
        }

        public void inputPassword(String password)
        {
            passwordField.sendKeys(password);
        }

        public void clickLoginButton()
        {
            loginButton.click();
        }
    }
