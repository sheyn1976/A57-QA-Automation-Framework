import POM.HomePage;
import POM.LoginPage;
import POM.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThemeTest extends BaseTest {

    @Test
    public void changeThemeTest(){
        String themeName="Classic";
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        HomePage homePage = new HomePage(getDriver());
        homePage.getAvatar().click();
        ProfilePage profilePage=new ProfilePage(getDriver());
        profilePage.choseThemeByName(themeName);
        Assert.assertTrue(profilePage.isThemeSelected(themeName));
    }

    @Test
    public  void changeCurrentTheme(){
        LoginPage loginPage= new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage=new ProfilePage(getDriver());


        loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va");
        //loginPage.clickSubmit();

        homePage.clickProfileIcon();

        profilePage.chooseVioletTheme();

        Assert.assertTrue(profilePage.isVioletThemeSelected());


    }
}
