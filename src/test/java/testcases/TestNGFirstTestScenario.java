package testcases;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.time.Duration;

public class TestNGFirstTestScenario extends TestBase {


    String url;

    @BeforeTest
    @Parameters({"browser", "version", "platform", "url"})
    public void setUpBrowser(String browser, String version, String platform, String url) throws MalformedURLException {
        setUp(browser, version, platform);
        this.driver = driver();
        this.url = url;
    }

    @Test(timeOut = 20000)
    public void testNG1() throws MalformedURLException, InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));

        String expectedTitle = "Selenium Grid Online | Run Selenium Test On Cloud";
        String actualText = driver.getTitle();
        softAssert.assertEquals(actualText, expectedTitle,"Page title validation failed");

        driver.findElement(By.xpath("//a[contains(text(),'Input Form Submit')]")).click();
        softAssert.assertAll();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }



//    @Test
//    public void testScenario1() {
//        SoftAssert softAssert = new SoftAssert();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // 1. Explicit wait for DOM elements to be available
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*")));
//
//        // 2. SoftAssert for page title validation (expected to fail)
//        softAssert.assertEquals(driver.getTitle(), "LambdaTest", "Page title validation failed");
//
//        // Report all assertion failures at the end
//        softAssert.assertAll();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if(driver != null) {
//            driver.quit();
//        }
//    }
}
