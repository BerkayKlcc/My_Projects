package Shopdemo;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase_3 extends BaseDriver {
    @Test
    public void test3() throws InterruptedException {

        driver.get("https://shopdemo.e-junkie.com/");


        WebElement eBookAddCrd = driver.findElement(By.cssSelector("div[class='column is-one-third-desktop is-one-third-tablet card_box']~div button"));
        eBookAddCrd.click();

//        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
//        driver.switchTo().frame(frame);// frame 5

        driver.switchTo().frame(5);

        MyFunc.wait(2);
        WebElement debitCard= driver.findElement(By.cssSelector("div[class='Payment-Options'] button+button+button"));
        debitCard.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement iframe= driver.findElement(By.cssSelector("div[class='__PrivateStripeElement']>iframe"));
        wait.until(ExpectedConditions.invisibilityOf(debitCard));
        driver.switchTo().frame(iframe);

        MyFunc.wait(2);
        WebElement cardNumberEnter= driver.findElement(By.cssSelector("input[placeholder='Card number']"));
        cardNumberEnter.sendKeys("1111 1111 1111 1111");

//        MyFunc.Bekle(15);
//        WebElement snackBar= driver.findElement(By.cssSelector("div[id='Overlay']+div span"));
//        Assert.assertTrue("Your card number is valid",snackBar.getText().contains("Your card number is invalid."));

        stopDriver();

    }
}
