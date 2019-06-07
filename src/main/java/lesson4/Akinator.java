package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Scanner;

public class Akinator {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/adminpdf/App/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://ru.akinator.com/");

        //Click 'Play' button
        driver.findElement(By.xpath("//div[@class='btn-play']//span")).click();

        //Start to question -> answer
        while (true) {

            //If question is present on page -> make question - answer
            Boolean isPresent = driver.findElements(By.xpath("//*[@class='question-text']")).size() > 0;
            if (isPresent) {

                //Print question
                String question = driver.findElement(By.xpath("//*[@class='question-text']")).getText();
                System.out.println(question);

                //Print answer
                List<WebElement> answers = driver.findElements(By.xpath("//*[@class='database-selection selector dialog-box']/ul/li/a"));

                int i = 1;
                for (WebElement temp : answers) {
                    String answerChoice = temp.getText();
                    System.out.println(i + " " + answerChoice);
                    i++;
                }

                //Input from user
                System.out.println("Пожалуйста, выберите вариант (введитте от 1 до 5): ");
                Scanner reader = new Scanner(System.in);
                int userAnswer = reader.nextInt();

                //Click using user number
                switch (userAnswer) {

                    case 1:
                        answers.get(0).click();
                        break;

                    case 2:
                        answers.get(1).click();
                        break;

                    case 3:
                        answers.get(2).click();
                        break;

                    case 4:
                        answers.get(3).click();
                        break;

                    case 5:
                        answers.get(4).click();
                        break;

                    default:
                        System.out.println("Incorrect answer number.");
                        break;
                }

                //TODO: change Thread.sleep to wait
                Thread.sleep(3000);

            } else {

                //Print answer end break loop
                String end = driver.findElement(By.xpath("//*[@class='proposal-title']")).getText();
                System.out.println("\nВаш персонаж: " + end);
                break;

            }
        }
    }
}
