import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;



public class AddSongToPlaylist extends BaseTest{
    @Test
    public void addSongToPlaylist() {
        /*
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

*/

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys("ilya.sheynblat+1@testpro.io");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("$Ma1947va");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

       // WebElement logoutButton = driver.findElement(By.cssSelector("a[data-testid='btn-logout']"));
       // logoutButton.click();

        String registrationUrl="https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

     //   driver.quit();



    }
}



