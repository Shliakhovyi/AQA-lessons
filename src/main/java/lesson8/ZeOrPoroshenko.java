package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class ZeOrPoroshenko {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/adminpdf/App/chromedriver");

        //Disable browser popup notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        //Open facebook
        driver.get("https://uk-ua.facebook.com/");
        driver.manage().window().maximize();

        //Input username
        WebElement userName = driver.findElement(By.id("email"));
        userName.clear();
        userName.sendKeys("6572071413");

        //Input password
        WebElement password = driver.findElement(By.id("pass"));
        password.clear();
        password.sendKeys("s1gngr0w");

        //Click 'Log In'
        driver.findElement(By.id("loginbutton")).click();

        //Scroll 20th times:
        for (int i = 0; i < 20; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Wait wait = new WebDriverWait(driver, 10)
                    .withTimeout(ofSeconds(15)).pollingEvery(ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@data-testid='fbfeed_placeholder_story']")));
        }

        //Count Ze posts:
        List<WebElement> zePosts = driver.findElements(By.xpath("//*[@data-testid='post_message']//p[contains(text(), 'Зеленський')]"));
        System.out.println("Количество постов про Зеленского: " + zePosts.size());

        //Count Poroh posts:
        List<WebElement> porohPosts = driver.findElements(By.xpath("//*[@data-testid='post_message']//p[contains(text(), 'Порошенко')]"));
        System.out.println("Количество постов про Порошенко: " + porohPosts.size());

        driver.quit();
    }
}
