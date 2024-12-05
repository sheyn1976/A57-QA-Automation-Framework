import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class PlaySongByActionTest extends BaseTest {

    LoginPage loginPage = null;

    @Test
    public void playSongByContextClick() {
        loginPage = new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");

        String songLocator = "//section[@id='songsWrapper']//td[text()='%s']"; //'%s' can add any name of songs
        String songName = "M33 Project - Emotional Soundtrack";  // ='%s' instead name of song

        WebElement allSongsMenuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='sidebar'] .songs")));
        allSongsMenuItem.click();
        WebElement song = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(songLocator, songName))));// instead locator!!!!

        actions.contextClick(song).perform();
        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='song-context-menu'] .playback")));
        playButton.click();
        WebElement soundBar = driver.findElement(By.cssSelector("[data-test='soundbars']"));
        Assert.assertTrue(soundBar.isDisplayed());

    }

    @Test
    public void playSongByHoverMouseTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        WebElement allSongsMenuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='sidebar'] .songs")));
        allSongsMenuItem.click();

        WebElement mediaPlayer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainFooter .play")));
        actions.moveToElement(mediaPlayer).click().perform();
        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainFooter .play i")));
        playButton.click();
        WebElement soundBar = driver.findElement(By.cssSelector("[data-test='soundbars']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }
}

