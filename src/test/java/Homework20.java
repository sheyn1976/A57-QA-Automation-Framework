import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    LoginPage loginPage=null;
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeletedMassage="Delete playlist \"Dark Days\"";
     //   loginPage=new LoginPage(getDriver());
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va");

        openPlaylist ();
        clickDeletePlaylistBtn();
        Assert.assertEquals( getDeletedPlaylistMsg(), expectedPlaylistDeletedMassage);
    }


    public  void openPlaylist() {
        WebElement emptyPlaylist = getDriver().findElement(By.xpath("//*[@class='playlist playlist']//*[text()=']"));
        emptyPlaylist.click();
    }

    public void clickDeletePlaylistBtn() throws InterruptedException {
    //WebElement  deletePlaylist= explicitWait.until (ExpectedCondition.cssSelector("button[class='del btn-delete-playlist']")));
      //  WebElement deletePlaylist = getDriver().findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
      //  deletePlaylist.click();
       // Thread.sleep(2000);
    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationMsg =getDriver().findElement(By.xpath("//*[@class='dialog']//*[@class='msg']"));

        return notificationMsg.getText();

    }
}