import org.example.POM.HomePage;
import org.example.POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    LoginPage loginPage = null;
    HomePage homePage = null;


    @Test(testName = "Login with correct credentials test", groups = {"Smoke", "Regression"})
    public void loginTest() {
        loginPage = new LoginPage(getDriver());
          loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
         HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
    }



    @Test(dataProviderClass = ParameterProvider.class, dataProvider = "incorrectCredentialValues", groups = "Regression")
    public void loginIncorrectEmailPasswordTest(String email, String password){
            loginPage = new LoginPage(getDriver());
            loginPage.login(email, password);
         // HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(loginPage.getLogo().isDisplayed());
    }
    }




