package stepDefinitions.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends BasePage {
    @FindBy(css= "#userBadge img")
    WebElement avatar;
    @FindBy(css = "#playlists i[role='button']")
     WebElement addPlaylistButton;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement createPlaylistButton;
    @FindBy(css = "[name='create-simple-playlist-form']>input")
    WebElement playlistNameInput;

    String playListLocator = "//section[@id='playlists']//li/a[text()='%s']";

    @FindBy(xpath = "//li[contains(@data-testid, 'playlist-context-menu-edit')]")
    WebElement editButton;
    @FindBy(xpath = "//ul/li//input[@type='text']")
    WebElement renamePlaylistInput;
    @FindBy(css = "#playlists li" )
    List<WebElement> playLists;

    @FindBy(css= "a.view-profile")
    WebElement profileIcon;

    public HomePage(WebDriver existDriver) {
        super(existDriver);

    }
    public HomePage clickProfileIcon(){
        contextClickByElement(profileIcon);
        return this;

    }

    public WebElement getAvatar() {
        return avatar;
    }

    public WebElement getAddPlaylistButton() {
        return addPlaylistButton;

    }

    public WebElement getCreatePlaylistButton() {
        return createPlaylistButton;
    }

    public WebElement getPlaylistNameInput() {
        return playlistNameInput;

    }

    public void createPlaylist(Actions actions, String playlistName)throws InterruptedException {
        actions.moveToElement(getAddPlaylistButton()).perform();
        getAddPlaylistButton().click();
        Thread.sleep(3000);
        getCreatePlaylistButton().click();
        getPlaylistNameInput().sendKeys(playlistName);
        getPlaylistNameInput().sendKeys(Keys.ENTER);
    }

    public WebElement getPlaylistByName(String playlistName) {
        return findElement(By.xpath(String.format("//section[@id='playlists']//a[text()='%s']", playlistName)));

    }

    public void openPlayList(String playlistName) {
        getPlaylistByName(playlistName).click();
    }

    // create method that return to me playlist:

    public WebElement getPlayListByName(String playListName) {
        return waitAndFindWebElement(By.xpath(String.format(playListLocator, playListName)));
    }

    public void renamePlayList(String currentPlayListName, String newPlayListName) throws InterruptedException {
        contextClickByElement(getPlayListByName(currentPlayListName));
        Thread.sleep(3000);
        editButton.click();
        for (int i = 0; i < currentPlayListName.length(); i++) {
            renamePlaylistInput.sendKeys(Keys.BACK_SPACE);
        }
        renamePlaylistInput.sendKeys(newPlayListName);
        renamePlaylistInput.sendKeys(Keys.ENTER);
        getSuccessMassage();
    }
    public List<WebElement> getAllPlaylists() {
        return playLists;
    }
    public void createPlaylist( String playListName) throws InterruptedException{
        Thread.sleep(3000);
        getAddPlaylistButton().click();
        getCreatePlaylistButton().click();
        getPlaylistNameInput().sendKeys(playListName);
        getPlaylistNameInput().sendKeys(Keys.ENTER);
        waitUntilSuccessMessageIsDisappear();
    }
    }

/*
//HOMEWORK22:
public class HomePage extends BasePage {
    public HomePage(WebDriver existDriver) {
        super(existDriver);
    }
    By firstPlayList =By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField=By.cssSelector("[name='name']");
    By renamePlaylistSuccessMsg=By.cssSelector("div.success.show");

    public void doubleClickPlaylist(){
        doubleClick(firstPlayList);
    }
    public void enterNewPlaylistName(String playlistName){
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg(){
        return findElement(renamePlaylistSuccessMsg).getText();
    }
}

 */
