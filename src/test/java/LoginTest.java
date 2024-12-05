import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;
import static org.bouncycastle.cms.RecipientId.password;



public class LoginTest extends BaseTest {

    LoginPage loginPage = null;
    HomePage homePage = null;


    @Test(testName = "Login with correct credentials test", groups = {"Smoke", "Regression"})
    public void loginTest() {
        loginPage = new LoginPage(driver);
          loginPage.login("ilya.sheynblat+1@testpro.io", "$Ma1947va");
         homePage = new HomePage(driver);
        Assert.assertFalse(homePage.getAvatar().isDisplayed());
    }



    @Test(dataProviderClass = ParameterProvider.class, dataProvider = "incorrectCredentialValues", groups = "Regression")
        public void loginIncorrectEmailPasswordTest(String email, String password){
            loginPage = new LoginPage(driver);
            loginPage.login(email, password);
            homePage = new HomePage(driver);
//loginPage.waitUntilInvisibleOfElement(homePage.getHomeMenu(), 5) ;
// WebElement logo = driver.findElement(By.cssSelector(".logo"));
        Assert.assertTrue(loginPage.getLogo().isDisplayed());
    }
    }




