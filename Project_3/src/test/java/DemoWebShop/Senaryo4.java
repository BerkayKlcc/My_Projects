package DemoWebShop;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Senaryo4 extends BaseDriver {
    @Test
    public void Test4() throws AWTException {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement logIn= driver.findElement(By.cssSelector("a[class='ico-login']"));
        logIn.click();

        WebElement logInEmail= driver.findElement(By.cssSelector("input[id='Email']"));
        logInEmail.sendKeys("cande@gmail.com");

        Robot rbt=new Robot();
        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);

        WebElement password= driver.findElement(By.cssSelector("input[id='Password']"));
        password.sendKeys("125");

        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        WebElement mailVerify= driver.findElement(By.cssSelector("div[class='validation-summary-errors']"));
        Assert.assertTrue("login Succefull",mailVerify.getText().contains("Login was unsuccessful."));

        stopDriver();

    }
}
