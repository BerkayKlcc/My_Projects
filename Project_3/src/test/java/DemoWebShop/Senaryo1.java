package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Senaryo1 extends BaseDriver {
    @Test
    public void Test1() throws AWTException {

        driver.get("https://demowebshop.tricentis.com/");


        WebElement registerButton=driver.findElement(By.cssSelector(".ico-register"));
        registerButton.click();

        WebElement genderMale=driver.findElement(By.id("gender-male"));
        genderMale.click();

        WebElement name= driver.findElement(By.cssSelector("input[id='FirstName']"));
        name.sendKeys("grupdort");

        WebElement lastName=driver.findElement(By.cssSelector("input[id='LastName']"));
        lastName.sendKeys("dorduncugrup");

        WebElement email= driver.findElement(By.cssSelector("[id=Email]"));
        email.sendKeys("candeneme83@gmail.com");

        WebElement password= driver.findElement(By.cssSelector("[id=Password]"));
        password.sendKeys("12345G");

        WebElement confirmPassword= driver.findElement(By.cssSelector("[id=ConfirmPassword]"));
        confirmPassword.sendKeys("12345G");

        Robot rbt=new Robot();
        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        WebElement registerMessage= driver.findElement(By.cssSelector("div[class='result']"));
        Assert.assertTrue("Registration unsuccessfull",registerMessage.getText().contains("Your registration completed"));


        stopDriver();
    }
}
