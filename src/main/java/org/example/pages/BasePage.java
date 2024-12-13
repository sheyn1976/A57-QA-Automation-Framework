package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//homework22
public class BasePage {
WebDriver driver;
WebDriverWait wait;
Actions actions;

public BasePage(WebDriver existDriver){
    driver = existDriver;
    wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    actions =new Actions(driver);
}
public WebElement findElement(By locator){
   return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
   
}
public void click(By locator){
    findElement(locator).click();
    }

public void doubleClick(By locator){
    actions.doubleClick(findElement(locator)).perform();
}
}

/*
public abstract class BasePage {
    WebDriver pageDriver= null;
     By seccessMassageLocator= By.xpath("//div[contains(@class,'success')]");

    public BasePage(WebDriver existDriver) {
    this.pageDriver = existDriver;   //create driver. Constructor
}
public WebElement findElement(By locator){
    return pageDriver.findElement(locator);  // create element. Locator

}
public WebElement waitAndFindWebElement( By locator){
    WebDriverWait wait = new WebDriverWait(pageDriver, Duration.ofSeconds(10));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator )); //create and find elements. Page Method

}
public void contextClickByElement(WebElement element){
        Actions actions= new Actions(pageDriver);
        actions.contextClick(element).perform();
}
public WebElement getSuccessMassage(){
        return waitAndFindWebElement(seccessMassageLocator);

    }

}
