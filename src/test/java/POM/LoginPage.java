package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "input[type='email']")
    WebElement emailInput;

    @FindBy(css = "input[type='password']")
    WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    @FindBy(css = ".logo" )
    WebElement logo;


    public LoginPage(WebDriver existDriver) {
        super(existDriver);
    }

    public void login(String email, String password) {
        provideEmail(email).providePassword(password).clickSubmit();

    }
    public LoginPage provideEmail(String email){
        emailInput.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }
public LoginPage clickSubmit(){
    loginButton.click();
return this;

}

    public WebElement getLogo() {
        return logo;
    }
    }

