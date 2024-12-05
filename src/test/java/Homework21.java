import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework21 extends BaseTest {
LoginPage loginPage =null;

    @Test
    public void playSong() {
        loginPage=new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlay();
        Assert.assertTrue(isSongPlaying());

    }

    public void chooseAllSongsList() {
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public void contextClickFirstSong() {
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        actions.contextClick(firstSong).perform();

    }

    public void choosePlay() {
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();

    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer =driver.findElement(By.cssSelector("div[data-testid='sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();

    }

    @Test
    public void hoverOverPlayButton() {
        loginPage=new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        Assert.assertTrue(hoverPlay().isDisplayed());
    }

        public WebElement hoverPlay() {
            WebElement play = driver.findElement(By.cssSelector("span .play"));
            actions.moveToElement(play).perform();
            return explicitWait.until(ExpectedConditions.visibilityOf(play));
    }

        @Test
    public void listOfSongsWebElements() {
            loginPage=new LoginPage(driver);
            loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
            choosePlaylistByName("Dark Days");
            displayAllSongs();
            Assert.assertEquals(displayAllSongs().size(),3);
    }

    private void  choosePlaylistByName(String name) {
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + name + "')]"))).click();

    }
    public List displayAllSongs() {
        List<WebElement> songList =driver.findElements(By.cssSelector("#playlistWrapper td.title"));
        return songList;
    }
    @Test
    public void renamePlaylist(){
        String playlistName="Dark Days";
        loginPage=new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        doubleClickChoosePlaylist();
        enterPlaylistName(playlistName);
        String newName=getPlaylistName();
        Assert.assertEquals(playlistName, newName);
    }

    public void doubleClickChoosePlaylist(){
        WebElement playlistElement=explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
      //  Actions actions =new Actions(driver);
        actions.doubleClick(playlistElement).perform();
    }
    public void  enterPlaylistName(String name){
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,Keys.END),name);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    private String getPlaylistName(){
        WebElement playlistElement=explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)>a")));
        String name =playlistElement.getText();
        return name;


    }
}







