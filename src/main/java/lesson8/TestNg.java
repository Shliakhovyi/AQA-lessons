package lesson8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNg {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/adminpdf/App/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.pdffiller.com/en/?mode=view");
    }
}
