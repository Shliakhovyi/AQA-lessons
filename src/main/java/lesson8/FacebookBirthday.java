package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.Random;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class FacebookBirthday {

    public static void facebookLogin(WebDriver driver) {

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
    }

    public static void checkTodayBirthday(WebDriver driver, Wait wait) {

        //Go to Birthday page
        driver.findElement(By.xpath("//*[@data-nav-item-id='2344061033']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-key='birthdays']")));
        driver.findElement(By.xpath("//*[@data-key='birthdays']")).click();

        //Check if someone have birthday today
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='birthdays_today_card']")));
            driver.findElement(By.xpath("//*[@id='birthdays_today_card']"));
        } catch (NoSuchElementException e) {
            System.out.println("Сегодня никто не празднует день рождения. " + e);
        }
    }

    public static String greetingsContainer() {

        //Take random greeting
        String[] greetingsArr = {"С днём рождения!", "С ДР!", "Счастья, здоровья!"};
        int rnd = new Random().nextInt(greetingsArr.length);
        System.out.println(greetingsArr[rnd]);
        return greetingsArr[rnd];
    }

    public static void sendBirthdayGreetings(WebDriver driver, Wait wait) {

        String messageIcon = "//*[@class='_42ft _4jy0 _4jy4 _517h _51sy']";
        String messageInput = "//*[@class='_552h']";
        String friendName = "//*[@class='_2nlw _2nlv']";

        //Open account of friend with birthday
        driver.findElement(By.xpath("(//*[@id='birthdays_today_card']/following-sibling::div//a)[1]")).click();

        //Save friend name
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(friendName)));
        String name = driver.findElement(By.xpath(friendName)).getText();
        name = name.substring(0, name.indexOf(' '));

        //Open messages modal
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(messageIcon)));
        driver.findElement(By.xpath(messageIcon)).click();


        //Send random greeting to friend
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(messageInput)));
        driver.findElement(By.xpath(messageInput)).click();
        driver.findElement(By.xpath(messageInput)).sendKeys("Привет!" + name + greetingsContainer());
    }

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/adminpdf/App/chromedriver");

        //Disable browser popup notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        //Waiter initialization
        Wait wait = new WebDriverWait(driver, 2)
                .withTimeout(ofSeconds(15)).pollingEvery(ofMillis(500));

        //Open facebook
        driver.get("https://uk-ua.facebook.com/");
        driver.manage().window().maximize();

        //Login
        facebookLogin(driver);

        //Check Today Birthday
        checkTodayBirthday(driver, wait);

        //Send greetings
        sendBirthdayGreetings(driver, wait);

        driver.quit();
    }
}
