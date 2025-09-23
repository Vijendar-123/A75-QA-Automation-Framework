import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver;
    public String url;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setupBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //precondition
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigatetoURL();

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



    public void providePassword(String password) {
        WebElement passowrdField = driver.findElement(By.cssSelector("input[type='password']"));
        passowrdField.clear();
        passowrdField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigatetoURL() {
        url= "https://qa.koel.app/";
        driver.get(url);
    }

    public void clickSubmitBtn() {
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();

    }

    public void clickProfileIcon(){
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String password){
        WebElement currentpassword= driver.findElement(By.cssSelector("input[name='current_password']"));
        currentpassword.clear();
        currentpassword.sendKeys(password);
    }
    public String randomName(){
        return UUID.randomUUID().toString().replace("-","");
    }
    public void changeName(String randomname){
        WebElement currentName = driver.findElement(By.cssSelector("[name='name']"));
        currentName.clear();
        currentName.sendKeys(randomname);
    }
    public void clickSave(){
        WebElement clickSave = driver.findElement(By.cssSelector("button.btn-submit"));
        clickSave.click();
    }

}