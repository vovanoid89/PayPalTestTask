package com.gmail.vovanoid89;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class PayPalTest
{
    public static LoginPage loginPage;
    public static UserPage userPage;
    public static TransactionDetailsPage transactionDetailsPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));

        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        transactionDetailsPage = new TransactionDetailsPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("loginPage"));
    }

    @Test
    public void payPalTest()
    {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickNextButton();

        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginButton();

        String userWelcome = userPage.getUserWelcome();
        Assert.assertTrue(userWelcome.contains(ConfProperties.getProperty("userNameExpected")));

        userPage.clickOnNewTrasaction();

        String generalAmount = transactionDetailsPage.getGeneralAmount();
        Assert.assertTrue(generalAmount.contains(ConfProperties.getProperty("generalAmountExpected")));

        String paidWithAmount = transactionDetailsPage.getPaidWithAmount();
        Assert.assertEquals(ConfProperties.getProperty("paidWithAmountExpected"), paidWithAmount);

        String purchaseAmount = transactionDetailsPage.getPurchaseAmount();
        Assert.assertEquals(ConfProperties.getProperty("purchaseAmountExpected"), purchaseAmount);

        String totalAmount = transactionDetailsPage.getTotalAmount();
        Assert.assertEquals(ConfProperties.getProperty("totalAmountExpected"), totalAmount);

        String paidWithCardLastNum = transactionDetailsPage.getPaidWithCardLastNum();
        Assert.assertTrue(paidWithCardLastNum.contains(ConfProperties.getProperty("paidWithCardLastNumExpected")));
    }

    @AfterClass
    public static void tearDown()
    {
        userPage.clickLogOut();
        driver.quit();
    }
}
