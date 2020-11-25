package com.gmail.vovanoid89;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static com.gmail.vovanoid89.ConfProperties.*;

public class PayPalTest
{
    public static LoginPage loginPage;
    public static UserPage userPage;
    public static TransactionDetailsPage transactionDetailsPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        System.setProperty("webdriver.chrome.driver", getProperty("chromeDriver"));

        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);
        transactionDetailsPage = new TransactionDetailsPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(getProperty("loginPage"));
    }

    @Test
    public void payPalTest()
    {
        loginPage.inputLogin(getProperty("login"));
        loginPage.clickNextButton();

        loginPage.inputPassword(getProperty("password"));
        loginPage.clickLoginButton();

        String userWelcome = userPage.getUserWelcome();
        Assert.assertTrue(userWelcome.contains(getProperty("userNameExpected")));

        userPage.clickOnNewTrasaction();

        String generalAmount = transactionDetailsPage.getGeneralAmount();
        Assert.assertTrue(generalAmount.contains(getProperty("generalAmountExpected")));

        String paidWithAmount = transactionDetailsPage.getPaidWithAmount();
        Assert.assertEquals(getProperty("paidWithAmountExpected"), paidWithAmount);

        String purchaseAmount = transactionDetailsPage.getPurchaseAmount();
        Assert.assertEquals(getProperty("purchaseAmountExpected"), purchaseAmount);

        String totalAmount = transactionDetailsPage.getTotalAmount();
        Assert.assertEquals(getProperty("totalAmountExpected"), totalAmount);

        String paidWithCardLastNum = transactionDetailsPage.getPaidWithCardLastNum();
        Assert.assertTrue(paidWithCardLastNum.contains(getProperty("paidWithCardLastNumExpected")));
    }

    @AfterClass
    public static void tearDown()
    {
        userPage.clickLogOut();
        driver.quit();
    }
}
