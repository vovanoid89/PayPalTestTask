package com.gmail.vovanoid89;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionDetailsPage {

    public WebDriver driver;

    public TransactionDetailsPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='transactionNetAmount ppvx_text--lg ']")
    private WebElement generalAmount;

    @FindBy(xpath = "//div[@class='ppvx_col-3 funding-source-right-col']")
    private WebElement paidWithAmount;

    @FindBy(xpath = "//div[@class='ppvx_col-4 numeral']/span[@class='ppvx_text--sm']")
    private WebElement purchaseAmount;

    @FindBy(xpath = "//div[@class='ppvx_col-4 numeral']/span[@class='primary ppvx_text--sm']")
    private WebElement totalAmount;

    @FindBy(xpath = "//span[@dir='ltr'][contains(., '6655')]")
    private WebElement paidWithCardLastNum;

    public String getGeneralAmount()
    {
        return generalAmount.getText();
    }

    public String getPaidWithAmount()
    {
        return paidWithAmount.getText();
    }

    public String getPurchaseAmount()
    {
        return purchaseAmount.getText();
    }

    public String getTotalAmount()
    {
        return totalAmount.getText();
    }

    public String getPaidWithCardLastNum()
    {
        return paidWithCardLastNum.getText();
    }
}
