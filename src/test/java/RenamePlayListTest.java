import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static java.lang.String.format;


public class RenamePlayListTest extends BaseTest {
    LoginPage loginPage=null;
    HomePage homePage=null;
    String newPlayListName = "New playlist";
    String currentPlayListName = "Dark Days";


    @Test
    public void deletePlayListTest() throws InterruptedException {
        loginPage=new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        homePage =new HomePage(driver);
        homePage.renamePlayList(currentPlayListName, newPlayListName);

        Assert.assertEquals(newPlayListName, homePage.getPlayListByName(newPlayListName).getText());
       //or:  Assert.assertTrue(homePage.getPlayListByName(newPlayListName).isDisplayed());
/*
        playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//section[@id='playlists']//li/a[text()='%s'", newPlayListName))));
        Thread.sleep(3000);
        actions.contextClick(playList).perform();
        editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-testid, 'playlist-context-menu-edit')]")));
        editButton.click();
        renamePlaylistInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li//input[@type='text")));
        for (int i = 0; i < newPlayListName.length(); i++) {
            renamePlaylistInput.sendKeys(Keys.BACK_SPACE);
        }
        renamePlaylistInput.sendKeys(currentPlayListName);
        renamePlaylistInput.sendKeys(Keys.ENTER);

 */ // refactoring
    }
    @AfterMethod
    public void rollBackChanges() throws InterruptedException{
        homePage=new HomePage(driver);
        homePage.renamePlayList(newPlayListName, currentPlayListName);
    }

}