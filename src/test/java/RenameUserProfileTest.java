import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class RenameUserProfileTest extends BaseTest{

    @Test(testName = "Rename user name test", groups = {"Smoke","Regression"})

    public void renameUserProfileTest() throws InterruptedException{
        String newName= UUID.randomUUID().toString();


enterEmail("ilya.sheynblat+1@testpro.io");
enterPassword("$Ma1947va");
clickLoginButton();

        Thread.sleep(5000);

        WebElement avatar= getDriver().findElement(By.cssSelector("img[class='avatar']"));
        avatar.click();

        WebElement currentPasswordField= getDriver().findElement(By.cssSelector("input[id='inputProfileCurrentPassword']"));
        currentPasswordField.sendKeys("$Ma1947va");

        WebElement profileNameField= getDriver().findElement(By.cssSelector("input[id='inputProfileName']"));
        profileNameField.clear();
        profileNameField.sendKeys(newName);


        WebElement submitButton= getDriver().findElement(By.cssSelector(".btn-submit"));
        submitButton.click();

        Thread.sleep(5000);

        Assert.assertEquals(profileNameField.getText(),newName);
    }
}
