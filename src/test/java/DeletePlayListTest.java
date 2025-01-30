
import POM.HomePage;
import POM.LoginPage;
import POM.PlaylistPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;




import static POM.WaitUtils.waitUtilVisibilityOfElementLocatedBy;


public class DeletePlayListTest extends BaseTest{
    LoginPage loginPage=null;
    HomePage homePage=null;
Actions actions=null;
    @Test
    public void deletePlayLIstTest()  {
        String playListName="TestPlayListForDeleting";
        loginPage=new LoginPage(getDriver());
        loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va" );
        homePage=new HomePage(getDriver());

       // homePage.createPlaylist( actions,playListName);
        homePage.openPlayList(playListName);
        PlaylistPage playlistPage=new PlaylistPage(getDriver());
        playlistPage.deletePlaylist();
        waitUtilVisibilityOfElementLocatedBy(getDriver(), By.xpath("//section[@id='playlists']//li/a[text()='TestPlayListForDeleting']"));
        Assert.assertTrue(homePage.getPlaylistByName(playListName).isDisplayed());


    }
    @Test
    public void addPlayListTest(){
        String playListName="TestPlayListForDeleting";
        loginPage=new LoginPage(getDriver());
        loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va" );
        homePage= new HomePage(getDriver());
        int previousSize=homePage.getAllPlaylists().size();
        //homePage.createPlayList(actions, playListName);
        int actualSize=homePage.getAllPlaylists().size();
        Assert.assertNotEquals(actualSize,previousSize);  // previousSize !=actualSize


    }
}

