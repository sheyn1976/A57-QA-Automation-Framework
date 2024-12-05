package  org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {
    By avatar = By.cssSelector("#userBadge img");

    By addPlaylistButton=By.cssSelector("#playlists i[role='button']");

    By createPlaylistButton=By.cssSelector("[data-testid='playlist-context-menu-create-simple']");

    By playlistNameInput=By.cssSelector("[name='create-simple-playlist-form']>input");


  public HomePage(WebDriver existDriver){
      super(existDriver);

    }
   public WebElement getAvatar() {
       return findElement(avatar);
   }
   public WebElement getAddPlaylistButton(WebDriverWait wait){
   return waitAndFindWebElement(wait, addPlaylistButton);

   }
   public WebElement getCreatePlaylistButton(WebDriverWait wait){
      return waitAndFindWebElement(wait, createPlaylistButton);
   }
    public WebElement getPlaylistNameInput(WebDriverWait wait) {
      return waitAndFindWebElement(wait,playlistNameInput);

  }

    public void createPlaylist (Actions actions, WebDriverWait wait, String playlistName) {
        actions.moveToElement(getAddPlaylistButton(wait)).perform();
        getAddPlaylistButton(wait).click();
        getCreatePlaylistButton(wait).click();
        getPlaylistNameInput(wait).sendKeys(playlistName);
        getPlaylistNameInput(wait).sendKeys(Keys.ENTER);
    }
     public WebElement getPlaylistByName(String playlistName){
      return findElement(By.xpath(String.format("//section[@id='playlists']//a[text()='%s']",playlistName)));

     }

   public void openPlayList(String playlistName){
getPlaylistByName(playlistName).click();


   }
}
