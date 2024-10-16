import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver=null;
  protected   String url = "https://qa.koel.app/";
  WebDriverWait explicitWait= null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
@Parameters({"baseURL"})
    public void  setupDriver(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options); // driver =ChromeDriver instance

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //ONE TIME
        driver.manage().window().fullscreen();
        driver.get(baseURL); //open our page here
        explicitWait= new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        navigateToPage();

    }
            public WebDriver getDriver() {
            return driver;
        }

       public void navigateToPage(){
        driver.get(url);
       }


@AfterMethod
    public   void closerDriver() {
        getDriver().quit();
    }

    public void enterEmail (String email) {
        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
  public void enterPassword (String password){
      WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
      passwordField.clear();
      passwordField.sendKeys(password);
  }
  public void clickLoginButton(){
      WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
      loginButton.click();
    }
  public void loginKoel(String email,String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
      //  wait.until(10_sec, mainSection.isDisplayed());

  }
  @Override
    public String toString(){

        return "This is base test class";
  }
    }

