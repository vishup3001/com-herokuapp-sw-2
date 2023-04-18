package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        // Open browser and launch base url
        openBrowser(baseurl);
    }

    @After
    public void terminateBrowser() {
        // Close all windows
        closeBrowser();
    }

    @Test
    public void UserSholdLoginSuccessfullyWithValidCredentials() {
        String expectedMessage = "Secure Area";
        //Element to send username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Element to send password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Element to click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//div[@class='example']//h2"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to Login", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        String expectedMessage = "Your username is invalid!\n";
        //Element to send username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        //Element to send password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Element to click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//*[@id='flash']"));
        String actualMessage = getMessage.getText();
        String[] actmes = actualMessage.split("×");
        String actmes1 = actmes[0];
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to pop up username invalid message", expectedMessage, actmes1);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        String expectedMessage = "Your password is invalid!\n";
        //Element to send username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Element to send password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecressword!");
        //Element to click on login button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//*[@id='flash']"));
        String actualMessage = getMessage.getText();
        String[] actmes = actualMessage.split("×");
        String actmes1 = actmes[0];
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to pop up password message", expectedMessage, actmes1);
    }


}
