import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

public class PlayListTest extends BaseTest {

    @Test
    public void deletePlayList() {
        String playListName = UUID.randomUUID().toString(); //Garanty don't repeat the same playlist
    //    String playListLocatorByName=" //li[@class='playlist' and contains(text(),'%s')]"; //intsted 'ILYA SH' insert '%s'
        loginKoel("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
        createPlayList(playListName);
   //     explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(playListLocatorByName, playListName))));//format let us use %s
        List<WebElement> playLists = getDriver().findElements(By.xpath("//li[contains(@class,'playlist')]"));
        deletePlayListByName(playLists, playListName);
      //  List<WebElement> playLists= getDriver().findElements(By.xpath("//li[contains(@class,'playlist')]"));
Assert.assertFalse(playLists.contains(playListName));
    }
 /*       //1
        WebElement playlist = getDriver().findElement(By.xpath("//a[text()='test']"));
//...
        Assert.assertEquals(playList.isDisplayed(), false);
   */



/*public boolean isVisible(WebElement element) {
    try {
        element.isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
    return true;
 }
*/
    public void createPlayList(String playlistName){
WebElement createButton= getDriver().findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));

        createButton.click();
explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[ data-testid='playlist-context-menu-create-simple']")));
WebElement createNewPlayListButton= getDriver().findElement(By.cssSelector("li[ data-testid='playlist-context-menu-create-simple']"));
        createNewPlayListButton.click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[name='create-simple-playlist-form']>input")));
        WebElement createNewPlayListInputField= getDriver().findElement(By.cssSelector("form[name='create-simple-playlist-form']>input"));
        createNewPlayListInputField.sendKeys(playlistName);
        createNewPlayListInputField.sendKeys(Keys.ENTER);
      // actions.contextClick(createButton).moveToElement(createNewPlayListButton).build().perform();
      //  createButton.click();  //==
     //   actions.moveToElement(createButton).build().perform();
     //   actions.release();

    }


public void deletePlayListByName(List<WebElement> playLists, String playListName) {
  //  List<WebElement> elements = getDriver().findElements(By.xpath("//li[contains(@class,'playlist')]"));

    for(WebElement item: playLists) {
        if (item.getText().equals(playListName)) {
            actions.contextClick(item).perform();
            WebElement deletePlayListButton = getDriver().findElement(By.cssSelector("li[data-testid='playlist-context-menu-delete-100493']"));
            deletePlayListButton.click();

        }
    }
    }
}

