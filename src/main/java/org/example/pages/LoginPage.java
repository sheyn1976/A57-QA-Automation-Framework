package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Homework22:

public class LoginPage extends BasePage {

    public LoginPage(WebDriver existDriver) {
        super(existDriver);
        By emailField = By.cssSelector("input[type='email']");

        By passwordField = By.cssSelector("input[type='password']");

        By loginButton = By.cssSelector("button[type='submit']");
    }

    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        click(submitBtn);
    }

    public void login() {
        provideEmail("ilya.sheynblat+1@testpro.io");
        providePassword("$Ma1947va");
        clickSubmit();

    }
}


/*


public class LoginPage extends BasePage {
    public LoginPage(WebDriver existDriver) {
        super(existDriver);
    }
    By emailInput = By.cssSelector("input[type='email']");

    By passwordInput = By.cssSelector("input[type='password']");

    By loginButton = By.cssSelector("button[type='submit']");

    By logo = By.cssSelector(".logo");

    public void login(String email, String password) {
        findElement(emailInput).sendKeys(email);
        findElement(passwordInput).sendKeys(password);
        findElement(loginButton).click();

    }

    public WebElement getLogo() {
        return findElement(logo);
    }
    }

