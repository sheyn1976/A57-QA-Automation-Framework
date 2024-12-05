import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver = null;

    protected String url = "https://qa.koel.app/";

    protected WebDriverWait explicitWait = null;

    protected WebDriverWait wait = null;

    protected Actions actions = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void setupDriver(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

     //   WebDriver driver = new ChromeDriver(options);
    //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver = new ChromeDriver(options); // driver =ChromeDriver instance
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //ONE TIME
        driver.manage().window().maximize();

        driver.get(baseURL); //open our page here
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));

        actions = new Actions(driver);
        navigateToPage();

    }


    public void navigateToPage() {
        driver.get(url);
    }

    @AfterMethod
    public void closerBrowser() {
        driver.quit();
    }

    @Override
    public String toString() {

        return "This is base test class";
    }
}

