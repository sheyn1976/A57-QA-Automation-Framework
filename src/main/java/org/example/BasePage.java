package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    WebDriver pageDriver= null;
    WebDriverWait wait;
   Actions actions;


public BasePage(WebDriver existDriver) {
    this.pageDriver = existDriver;   //create driver. Constructor
}
public WebElement findElement(By locator){
    return pageDriver.findElement(locator);  // create element. Locator

}
public WebElement waitAndFindWebElement(WebDriverWait wait, By locator){
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator )); //create and find elements. Page Method

}
}
