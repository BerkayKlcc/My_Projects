package Shopdemo;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase_1 extends BaseDriver {
    @Test
    public void test1(){

        driver.get("https://shopdemo.e-junkie.com/");

            WebElement eBookAddCrd=driver.findElement(By.cssSelector("div[class='column is-one-third-desktop is-one-third-tablet card_box']~div button"));
            eBookAddCrd.click();

//        List<WebElement> iframe=driver.findElements(By.tagName("iframe"));
//        System.out.println("Number of IFrame= "+iframe.size());
//        int t=0;
//        for (WebElement i:iframe) {
//            System.out.println(t+" :"+i.getAttribute("class"));
//            t++;
//        }

        driver.switchTo().frame(3);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));

        MyFunc.wait(5);
        WebElement addPromCode= driver.findElement(By.cssSelector("button[class='Apply-Button Show-Promo-Code-Button']"));
    //    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='Apply-Button Show-Promo-Code-Button']")));
        addPromCode.click();

        WebElement writePromCd= driver.findElement(By.cssSelector("input[placeholder='Promo Code']"));
        wait.until(ExpectedConditions.visibilityOf(writePromCd));
        writePromCd.sendKeys("124586");

        WebElement applyBttn= driver.findElement(By.cssSelector("button[class='Promo-Apply']"));
        wait.until(ExpectedConditions.visibilityOf(applyBttn));
        applyBttn.click();

        WebElement snackBar= driver.findElement(By.cssSelector("div[id='SnackBar'] span"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='SnackBar'] span")));
        Assert.assertTrue("SnackBar message not displayed",snackBar.getText().contains("Invalid promo code"));




        stopDriver();

    }
}
