package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class Kissmia {

    private WebDriver driver;
    private String url = "https://kismia.com/";
    private String mail = "golmonosto@desoz.com";
    private String pass = "123456";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/adminpdf/App/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void loginTest() {
        //Log in:
        WebElement email = driver.findElement(By.xpath("(//input[@class='home-page-form__input js_emailField'])[1]"));
        email.clear();
        email.click();
        email.sendKeys(mail);

        WebElement password = driver.findElement(By.xpath("//input[@class='home-page-form__input js_passwordField']"));
        password.clear();
        password.click();
        password.sendKeys(pass);

        driver.findElement(By.xpath("(//*[@class='home-page-form__submit js_submit'])[1]")).click();

        //Assert url after log in:
        Assert.assertEquals(driver.getCurrentUrl(), "https://kismia.com/matches#p=1");
    }

    @Test
    public void manageProfile() throws InterruptedException {
        Wait wait = new WebDriverWait(driver, 2)
                .withTimeout(ofSeconds(15)).pollingEvery(ofMillis(500));

        //Click on profile avatar:
        WebElement profile = driver.findElement(By.xpath("//*[@class='new-header__photo']"));
        profile.click();

        //Click on settings:
        String settings = "(//*[@class='new-header-subs__link'])[2]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(settings)));
        driver.findElement(By.xpath(settings)).click();

        //Click on personal data:
        String personalData = "//*[contains(text(), 'Личные данные')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(personalData)));
        driver.findElement(By.xpath(personalData)).click();

        //Change and save gender:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='settings-path__label' and contains(text(), 'Пол')]")));
        if (driver.findElement(By.xpath("//*[@name='gender' and @value='m']")).isSelected()) {
            driver.findElement(By.xpath("//*[@name='gender' and @value='f']")).click();
        } else {
            driver.findElement(By.xpath("//*[@name='gender' and @value='m']")).click();
        }
        WebElement saveBtn = driver.findElement(By.xpath("(//*[@class='button-FR settings__button button--flat-green js_save'])[1]"));
        saveBtn.click();

        //Change and save age:
        Select ageDropdown = new Select(driver.findElement(By.xpath("//select[@name='year']")));
        ageDropdown.selectByValue("1930");
        saveBtn.click();
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id='year']/option[1]")));

        ageDropdown.selectByValue("1940");
        saveBtn.click();
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id='year']/option[11]")));
        Assert.assertEquals("1940", ageDropdown.getFirstSelectedOption().getText(), "Not equals to 1940");
    }
}
