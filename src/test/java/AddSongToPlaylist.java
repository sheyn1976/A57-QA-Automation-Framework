import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSongToPlaylist extends BaseTest {


    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String expectedSongAddedMassage = "Added 1 song into \"Ilya Playlist.\"";

        navigateToPage();
        enterEmail("ilya.sheynblat+1@testpro.io");
        enterPassword("$Ma1947va");
        clickSubmit();
        Thread.sleep(5000);
        searchSong("Dark Days");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddBtn();
        choosePlayList();

        Assert.assertEquals(getAddToPlayListSuccessMsg(), expectedSongAddedMassage);
    }

    public void searchSong(String name) throws InterruptedException {
        WebElement searchField = getDriver().findElement(By.cssSelector("input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = getDriver().findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);

    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = getDriver().findElement(By.xpath("//section[@id='songsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }



    public void clickAddBtn() throws InterruptedException {
        WebElement addToButton = getDriver().findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//button[@class='btn-add-to']"));
        addToButton.click();
        Thread.sleep(2000);
    }



    public void choosePlayList() throws InterruptedException {
        WebElement playList = getDriver().findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Ilya playlist')]"));
        playList.click();
        Thread.sleep(2000);

    }
    public String getAddToPlayListSuccessMsg(){
        WebElement notification=getDriver().findElement(By.cssSelector("div.success.show"));
        return notification.getText();

    }
}








