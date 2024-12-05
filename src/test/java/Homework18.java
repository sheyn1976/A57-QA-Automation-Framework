import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    LoginPage loginPage=null;
    @Test
            public void playSong() throws InterruptedException{
        loginPage=new LoginPage(driver);
        loginPage.login("ilya.sheynblat+1@testpro.io","$Ma1947va");
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }
    public void clickPlay() throws InterruptedException {
        WebElement playNextButton = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.cssSelector("span.play"));

        playNextButton.click();
        Thread.sleep(2000);
        playButton.click();
        Thread.sleep(2000);
    }

    public boolean isSongPlaying(){
        WebElement soundBar= driver.findElement(By.cssSelector("div.bars"));
        return soundBar.isDisplayed();

    }

}