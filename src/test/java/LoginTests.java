import io.netty.util.internal.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class LoginTests extends BaseTest {

    @Test(dataProviderClass = ParameterProvider.class, dataProvider ="incorrectCredentialVlues" , testName = " Login with empty email and password test ", groups = "Regresion")
    //@Parameters()
    public void loginIncorrectEmailPasswordTest(String email, String password) throws InterruptedException {
//empty string"" StringUtil.EMPTY_STRING
        loginKoel(email,  password);
        Thread.sleep(5000);
        Assert.assertTrue(getDriver().findElement(By.cssSelector("button[type='submit']")).isDisplayed());

    }

    @Test(testName = "Login with correct credentials test", groups = {"Smoke", "Regretion"})
    public void loginUserTest() {

        loginKoel("ilya.sheynblat+1@testpro.io", "$Ma1947va");
        WebElement logoutButton = getDriver().findElement(By.cssSelector("a[data-testid='btn-logout']>i"));
        System.out.println(new BaseTest().toString());
        Assert.assertTrue(logoutButton.isDisplayed());
    }

    @DataProvider(name = "IncorrectCredentialValues")
    public Object[][] provideIncorrectCredentials() {
        return new Object[][]{
                {"", ""},
                {"i@testpro.io", "$33wrong"},
              {"insert into table...", "insert into table..."},
             {UUID.randomUUID().toString(),UUID.randomUUID().toString()}
            //  {"ilya.sheynblat+1@testpro.io","$Ma1947va"}
        };
    }
}
/*
@DataProvider(name = "IncorrectCredentialValues")
public Object[][] ProvideIncorrectCredentials() {
    return new Object[][]{
            {"",""},
            {"ilya.sheynblat+1@testpro.io","$afddv33wrong"},
           // {"insert into table...","insert into table..."},
            {UUID.randomUUID().toString(),UUID.randomUUID().toString(),}
    };

}
}






/*
public class Homework16 extends BaseTest {

    @Test

    public void registrationNavigation() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[href=registration]"));
             registrationLink.click();

             String registrationUrl="https://qa.koel.app/registration";
             Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
             driver.quit();
             */

