package stepDefinitions.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    WebDriver pageDriver = null;

    @FindBy(xpath = "//div[contains(@class,'success')]")
    WebElement successMassageLocator;

    public BasePage(WebDriver existDriver) {
        this.pageDriver = existDriver;

        //add for finding all @FindBy:
        PageFactory.initElements(pageDriver, this);
    }

    public WebElement findElement(By locator) {
        return pageDriver.findElement(locator);// create element. Locator
    }


    public WebElement waitAndFindWebElement(By locator) {
        WebDriverWait wait = new WebDriverWait(pageDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); //create and find elements. Page Method
    }

    public void contextClickByElement(WebElement element) {
        Actions actions = new Actions(pageDriver);
        actions.contextClick(element).perform();
    }

    public WebElement getSuccessMassage() {
        return successMassageLocator;

    }

    public void waitUntilSuccessMessageIsDisappear() {
       // WaitUtils.waitUtilInvisibilityOfElementLocatedBy(pageDriver, getSuccessMassage());
    }
}


