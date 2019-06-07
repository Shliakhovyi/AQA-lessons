package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import trello.pages.LoginPage;

public class LoginTest extends BrowserFactory {

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login("shliakhovyi.sviatoslav@pdffiller.team", "906578grib");
        Assert.assertTrue(!driver.findElements(By.cssSelector(".mod-add")).isEmpty(), "Board page not opened");
    }
}
