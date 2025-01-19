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
import java.util.HashMap;

public class BaseTest {

    private WebDriver driver = null;

    protected String url = "https://qa.koel.app/";

    protected WebDriverWait explicitWait = null;

    protected WebDriverWait wait = null;

    protected Actions actions = null;

    private static final ThreadLocal<WebDriver> threadlocal = new ThreadLocal<>();
//final mean we cant change the constant
    //private we can see the constant only here
   // static mean the constant initialize im moment of compilation of code

    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpDriver(String baseURL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        threadlocal.set(driver);

        threadlocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //ONE TIME
        getDriver().manage().window().maximize();

        threadlocal.get().get(baseURL); //open our page here
        wait = new WebDriverWait(threadlocal.get(), Duration.ofSeconds(10));
        actions = new Actions(threadlocal.get());
        navigateToPage();
    }

    public WebDriver getDriver(){
        return threadlocal.get();
    }
    public void navigateToPage() {
        driver.get(url);
    }

    @AfterMethod
    public void closerBrowser() {
        getDriver().quit();
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        String gridUrl = "http://192.168.1.153:4444/";
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                return driver = new ChromeDriver(options);
            case "edge":  //gradle clean test -Dbrowser=MicrosoftEdge
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid":  // driver for work with grid
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);

            case "Lambda":
                String hub = "@hub.lambdatest.com/wd/hub";
                String userName = "ilyasheynblat";
                String accessKey ="eXU3xKRCAatI440tm894IndTfFjhFB0gjKeUmpQ4Ry9MbiVHb1";

                capabilities.setCapability("browserName","Chrome");
                capabilities.setCapability("browserVersion","131.0");
                HashMap<String, Object> ltOptions = new HashMap<>();
                ltOptions.put("username", userName);
                ltOptions.put("accessKey", accessKey);
                ltOptions.put("platformName", "Windows 11");
                ltOptions.put("project", "Koel");
                capabilities.setCapability("LT:Options", ltOptions);
                return driver = new RemoteWebDriver(URI.create("https://" + userName + ":" + accessKey + hub).toURL(), capabilities);

            default:
                WebDriverManager.chromedriver().setup();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                return driver = new ChromeDriver(options);
        }
    }

    }





