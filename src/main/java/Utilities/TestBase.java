package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class TestBase {
    public static String hubURL = "https://hub.lambdatest.com/wd/hub";

    protected WebDriver driver;

    public synchronized void setUp(String browser, String version, String platform) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", version);
        capabilities.setCapability("platformName", platform);
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "sakunithilakarathne96");
        ltOptions.put("accessKey", "LT_ew11nowdmXUThoR1Cu1IgW2SwZdTf6C2xjgCib2jaoT5pUQ");
        ltOptions.put("build", "TestNGExam_lambdatest_try2");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("platformName", platform);
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("video", true);
        ltOptions.put("network", true);
        ltOptions.put("console", true);
        ltOptions.put("visual", true);
        capabilities.setCapability("LT:Options", ltOptions);

        DriverFactory.getInstances().setDriver(new RemoteWebDriver(new URL(hubURL), capabilities));
    }

    public WebDriver driver() {
        return DriverFactory.getInstances().getDriver();
    }
}
