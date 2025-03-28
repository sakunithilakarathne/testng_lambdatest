package testcases;
import Utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.time.Duration;

public class TestNGThirdTestScenario extends TestBase{

    String url;

    @BeforeTest
    @Parameters({"browser", "version", "platform", "url"})
    public void setUpBrowser(String browser, String version, String platform, String url) throws MalformedURLException {
        setUp(browser, version, platform);
        this.driver = driver();
        this.url = url;
    }

    @Test
    public void testNG3() throws MalformedURLException, InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        driver.get(url);

        driver.findElement(By.xpath("//a[contains(text(),'Javascript Alerts')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        WebElement alertBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".my-30")));
        alertBtn.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals(alertText, "I am an alert box!");
        alert.accept();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
