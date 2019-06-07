package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TaskOne extends BaseTest {

    @Test
    public void Films() {
        driver.get("http://liniakino.com/showtimes/aladdin/");

        List<WebElement> films = driver.findElements(By.cssSelector(".showtime-movie h1 a"));

        for (WebElement temp : films) {
            String filmName = temp.getText();
            System.out.println(filmName);
        }

    }

}
