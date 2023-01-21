package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Senaryo3 extends BaseDriver {
    @Test
    public void Test3() throws AWTException {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement logIn= driver.findElement(By.cssSelector("a[class='ico-login']"));
        logIn.click();


        WebElement logInEmail= driver.findElement(By.cssSelector("input[id='Email']"));
        logInEmail.sendKeys("candeneme83@gmail.com");

        Robot rbt=new Robot();
        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);

        WebElement password= driver.findElement(By.cssSelector("input[id='Password']"));
        password.sendKeys("12345G");

        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        WebElement mailVerify= driver.findElement(By.cssSelector("h2[class='topic-html-content-header']"));
        Assert.assertTrue("Unsuccessful LogIn",mailVerify.getText().contains("Welcome to our store"));

        stopDriver();

    }
}
