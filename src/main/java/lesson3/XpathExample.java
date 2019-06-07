package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class XpathExample {

    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void myTest(){

        driver.get("https://www.imdb.com/chart/top");

        List<WebElement> titles = driver.findElements(By.xpath("//*[@class='titleColumn']//a"));
        for(WebElement element: titles){
            System.out.println(element.getText());
        }

        List<WebElement> hrefs = driver.findElements(By.xpath("//*[@class='titleColumn']//a"));
        for(WebElement element: hrefs){
            System.out.println(element.getAttribute("href"));
        }

        List<WebElement> rating = driver.findElements(By.xpath("//*[@class='ratingColumn imdbRating']/strong"));
        for(WebElement element: rating){
            System.out.println(element.getText());
        }

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
