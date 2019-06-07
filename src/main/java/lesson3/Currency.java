package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Currency {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void currencyTest() {

        //Get Privat currency
        driver.get("https://www.privat24.ua/");
        String currencyElement = driver.findElement(By.xpath("(//div[@class='section-content rate'])[1]")).getText();
        //Split currency to different objects
        String[] split = currencyElement.split(" / ");
        //Convert currency to the two double variables
        double buyPrivat = Double.parseDouble(split[0]);
        double sellPrivat = Double.parseDouble(split[1]);

        //Get Ukrsibbank currency
        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        String stringBuyUkrsib = driver.findElement(By.xpath("(//span[@class='mobile-curr-name'])[1]/..")).getText();
        String stringSellUkrsib = driver.findElement(By.xpath("(//span[@class='mobile-curr-name'])[2]/..")).getText();
        //Convert currency to the two double variables
        double buyUkrsibbank = Double.parseDouble(stringBuyUkrsib);
        double sellUkrsibbank = Double.parseDouble(stringSellUkrsib);

        //Get Universalbank currency
        driver.get("https://www.universalbank.com.ua/");
        String stringBuyUniversalbank = driver.findElement(By.xpath("(//td[@class='currency down p-b-xs-2 p-y-1-sm'])[1]/following-sibling::td[1]")).getText();
        String stringSellUniversalbank = driver.findElement(By.xpath("(//td[@class='currency down p-b-xs-2 p-y-1-sm'])[1]/following-sibling::td[2]")).getText();
        //Convert currency to the two double variables
        double buyUniversalbank = Double.parseDouble(stringBuyUniversalbank);
        double sellUniversalbank = Double.parseDouble(stringSellUniversalbank);

        //Get Oschadbank currency
        driver.get("http://www.oschadbank.ua/ua/");
        String stringBuyOschad = driver.findElement(By.xpath("//*[@class='buy-USD']")).getAttribute("data-buy");
        String stringSellOschad = driver.findElement(By.xpath("//*[@class='sell-USD']")).getAttribute("data-sell");
        //Convert currency to the two double variables
        double buyOschad = Double.parseDouble(stringBuyOschad);
        double sellOschad = Double.parseDouble(stringSellOschad);

        //Get NBU currency
        driver.get("http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");
        String stringNbu = driver.findElement(By.xpath("//*[contains(@class, 'cell_c') and text() = 'USD']/following-sibling::td[3]")).getText();
        //Convert currency to the two double variables
        double Nbu = Double.parseDouble(stringNbu) / 100;


        //Average buy currency
        double avgBuy = (buyPrivat + buyUkrsibbank + buyUniversalbank + buyOschad + Nbu) / 5;
        System.out.println("Average 'Buy' currency: " + avgBuy);
        //Average sell currency
        double avgSell = (sellPrivat + sellUkrsibbank + sellUniversalbank + sellOschad + Nbu) / 5;
        System.out.println("Average 'Sell' currency " + avgSell);
        //Min buy currency
        double minBuyCurrency = Math.min(Math.min(Math.min(buyPrivat, buyUkrsibbank), buyUniversalbank), Math.min(buyOschad, Nbu));
        System.out.println("Min 'Buy': " + minBuyCurrency);
        //Max sell currency
        double maxSellCurrency = Math.max(Math.max(Math.max(sellPrivat, sellUkrsibbank), sellUniversalbank), Math.max(sellOschad, Nbu));
        System.out.println("Max 'Sell': " + maxSellCurrency);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
