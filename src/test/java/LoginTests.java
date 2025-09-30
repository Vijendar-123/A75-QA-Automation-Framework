import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);//creating an object called driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // TODO (for students): Review the configuration as part of HW15

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

public void loginValidEmailPassowrd() throws InterruptedException {

    provideEmail("vijendar@testpro.io");
    providePassword("cnb243YB");
    clickSubmitBtn();
    Thread.sleep(2000);
     //Expected Result
     WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
     Assert.assertTrue(avatarIcon.isDisplayed());//test pass only if the input is true
}


public void incorrectEmailCorrectPassowrd() throws InterruptedException {
    //opening URL
        provideEmail("incorrect@testpro.io");
        providePassword("cnb243YB");
        clickSubmitBtn();
        Thread.sleep(2000);

    //Expected Result
    Assert.assertEquals(driver.getCurrentUrl(),url);
}


    public void ValidEmailinCorrectPassowrd() throws InterruptedException {
        //opening URL
        provideEmail("vijendar@testpro.io");
        providePassword("saoighsd");
        clickSubmitBtn();
        Thread.sleep(2000);

        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

@Test(dataProvider = "IncorrectLoginData", dataProviderClass = DataProvid.class)
public void incorrectDataTest(String email , String password) throws InterruptedException{

        provideEmail(email);
        providePassword(password);
        clickSubmitBtn();
        Thread.sleep(2000);

        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }


}

