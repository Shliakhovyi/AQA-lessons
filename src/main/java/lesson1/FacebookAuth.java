package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookAuth {

    public static void main(String[] args) {

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

        //Click 'Messages' icon
        driver.findElement(By.xpath("//a[@name='mercurymessages']")).click();
        //Wait until chat popup opens
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='_1ijj'])[1]")));

        //Save and Print last message
        String lastMessage = driver.findElement(By.xpath("(//*[@class='_1ijj'])[1]/span[2]")).getText();
        System.out.println(lastMessage);
        
        driver.quit();
    }
}
