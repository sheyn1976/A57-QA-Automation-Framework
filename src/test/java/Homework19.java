import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeletedMassage="Delete playlist \"Dark Days\"";
        LoginPage loginPage=null;


/*
        LoginPage loginPage=null;
        HomePage homePage=null;
        loginPage = new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va");
        WebDriverWait wait;
        Actions actions;
        homePage.createPlaylist(actions,wait,playListName);
        homePage.openPlayList(wait,playListName) ;
*/
        loginPage=new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va");
        openPlaylist ();
        clickDeletePlaylistBtn();
        Assert.assertEquals( getDeletedPlaylistMsg(), expectedPlaylistDeletedMassage);
    }


public  void openPlaylist() {
    WebElement emptyPlaylist = driver.findElement(By.cssSelector("//*[@class='playlist playlist']//*[text()=']"));
    emptyPlaylist.click();
}

    public void clickDeletePlaylistBtn() throws InterruptedException {
WebElement deletePlaylist = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
deletePlaylist.click();
Thread.sleep(2000);
}

public String getDeletedPlaylistMsg() {
    WebElement notificationMsg = driver.findElement(By.cssSelector("//*[@class='dialog']//*[@class='msg']"));

return notificationMsg.getText();

}
}