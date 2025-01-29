import stepDefinitions.POM.HomePage;
import stepDefinitions.POM.LoginPage;
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
        loginPage = new LoginPage(getDriver());
        loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        homePage = new HomePage(getDriver());
        homePage.renamePlayList(currentPlayListName, newPlayListName);

        Assert.assertEquals(newPlayListName, homePage.getPlayListByName(newPlayListName).getText());
    }
    @AfterMethod
    public void rollBackChanges() throws InterruptedException{
        homePage=new HomePage(getDriver());
        homePage.renamePlayList(newPlayListName, currentPlayListName);
    }

}