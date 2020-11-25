package com.gmail.vovanoid89;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

    public WebDriver driver;

    public UserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//span[contains(., 'John')]")
    private WebElement userWelcomeMessage;

    @FindBy(xpath = "//a[@data-name='activityRowItem'][1]")
    private WebElement newTransaction;

    @FindBy(xpath = "//a[@id='header-logout']")
    private WebElement logOut;

    public String getUserWelcome()
    {
        return userWelcomeMessage.getText();
    }

    public void clickOnNewTrasaction()
    {
        newTransaction.click();
    }

    public void clickLogOut()
    {
        logOut.click();
    }
}