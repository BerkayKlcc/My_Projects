package Shopdemo;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase_2 extends BaseDriver {
    @Test
    public void test2(){

        driver.get("https://shopdemo.e-junkie.com/");


        WebElement eBookAddCrd=driver.findElement(By.cssSelector("div[class='column is-one-third-desktop is-one-third-tablet card_box']~div button"));
        eBookAddCrd.click();

        driver.switchTo().frame(5);

        MyFunc.wait(2);
        WebElement debitCard= driver.findElement(By.cssSelector("div[class='Payment-Options'] button+button+button"));
        debitCard.click();

        MyFunc.wait(2);
        WebElement payBttn= driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        payBttn.click();

        MyFunc.wait(2);
        WebElement invalidMessage= driver.findElement(By.cssSelector("ion-icon[class='Close-SnackBar md hydrated']~span"));
        Assert.assertTrue("Invalid Email not arrived",invalidMessage.getText().contains("Invalid Email"));

        stopDriver();

    }
}
