package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//div[contains(@data-testid, 'theme-card')]")
    List<WebElement> themes;

    @FindBy(css = "[data-testid='theme-card-violet']")
    WebElement violetTheme;
    @FindBy(css = "[data-testid='theme-card-violet'][class ='theme selected']")
    WebElement selectedVioletTheme;

    public boolean isVioletThemeSelected(){
        contextClickByElement(selectedVioletTheme);
        return isVioletThemeSelected();
    }
    public ProfilePage chooseVioletTheme(){
        contextClickByElement(violetTheme);
        return this;
    }

    public ProfilePage(WebDriver existDriver){
        super(existDriver);

}
public List<WebElement> getAllThemes(){
    return themes;
}

public void choseThemeByName(String themeName){
        for(WebElement element : getAllThemes()){
            if (element.getText().equals(themeName)) {
                element.click();
            }
        }
}
public boolean isThemeSelected(String themeName){
        for (WebElement element: getAllThemes()) {
            if (element.getAttribute("class").contains("selected")){
                return true;
            }
        }
      return false;
}
}
