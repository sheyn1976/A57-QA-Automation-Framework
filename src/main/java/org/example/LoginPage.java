package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    By emailInput = By.cssSelector("input[type='email']");

    By passwordInput = By.cssSelector("input[type='password']");

    By loginButton = By.cssSelector("button[type='submit']");

    By logo = By.cssSelector(".logo");

    public LoginPage(WebDriver existDriver) {
        super(existDriver);
    }

    public void login(String email, String password) {
        findElement(emailInput).sendKeys(email);
        findElement(passwordInput).sendKeys(password);
        findElement(loginButton).click();

    }

    public WebElement getLogo() {
        return findElement(logo);
    }
    }

