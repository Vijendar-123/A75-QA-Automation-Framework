import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest{

@Test
public void chnageProfileName() throws InterruptedException {
    //login
    provideEmail("vijendar@testpro.io");
    providePassword("cnb243YB");
    clickSubmitBtn();
    Thread.sleep(2000);
    //click on profile
    clickProfileIcon();
    //give current password
    provideCurrentPassword("cnb243YB");
    //give profileName
    var randomname =randomName();
    System.out.println(randomname);
    changeName(randomname);
    //click save button
    clickSave();
    Thread.sleep(3000);
    //Verify the change
    WebElement newName = driver.findElement(By.cssSelector("a.view-profile>span"));

    Assert.assertEquals(newName.getText(),randomname);
}


}
