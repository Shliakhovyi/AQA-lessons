package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BrowserFactory {

    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/adminpdf/App/chromedriver");
        driver = new ChromeDriver();

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
