package Shopdemo;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase_5 extends BaseDriver {

    @Test
    public void test5() {

        driver.get("https://shopdemo.e-junkie.com/");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement contactUs= driver.findElement(By.cssSelector("[class='ion-md-mail']"));
        wait.until(ExpectedConditions.elementToBeClickable(contactUs));
        contactUs.click();

        WebElement name= driver.findElement(By.cssSelector("[id='sender_name']"));
        wait.until(ExpectedConditions.visibilityOf(name));
        name.sendKeys("Berkay");

        WebElement email= driver.findElement(By.cssSelector("[id='sender_email']"));
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("sdetberkay@gmail.com");

        WebElement subject= driver.findElement(By.cssSelector("[id='sender_subject']"));
        wait.until(ExpectedConditions.visibilityOf(subject));
        subject.sendKeys("Automation Test");

        WebElement message= driver.findElement(By.cssSelector("[id='sender_message']"));
        wait.until(ExpectedConditions.visibilityOf(message));
        message.sendKeys("Bravo! You have successfully completed the test ");

        WebElement sendBttn= driver.findElement(By.cssSelector("[id='send_message_button']"));
        wait.until(ExpectedConditions.visibilityOf(sendBttn));
        sendBttn.click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        stopDriver();
    }
}
