import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22  extends BaseTest{

    @Test
    public void renamePlaylist(){

        String newPlayListName = "New playlist";
        String currentPlayListName = "Dark Days";

        LoginPage loginPage=null;
        HomePage homePage=null;

        LoginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlayListName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(),currentPlayListName);
    }
}
