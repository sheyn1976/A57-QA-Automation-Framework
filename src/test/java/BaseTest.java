import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver = null;

    protected String url = "https://qa.koel.app/";

    protected WebDriverWait explicitWait = null;

    protected WebDriverWait wait = null;

    protected Actions actions = null;

    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpDriver(String baseURL) throws MalformedURLException {

        driver = pickBrowser(System.getProperty("browser"));
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
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
    String gridUrl = "http://192.168.1.153:4444/";
        ChromeOptions options = new ChromeOptions();
        switch(browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
               return driver = new ChromeDriver(options);

            case "edge":  //gradle clean test -Dbrowser=MicrosoftEdge
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid":  // driver for work with drid
                DesiredCapabilities capabilities = new DesiredCapabilities();
               capabilities.setCapability("browserName", "chrome");

               return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),capabilities);
           default:
               WebDriverManager.chromedriver().setup();
               options.addArguments("--remote-allow-origins=*");
               options.addArguments("--disable-notifications");
               return driver = new ChromeDriver(options);

        }
    }
}

