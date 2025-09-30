import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {
        provideEmail("vijendar@testpro.io");
        providePassword("cnb243YB");
        clickSubmitBtn();
        Thread.sleep(2000);
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }

    public void clickPlay() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playNextButton.click();
        playButton.click();
    }

    public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return  soundBar.isDisplayed();
    }
}
