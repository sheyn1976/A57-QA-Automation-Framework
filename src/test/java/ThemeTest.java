import org.example.POM.HomePage;
import org.example.POM.LoginPage;
import org.example.POM.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThemeTest extends BaseTest {

    @Test
    public void changeThemeTest(){
        String themeName="Classic";
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        HomePage homePage = new HomePage(driver);
        homePage.getAvatar().click();
        ProfilePage profilePage=new ProfilePage(driver);
        profilePage.choseThemeByName(themeName);
        Assert.assertTrue(profilePage.isThemeSelected(themeName));
    }
}
