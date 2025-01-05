import org.example.POM.HomePage;
import org.example.POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static java.lang.String.format;


public class RenamePlayListTest extends BaseTest {
    LoginPage loginPage=null;
    HomePage homePage=null;
    String newPlayListName = "New playlist";
    String currentPlayListName = "Dark Days";


    @Test
    public void renamePlayListTest() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        homePage = new HomePage(driver);
        homePage.renamePlayList(currentPlayListName, newPlayListName);

        Assert.assertEquals(newPlayListName, homePage.getPlayListByName(newPlayListName).getText());
    }
    @AfterMethod
    public void rollBackChanges() throws InterruptedException{
        homePage=new HomePage(driver);
        homePage.renamePlayList(newPlayListName, currentPlayListName);
    }

}