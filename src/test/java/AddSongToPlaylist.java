import stepDefinitions.POM.HomePage;
import stepDefinitions.POM.LoginPage;
import stepDefinitions.POM.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static stepDefinitions.WaitUtils.waitUtilVisibilityOfElementLocatedBy;


public class AddSongToPlaylist extends BaseTest{
    @Test
    public void addSongToPlaylist() {

        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys("ilya.sheynblat+1@testpro.io");

        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("$Ma1947va");

        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

       // WebElement logoutButton = driver.findElement(By.cssSelector("a[data-testid='btn-logout']"));
       // logoutButton.click();

        String registrationUrl="https://qa.koel.app/registration";
        Assert.assertEquals(getDriver().getCurrentUrl(), registrationUrl);

     //   driver.quit();



    }

    public static class DeletePlayListTest extends BaseTest {
        LoginPage loginPage=null;
        HomePage homePage=null;
        @Test
        public void deletePlayLIstTest() {
            String playListName="TestPlayListForDeleting";
            loginPage=new LoginPage(getDriver());
            loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va" );
            homePage=new HomePage(getDriver());

          // homePage.createPlayList(actions, playListName);
            homePage.openPlayList(playListName);
            PlaylistPage playlistPage=new PlaylistPage(getDriver());
            playlistPage.deletePlaylist();
            waitUtilVisibilityOfElementLocatedBy(getDriver(), By.xpath("//section[@id='playlists']//li/a[text()='TestPlayListForDeleting']"));

            Assert.assertTrue(homePage.getPlaylistByName(playListName).isDisplayed());
        }
        @Test
        public void addPlayListTest() throws InterruptedException{
            String playListName="TestPlayListForDeleting";
            loginPage=new LoginPage(getDriver());
            loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va" );
//return all finded by this locator (findElements):
            List<WebElement> playLists =getDriver().findElements(By.cssSelector("#playlists li"));
            int previousSize = playLists.size();
            WebElement addPlayListButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists i[role='button']")));
            actions.moveToElement(addPlayListButton).perform();
            addPlayListButton.click();
            Thread.sleep(3000);
            WebElement createPlayListButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
            createPlayListButton.click();

            WebElement playlistNameInput= getDriver().findElement(By.cssSelector("[name=create-simple-playlist-form]>input"));
            playlistNameInput.sendKeys(playListName);
            playlistNameInput.sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'success')]")));
            playLists =getDriver().findElements(By.cssSelector("#playlists li"));
            int actualSize=playLists.size();
            Assert.assertNotEquals(actualSize,previousSize);  // previousSize !=actualSize


        }
    }
}



