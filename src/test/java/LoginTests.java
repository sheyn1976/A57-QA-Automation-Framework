import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage = null;

    @Test(description = "Login with correct credentials test", priority = 1, groups = "Smoke")
    public void loginTest() {
        loginPage = new LoginPage(getDriver());
          loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
         HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
    }



    @Test(groups = "Regression", dataProvider = "incorrectCredentials", dataProviderClass = DataProviderCredentials.class)
    public void loginIncorrectEmailPasswordTest(String email, String password){
            loginPage = new LoginPage(getDriver());
            loginPage.login(email, password);
         // HomePage homePage = new HomePage(getDriver());
        Assert.assertFalse(loginPage.getLogo().isDisplayed());
    }
    }




