import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.POM.LoginPage;

public class PlaySongTest extends BaseTest  {
    LoginPage loginPage=null;

    @Test
    public void playSongTest() {

        loginPage=new LoginPage(getDriver());
        loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        WebElement favoritesPlayListLink= getDriver().findElement(By.xpath("//li[contains(@class,'favorites')]/a"));
        favoritesPlayListLink.click();
        WebElement song= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='favoritesWrapper']//td[text()='Riqui-Riqui']")));
        actions.doubleClick(song).perform();
       // song.click();
        // song.sendKeys(Keys.ENTER);
WebElement soundBar = getDriver().findElement(By.cssSelector("[data-test='soundbars']"));
        Assert.assertTrue(soundBar.isDisplayed());

    }
}
