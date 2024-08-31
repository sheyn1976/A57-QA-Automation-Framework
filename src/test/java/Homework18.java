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
    public void clickPlay(){
        WebElement playNextButton = getDriver().findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        WebElement playButton = getDriver().findElement(By.cssSelector("span.play"));

        playNextButton.click();
        playButton.click();
    }

    public boolean isSongPlaying(){
        WebElement soundBar= getDriver().findElement(By.cssSelector("div.bars"));
        return soundBar.isDisplayed();

    }

}