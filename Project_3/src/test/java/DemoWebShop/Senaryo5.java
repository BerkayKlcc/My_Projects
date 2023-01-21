package DemoWebShop;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Senaryo5 extends BaseDriver {
    @Test
    public void Test5() throws AWTException {
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


        WebElement laptop= driver.findElement(By.xpath("//img[@title='Show details for 14.1-inch Laptop']"));
        laptop.click();

        WebElement addToChart=driver.findElement(By.xpath("//input[@id='add-to-cart-button-31']"));
        addToChart.click();

        WebElement confirmmessage=driver.findElement(By.cssSelector("[class='content']"));

        Assert.assertTrue("Item did not added to your chart",confirmmessage.getText().contains("The product has been added to your "));

        WebElement shoppingChart= driver.findElement(By.cssSelector("a[class='ico-cart']>span"));
        shoppingChart.click();

        WebElement productVerify=driver.findElement(By.cssSelector("a[class='product-name']"));
        Assert.assertTrue("Your chart is empty",productVerify.getText().contains("14.1-inch Laptop"));

        WebElement aggreeButton= driver.findElement(By.cssSelector("input[id='termsofservice']"));
        aggreeButton.click();

        WebElement checkOutButton= driver.findElement(By.xpath("//button[@id='checkout']"));
        checkOutButton.click();

        Actions actions = new Actions(driver);
       WebElement firstName = driver.findElement(By.id("BillingNewAddress_FirstName"));

        actions.click(firstName)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).build().perform();

        MyFunc.wait(5);

        WebElement countrySelect=driver.findElement(By.cssSelector("select[id='BillingNewAddress_CountryId']"));
        Select slct=new Select(countrySelect);
        slct.selectByVisibleText("Turkey");
        actions.sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Ankara")
                .sendKeys(Keys.TAB)
                .sendKeys("Çankaya")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("06100")
                .sendKeys(Keys.TAB)
                .sendKeys("00905555555")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).build().perform();

        MyFunc.wait(3);
        WebElement continueButton= driver.findElement(By.cssSelector("input[onclick='Billing.save()']"));
        continueButton.click();

        MyFunc.wait(3);
        WebElement continueButton2=driver.findElement(By.cssSelector("input[onclick='Shipping.save()']"));
        continueButton2.click();

        MyFunc.wait(3);
        WebElement continueButton3=driver.findElement(By.cssSelector("input[onclick='ShippingMethod.save()']"));
        continueButton3.click();

        MyFunc.wait(3);
        WebElement continueButton4=driver.findElement(By.cssSelector("input[onclick='PaymentMethod.save()']"));
        continueButton4.click();

        MyFunc.wait(3);
        WebElement continueButton5=driver.findElement(By.cssSelector("input[onclick='PaymentInfo.save()']"));
        continueButton5.click();

        MyFunc.wait(3);
        WebElement continueButton6=driver.findElement(By.cssSelector("input[onclick='ConfirmOrder.save()']"));
        continueButton6.click();

        WebElement orderConfirmation=driver.findElement(By.cssSelector("div[class='title']>strong"));

        Assert.assertTrue("Order unsuccessful",orderConfirmation.getText().contains("Your order has been successfully processed!"));

        stopDriver();


    }
}
