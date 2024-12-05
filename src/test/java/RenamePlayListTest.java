import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class RenamePlayListTest extends BaseTest {
    LoginPage loginPage=null;

    String newPlayListName = "New playlist";
    String currentPlayListName = "Dark Days";

    @Test
    public void deletePlayListTest() throws InterruptedException {
        loginPage=new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//section[@id='playlists']//li/a[text()='%s']", newPlayListName))));
        Thread.sleep(3000);
        actions.contextClick(playList).perform();
        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-testid, 'playlist-context-menu-edit')]")));
        editButton.click();
        WebElement renamePlaylistInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li//input[@type='text']")));
        for (int i = 0; i < currentPlayListName.length(); i++) {
            renamePlaylistInput.sendKeys(Keys.BACK_SPACE);
        }
        renamePlaylistInput.sendKeys(newPlayListName);
        renamePlaylistInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'success')]")));

        Assert.assertEquals(newPlayListName, playList.getText());

        playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li/a[text()='%s'")));
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
    }
}