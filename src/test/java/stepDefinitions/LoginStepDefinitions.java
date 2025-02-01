package stepDefinitions;
import POM.LoginPage;
import POM.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.testng.Assert;
import POM.LoginPage;

import static java.sql.DriverManager.getDriver;
import static org.bouncycastle.cms.RecipientId.password;

public class LoginStepDefinitions {
   WebDriver driver;

  // @Given("I open browser")
   @Before
   public void openBrowser() {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      options.addArguments("--disable-notifications");
      driver = new ChromeDriver(options);
     // wait new WebDriverWait(driver, Duration.ofSeconds(10));

   }

   @When("I open login page")
   public void iOpenLoginPage() {
      driver.get("https://qa.koel.app");
   }
   @And("I enter email {string}")
   public void iEnterEmail(String arg0) {
       LoginPage loginPage= new LoginPage(driver);
       loginPage.provideEmail(arg0);

    //  driver.findElement(By.cssSelector("input[type='email']")).sendKeys(arg0);

   }

   @And("enter password {string}")
   public void enterPassword(String arg0) {
       LoginPage loginPage= new LoginPage(driver);
       loginPage.providePassword(arg0);

     // driver.findElement(By.cssSelector("input[type='password']")).sendKeys(arg0);
   }

   @And("enter submit")
   public void enterSubmit() {
       LoginPage loginPage= new LoginPage(driver);
       loginPage.clickSubmit();

     // driver.findElement(By.cssSelector("button[type='submit']")).click();
   }

   @Then("I am logged in")
   public void iAmLoggedIn() {
       HomePage homePage= new HomePage(driver);
       Assert.assertTrue(homePage.getAvatar().isDisplayed());

   }

//   @And("I close browser")
   @After
   public void iCloseBrowser() {
      driver.quit();
   }

    @And("enter incorrect password {string}")
    public void enterIncorrectPassword(String arg0) {
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(arg0);
    }

    @Then("I am  not logged in")
    public void iAmNotLoggedIn() {

        LoginPage   loginPage = new LoginPage(driver);
        loginPage.providePassword("i@testpro.io");


                Assert.assertFalse(loginPage.getLogo().isDisplayed());
    }
}