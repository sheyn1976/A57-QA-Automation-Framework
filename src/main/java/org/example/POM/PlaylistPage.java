package org.example.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PlaylistPage extends BasePage {

@FindBy(xpath = "//button[contains(@class,'del btn-delete-playlist')]" )
    WebElement deleteButton;

   public PlaylistPage(WebDriver existDriver) {
       super(existDriver);
   }

   public WebElement getDeletePlaylistButton(){
       return deleteButton;
   }

public void deletePlaylist(){
       getDeletePlaylistButton().click();
}
}
