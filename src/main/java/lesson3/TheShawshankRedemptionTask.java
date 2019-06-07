package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TheShawshankRedemptionTask {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test(enabled = false)
    public void shawshankFilmTest() {

        driver.get("https://www.imdb.com/title/tt0111161/");

        //1. Find and print film name
        String filmName = driver.findElement(By.xpath("//div[@class='title_wrapper']/h1[@class]")).getText();
        System.out.println("Name: " + filmName);

        //2. Find and print year of the film
        String filmYear = driver.findElement(By.xpath("//*[@id='titleYear']/a")).getText();
        System.out.println("Year: " + filmYear);

        //3. Find and print film time in min and sec
        String filmTime = driver.findElement(By.xpath("(//time)[2]")).getText();
        //Convert film time to number in seconds
        String filmTimeConvert = filmTime.replaceAll("[^0-9+]","");
        int timeInSec = 0;
        try {
            timeInSec = (Integer.parseInt(filmTimeConvert))*60;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(filmTimeConvert + " min; " + timeInSec + " sec");

        //4. Find and print film rating
        String rating = driver.findElement(By.xpath("//*[@itemprop='ratingValue']")).getText();
        System.out.println("Rating: " + rating);

        //5. Find and print genre
        String genre = driver.findElement(By.xpath("//*[contains(@class, 'inline') and text() = 'Genres:']/following-sibling::a")).getText();
        System.out.println("Genre: " + genre);

        //6. Find and print film trailer
        String trailer = driver.findElement(By.xpath("//div[@class='slate']/a")).getAttribute("href");
        System.out.println("Trailer: " + trailer);

        //7. Find and print film poster
        String poster = driver.findElement(By.xpath("//div[@class='poster']//img")).getAttribute("src");
        System.out.println("Poster: " + poster);

        //8. Find and print film director
        String director = driver.findElement(By.xpath("//*[contains(@class, 'inline') and text() = 'Director:']/following-sibling::a")).getText();
        System.out.println("Director: " + director);

        //9. Find and print first 5 actors of the film
        List<WebElement> actors = driver.findElements(By.xpath("//*[@id=\"titleCast\"]//tr/td[2]/a"));
        for (int i = 0; i < 5; i++) {
            String actor = actors.get(i).getText();
            System.out.println("Actor: " + actor);
        }

        //10. Find and print rating Metascore
        String metaRating = driver.findElement(By.xpath("//*[contains(@class,'metacriticScore')]/span")).getText();
        System.out.println("Metascore Rating: " + metaRating);

        //11. Find counnt of reviews from users and critic and their sum
        List<WebElement> reviewsList = driver.findElements(By.xpath("//div[@class='titleReviewBarItem titleReviewbarItemBorder']//a"));

        int reviewsSum = 0;
        for (WebElement element : reviewsList) {
            String review = element.getText();
            //Print reviews from users and critic
            System.out.println("Reviews count: " + review);
            //Convert reviews to numbers and print sum of reviews
            String reviewConvert = review.replaceAll("[^0-9+]", "");
            int reviewsToNumber = 0;
            try {
                reviewsToNumber = Integer.parseInt(reviewConvert);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
            reviewsSum += reviewsToNumber;
        }
        System.out.println("Sum of users and critic reviews: " + reviewsSum);

        //12. Name of first 3 similar films
        List<WebElement> similarFilmsList = driver.findElements(By.xpath("//div[@class='rec_page rec_selected']//a/img"));
        for (int i = 0; i < 3; i++) {
            String similarNameFilm = similarFilmsList.get(i).getAttribute("title");
            System.out.println("Similar film name: " + similarNameFilm);
        }

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
