import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeletedMassage="Delete playlist \"Dark Days\"";

        enterEmail("ilya.sheynblat+1@testpro.io");
        enterPassword("$Ma1947va");
        clickLoginButton();
        openPlaylist ();
        clickDeletePlaylistBtn();
        Assert.assertEquals( getDeletedPlaylistMsg(), expectedPlaylistDeletedMassage);
    }


public  void openPlaylist() {
    WebElement emptyPlaylist = getDriver().findElement(By.cssSelector("//*[@class='playlist playlist']//*[text()=']"));
    emptyPlaylist.click();
}

    public void clickDeletePlaylistBtn() throws InterruptedException {
WebElement deletePlaylist = getDriver().findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
deletePlaylist.click();
Thread.sleep(2000);
}

public String getDeletedPlaylistMsg() {
    WebElement notificationMsg = getDriver().findElement(By.cssSelector("//*[@class='dialog']//*[@class='msg']"));

return notificationMsg.getText();

}
}