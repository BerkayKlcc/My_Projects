package Shopdemo;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase_4 extends BaseDriver {
    @Test
    public void test4() {

        driver.get("https://shopdemo.e-junkie.com/");


        WebElement eBookAddCrd = driver.findElement(By.cssSelector("div[class='column is-one-third-desktop is-one-third-tablet card_box']~div button"));
        eBookAddCrd.click();

        driver.switchTo().frame(5);

        MyFunc.wait(3);
        WebElement debitCard= driver.findElement(By.cssSelector("div[class='Payment-Options'] button+button+button"));
        debitCard.click();

        MyFunc.wait(2);
        WebElement email= driver.findElement(By.cssSelector("[placeholder='Email']"));
        email.sendKeys("sdet_berkay@gmail.com");

        MyFunc.wait(2);
        WebElement confremail= driver.findElement(By.cssSelector("[placeholder='Confirm Email']"));
        confremail.sendKeys("sdet_berkay@gmail.com");

        MyFunc.wait(2);
        WebElement nameOnCard= driver.findElement(By.cssSelector("input[placeholder='Name On Card']"));
        nameOnCard.sendKeys("Cevdet");

        MyFunc.wait(2);
        WebElement phone= driver.findElement(By.cssSelector("input[placeholder='Optional'][autocomplete='phone']"));
        phone.sendKeys("1547852693");

        MyFunc.wait(2);
        WebElement company= driver.findElement(By.cssSelector("input[placeholder='Optional'][autocomplete='company']"));
        company.sendKeys("Campus");

        MyFunc.wait(3);
        WebElement iframe= driver.findElement(By.cssSelector("div[class='__PrivateStripeElement'] iframe"));
        driver.switchTo().frame(iframe);

        MyFunc.wait(2);
        WebElement cardNumber= driver.findElement(By.cssSelector("input[placeholder='Card number']"));
        cardNumber.sendKeys("4242 4242 4242 4242");

        MyFunc.wait(2);
        WebElement mm_yy=driver.findElement(By.cssSelector("input[class='InputElement is-empty Input Input--empty'][placeholder='MM / YY']"));
        mm_yy.sendKeys("12/22");

        MyFunc.wait(2);
        WebElement cvc= driver.findElement(By.cssSelector("input[placeholder='CVC']"));
        cvc.sendKeys("000");

        driver.switchTo().parentFrame();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement payBttn= driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='Pay-Button']")));
        payBttn.click();

//        wait.until(ExpectedConditions.textToBe(By.cssSelector("span[class='green_text_margin']"),"Thank you!"));
//        WebElement orderConfirm= driver.findElement(By.cssSelector("span[class='green_text_margin']"));
//        Assert.assertTrue("Your order isn't confirmed",orderConfirm.getText().contains("Thank you!"));





        stopDriver();
    }
}
