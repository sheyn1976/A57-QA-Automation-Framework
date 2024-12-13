import org.example.pages.HomePage;
import org.example.pages.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import org.example.pages.LoginPage;

import static org.example.WaitUtils.waitUtilVisibilityOfElementLocatedBy;

public class DeletePlayListTest extends BaseTest{
    LoginPage loginPage=null;
HomePage homePage=null;
    @Test
    public void deletePlayLIstTest()  {
        String playListName="TestPlayListForDeleting";
       loginPage=new LoginPage(driver);
       loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va" );
       homePage=new HomePage(driver);

       homePage.createPlaylist(actions,wait,playListName);
       homePage.openPlayList(playListName);
        PlaylistPage playlistPage=new PlaylistPage(driver);
        playlistPage.deletePlaylist(wait);
        waitUtilVisibilityOfElementLocatedBy(driver, By.xpath("//section[@id='playlists']//li/a[text()='TestPlayListForDeleting']"));
        Assert.assertTrue(homePage.getPlaylistByName(playListName).isDisplayed());


    }
    @Test
    public void addPlayListTest() throws InterruptedException{
        String playListName="TestPlayListForDeleting";
        loginPage=new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va" );
//return all finded by this locator (findElements):
        List<WebElement> playLists =driver.findElements(By.cssSelector("#playlists li"));
        int previousSize = playLists.size();
        WebElement addPlayListButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists i[role='button']")));
        actions.moveToElement(addPlayListButton).perform();
        addPlayListButton.click();
        Thread.sleep(3000);
        WebElement createPlayListButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        createPlayListButton.click();

        WebElement playlistNameInput= driver.findElement(By.cssSelector("[name=create-simple-playlist-form]>input"));
        playlistNameInput.sendKeys(playListName);
        playlistNameInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'success')]")));
        playLists =driver.findElements(By.cssSelector("#playlists li"));
        int actualSize=playLists.size();
        Assert.assertNotEquals(actualSize,previousSize);  // previousSize !=actualSize


    }
}

