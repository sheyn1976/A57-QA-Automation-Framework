import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test(testName = " Login with empty email and password test ", groups = "Regresion")
    public void loginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error

        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }
    @Test(testName ="Login with correct credentials test", groups = {"Smoke","Regretion"})
    public void loginUserTest(){
        enterEmail("ilya.sheynblat+1@testpro.io");
        enterPassword("$Ma1947va");
        clickLoginButton();

        WebElement logoutButton = getDriver().findElement(By.cssSelector("a[data-testid='btn-logout']>i"));


        Assert.assertTrue(logoutButton.isDisplayed());

    }
}
/*
public class Homework16 extends BaseTest {

    @Test

    public void registrationNavigation() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[href=registration]"));
             registrationLink.click();

             String registrationUrl="https://qa.koel.app/registration";
             Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
             driver.quit();
             */

