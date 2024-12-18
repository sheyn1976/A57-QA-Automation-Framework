import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class RenameUserProfileTest extends BaseTest{
    LoginPage loginPage=null;
    @Test(testName = "Rename user name test", groups = {"Smoke","Regression"})

    public void renameUserProfileTest() {
        String newName= UUID.randomUUID().toString();
        loginPage=new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        WebElement avatar= driver.findElement(By.cssSelector("img[class='avatar']"));
        avatar.click();

        WebElement currentPasswordField= driver.findElement(By.cssSelector("input[id='inputProfileCurrentPassword']"));
        currentPasswordField.sendKeys("$Ma1947va");

        WebElement profileNameField= driver.findElement(By.cssSelector("input[id='inputProfileName']"));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
        WebElement submitButton= driver.findElement(By.cssSelector(".btn-submit"));
        submitButton.click();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'success')]")));

       // Thread.sleep(3000);

        Assert.assertEquals(profileNameField.getText(),newName);
    }
}
