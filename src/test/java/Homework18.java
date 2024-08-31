import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
            public void playSong(){
    enterEmail("ilya.sheynblat+1@testpro.io");
    enterPassword("$Ma1947va");
    clickLoginButton();
    clickPlay();
        Assert.assertTrue(isSongPlaying());
    }
    public void clickLoginButton(){
        WebElement playNextButton = driver.findElement(By.cssSelector());
    }

}