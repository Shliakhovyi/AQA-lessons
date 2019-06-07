package lesson5;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TaskTwo extends BaseTest {
    @Test
    public void facebookTest() {
        driver.get("https://www.facebook.com/");

        driver.findElements(By.cssSelector("#u_0_c"));

    }
}
