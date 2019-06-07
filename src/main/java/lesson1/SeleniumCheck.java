package lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCheck {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver.get("https://google.com");
        Thread.sleep(5000);
        driver.quit();
    }

}
