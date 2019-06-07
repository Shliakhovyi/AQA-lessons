package lesson3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class SeatsOnFilm {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public boolean isElementPresent(final By locator, long seconds) {
        Wait wait = new FluentWait(driver)
                .withTimeout(ofSeconds(seconds))
                .pollingEvery(ofMillis(500))
                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    @Test
    public void damboFilmSeatsTest() throws InterruptedException {

        driver.get("http://liniakino.com/showtimes/aladdin/");

        //Click on first session of the Dambo film
        driver.findElement(By.xpath("(//*[contains(text(), 'Дамбо')]/../..//li[@class='showtime-item']/a)[1]")).click();


        //Wait for element and polling it every x millis
        FluentWait wait = new WebDriverWait(driver, 10)
                .withTimeout(ofSeconds(15)).pollingEvery(ofMillis(500))
                .ignoring(ElementNotVisibleException.class, NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        //Switch to frame
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='vkino-widget']/iframe")));

        //Close pop-up in frame
        By cross = By.xpath("//div[@class='window-close arcticmodal-close']");
        isElementPresent(cross, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cross));
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(cross)).click().build().perform();

        //Amount of all seats
        List<WebElement> allSeats = driver.findElements(By.xpath("//div[contains(@id,'hseat')]"));
        int amountAllSeats = 0;
        int amountOfOccupiedSeats = 0;
        for (WebElement seat : allSeats) {
            if (seat.getAttribute("class").equals("seat seat-occupied")) { //Amount of occupied seats
                amountOfOccupiedSeats++;
            }
            amountAllSeats++;
        }

        System.out.println("Amount of all seats: " + amountAllSeats);
        System.out.println("Amount of occupied seats: " + amountOfOccupiedSeats);

        //Amount of available seats
        int amountOfAvailableSeats = amountAllSeats - amountOfOccupiedSeats;
        System.out.println("Amount of available seats: " + amountOfAvailableSeats);

        //Percent of occupied seats from all seats
        double percentOfOccupied = (double) amountOfOccupiedSeats / amountAllSeats * 100;
        System.out.println("Percent of occupied seats from all seats: " + percentOfOccupied);

        //Percent of available seats from all seats
        double  percentOfAvailable = (double) amountOfAvailableSeats / amountAllSeats * 100;
        System.out.println("Percent of available seats from all seats: " + percentOfAvailable);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
