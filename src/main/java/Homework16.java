import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Homework16 {
    ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

    WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    String url = "https://qa.koel.app/";
        driver.get(url);
}

