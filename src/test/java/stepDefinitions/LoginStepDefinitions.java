package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LoginStepDefinitions {

    WebDriver driver;

    @Given("I open browser")
  public void openBrowser(){
      ChromeOptions options =new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      options.addArguments("--disable-notifications");
      driver= new ChromeDriver(options);

  }

    @When("I open login page")
    public void iOpenLoginPage() {
     driver.get("https://qa.koel.app");

    }

    @And("I enter email {string}")
    public void iEnterEmail(String arg0) {
        driver.findElements(By.cssSelector(''))
    }
}


