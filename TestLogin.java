package com.automation.tests;

import com.automation.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLogin {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() throws InterruptedException {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        Thread.sleep(2000);
        Assert.assertTrue(loginPage.isDashboardVisible(), "Login failed: Dashboard not found.");
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
