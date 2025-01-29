import stepDefinitions.POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    LoginPage loginPage=null;
    @Test
            public void playSong() throws InterruptedException{
        loginPage=new LoginPage(getDriver());
        loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va");
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }
    public void clickPlay() throws InterruptedException {
        WebElement playNextButton = getDriver().findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        WebElement playButton = getDriver().findElement(By.cssSelector("span.play"));

        playNextButton.click();
        Thread.sleep(2000);
        playButton.click();
        Thread.sleep(2000);
    }

    public boolean isSongPlaying(){
        WebElement soundBar=getDriver().findElement(By.cssSelector("div.bars"));
        return soundBar.isDisplayed();

    }

}