package Akakce;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Akakce extends BaseDriver {
    public static void main(String[] args) {

        driver.get("https://www.akakce.com/");
        driver.manage().deleteAllCookies();

        /** Open Account **/

        WebElement openAccount=driver.findElement(By.linkText("Hesap Aç"));
        openAccount.click();

        WebElement name= driver.findElement(By.cssSelector("input[id='rnufn']"));
        name.sendKeys("GrupDort");

        WebElement lastName=driver.findElement(By.cssSelector("input[id='rnufs']"));
        lastName.sendKeys("ilkOdev");

        WebElement email=driver.findElement(By.id("rnufe1"));
        email.sendKeys("grup4@gmail.com");

        WebElement remail= driver.findElement(By.id("rnufe2"));
        remail.sendKeys("grup4@gmail.com");

        MyFunc.wait(3);
        WebElement password= driver.findElement(By.id("rnufp1"));
        password.sendKeys("Ilkgun.23");

        MyFunc.wait(3);
        WebElement repassword= driver.findElement(By.id("rnufp2"));
        repassword.sendKeys("Ilkgun.23");

        MyFunc.wait(3);
        WebElement gender= driver.findElement(By.id("rngf"));
        gender.click();

        WebElement city = driver.findElement(By.id("locpr"));
        Select selectCty= new Select(city);
        selectCty.selectByVisibleText("Ankara");

        WebElement county=driver.findElement(By.id("locds"));
        Select selectCnty=new Select(county);
        selectCnty.selectByVisibleText("Beypazarı");

        WebElement day= driver.findElement(By.id("bd"));
        Select selectDy=new Select(day);
        selectDy.selectByVisibleText("28");

        WebElement month= driver.findElement(By.id("bm"));
        Select newMnt=new Select(month);
        newMnt.selectByVisibleText("10");

        WebElement year= driver.findElement(By.id("by"));
        Select newYr=new Select(year);
        newYr.selectByVisibleText("2009");

        WebElement contract= driver.findElement(By.id("rnufpca"));
        contract.click();

        WebElement accountBttn= driver.findElement(By.id("rfb"));
        accountBttn.click();

        WebElement confirm= driver.findElement(By.linkText("GrupDort"));
        System.out.println(confirm.getText());


        /** Login to Account */


        WebElement login= driver.findElement(By.linkText("Giriş Yap"));
        login.click();

        WebElement email1= driver.findElement(By.id("life"));
        email1.sendKeys("grup4@gmail.com");

        WebElement password1= driver.findElement(By.id("lifp"));
        password1.sendKeys("Ilkgun.23");

        WebElement entryBttn= driver.findElement(By.id("lfb"));
        entryBttn.click();

        WebElement confirm1= driver.findElement(By.linkText("GrupDort"));
        System.out.println(confirm1.getText());

        WebElement profile= driver.findElement(By.linkText("Hesabım"));
        profile.click();

        WebElement myOrders= driver.findElement(By.linkText("Kolay Siparişlerim"));
        myOrders.click();

        WebElement orderConfrm= driver.findElement(By.cssSelector("div[class='no-record']"));
        orderConfrm.getText();

        Assert.assertTrue("Siparisiniz Vardir",orderConfrm.getText().contains("Kayıtlı siparişiniz bulunmuyor."));

        WebElement profileBttn= driver.findElement(By.id("H_a_v8"));
        profileBttn.click();

        WebElement myAccnt= driver.findElement(By.cssSelector("[id='H_a_v8'] +ul> :nth-child(1)+li+li+li+li > :nth-child(1)"));
        myAccnt.click();

        WebElement messages= driver.findElement(By.linkText("Mesajlarım"));
        messages.click();

        WebElement messageTx= driver.findElement(By.xpath("//*[@class='wbb_v8']//p"));
        messageTx.getText();

        Assert.assertTrue("Mesajiniz Vardir",messageTx.getText().contains("Listelenecek mesaj bulunamadı."));

        WebElement homePage= driver.findElement(By.id("H_l_v8"));
        homePage.click();

        WebElement profileBttn2= driver.findElement(By.id("H_a_v8"));
        profileBttn2.click();

        WebElement account2= driver.findElement(By.cssSelector("[id='H_a_v8'] +ul> :nth-child(1)+li+li+li+li > :nth-child(1)"));
        account2.click();

        WebElement deleteAccnt= driver.findElement(By.linkText("Hesabımı Sil"));
        deleteAccnt.click();

        WebElement deletePswd= driver.findElement(By.id("p"));
        deletePswd.sendKeys("Ilkgun.23");

        WebElement deleteBttn= driver.findElement(By.id("u"));
        deleteBttn.click();



        stopDriver();
    }
}
