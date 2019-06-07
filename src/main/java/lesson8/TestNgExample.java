package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgExample {

    private WebDriver driver;
    private String expected_title = "Save Time Editing PDF Documents Online For Free";

    @Test
    public void firstTestNgExampleTest() {
        System.setProperty("webdriver.chrome.driver", "/home/adminpdf/App/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.pdffiller.com/en/?mode=view");

        WebElement elementTitle = driver.findElement(By.xpath("//*[@class='page-title']"));
        String actualTitle = elementTitle.getText();
        Assert.assertEquals(expected_title, actualTitle, "Title is incorrect");
        Assert.assertTrue(actualTitle.equals(expected_title), "Title is incorrect");
    }
}
