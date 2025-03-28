package testcases;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.time.Duration;

public class TestNGSecondTestScenario extends TestBase{

    String url;

    @BeforeTest
    @Parameters({"browser", "version", "platform", "url"})
    public void setUpBrowser(String browser, String version, String platform, String url) throws MalformedURLException {
        setUp(browser, version, platform);
        this.driver = driver();
        this.url = url;
    }

    @Test
    public void testNG2() throws MalformedURLException {
        SoftAssert softAssert = new SoftAssert();
        driver.get(url);

        driver.findElement(By.xpath("//a[contains(text(),'Checkbox Demo')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement singleCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("isAgeSelected")));
        singleCheckbox.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtAge")));

        softAssert.assertTrue(checkedText.isDisplayed());

        singleCheckbox.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        softAssert.assertTrue(checkedText.isDisplayed(), "Checkbox is unselected");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
