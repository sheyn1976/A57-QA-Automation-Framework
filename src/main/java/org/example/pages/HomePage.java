package org.example.pages;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

/*
public class HomePage extends BasePage {
    By avatar = By.cssSelector("#userBadge img");

    By addPlaylistButton = By.cssSelector("#playlists i[role='button']");

    By createPlaylistButton = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");

    By playlistNameInput = By.cssSelector("[name='create-simple-playlist-form']>input");

    String playListLocator = "//section[@id='playlists']//li/a[text()='%s']";

    By editButtonLocator = By.xpath("//li[contains(@data-testid, 'playlist-context-menu-edit')]");

    By renamePlaylistInputLocator = By.xpath("//ul/li//input[@type='text']");


    public HomePage(WebDriver existDriver) {
        super(existDriver);

    }

    public WebElement getAvatar() {
        return findElement(avatar);
    }

    public WebElement getAddPlaylistButton(WebDriverWait wait) {
        return waitAndFindWebElement(addPlaylistButton);

    }

    public WebElement getCreatePlaylistButton(WebDriverWait wait) {
        return waitAndFindWebElement(createPlaylistButton);
    }

    public WebElement getPlaylistNameInput(WebDriverWait wait) {
        return waitAndFindWebElement(playlistNameInput);

    }

    public void createPlaylist(Actions actions, WebDriverWait wait, String playlistName) {
        actions.moveToElement(getAddPlaylistButton(wait)).perform();
        getAddPlaylistButton(wait).click();
        getCreatePlaylistButton(wait).click();
        getPlaylistNameInput(wait).sendKeys(playlistName);
        getPlaylistNameInput(wait).sendKeys(Keys.ENTER);
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
WebElement editButton=waitAndFindWebElement(editButtonLocator);
        editButton.click();
        WebElement renamePlaylistInput=waitAndFindWebElement(renamePlaylistInputLocator);


        for (int i = 0; i < currentPlayListName.length(); i++) {
            renamePlaylistInput.sendKeys(Keys.BACK_SPACE);
        }
        renamePlaylistInput.sendKeys(newPlayListName);
        renamePlaylistInput.sendKeys(Keys.ENTER);
        getSuccessMassage();
    }
}
