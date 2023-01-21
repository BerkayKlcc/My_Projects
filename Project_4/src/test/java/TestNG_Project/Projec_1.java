package TestNG_Project;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Projec_1 extends BaseDriver {

    @Test(enabled = false,priority = 1)
    public void setRegister() {

        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Grup4");

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Grup4");

        WebElement birth = driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"));
        Select day = new Select(birth);
        day.selectByVisibleText("1");

        WebElement month = driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"));
        Select month1 = new Select(month);
        month1.selectByValue("6");

        WebElement year = driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"));
        Select year1 = new Select(year);
        year1.selectByVisibleText("2000");

        WebElement email = driver.findElement(By.cssSelector("input[type='email'][id='Email']"));
        email.sendKeys("grup1@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("input[type='password'][id='Password']"));
        password.sendKeys("Grup456");

        WebElement repassword = driver.findElement(By.cssSelector("input[type='password'][id='ConfirmPassword']"));
        repassword.sendKeys("Grup456");

        WebElement register1 = driver.findElement(By.id("register-button"));
        register1.click();

        WebElement logout= driver.findElement(By.linkText("Log out"));
        logout.click();


    }

    @Test(dataProvider = "getData",priority = 2)
    public void loginTest(String email, String passwrd) {

        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();

        WebElement email1 = driver.findElement(By.cssSelector("[id='Email']"));
        email1.sendKeys(email);

        WebElement password = driver.findElement(By.cssSelector("[id='Password']"));
        password.sendKeys(passwrd);

        WebElement loginBttn = driver.findElement(By.cssSelector("button[class='button-1 login-button']"));
        loginBttn.click();

        if (email.equalsIgnoreCase("grup3@gmail.com")) {
            WebElement unsecces = driver.findElement(By.cssSelector("div[class='message-error validation-summary-errors']"));
            Assert.assertTrue(unsecces.getText().contains("Login was unsuccessful."), "Login successfull");

        } else {
            WebElement proof = driver.findElement(By.cssSelector("div[class='topic-block-title']>h2"));
            Assert.assertTrue(proof.getText().contains("Welcome to our store"), "Login unsuccessfull");
        }
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] logins = {

                {"grup3@gmail.com", "Grup123"}, // gecersiz
                {"grup1@gmail.com", "Grup456"}, // gecerli
        };
        return logins;
    }

    @Test (priority = 3)
    void tabMenuValidation() {

        List<WebElement> menuActualList = driver.findElements(By.cssSelector("ul[class='top-menu notmobile']>li"));

        List<String> menuExpectedList = new ArrayList<>();
        menuExpectedList.add("Computers");
        menuExpectedList.add("Electronics");
        menuExpectedList.add("Apparel");
        menuExpectedList.add("Digital downloads");
        menuExpectedList.add("Books");
        menuExpectedList.add("Jewelry");
        menuExpectedList.add("Gift Cards");

        for (int i = 0; i < menuExpectedList.size(); i++)
            Assert.assertEquals(menuActualList.get(i).getText(), menuExpectedList.get(i), "Menu farklı");

    }

    @Test (priority = 4)
    void orderGiftsTest() throws InterruptedException {

        Thread.sleep(1000);
        WebElement giftCards = driver.findElement(By.linkText("Gift Cards"));
        giftCards.click();

        WebElement randomCard = driver.findElement(By.linkText("$25 Virtual Gift Card"));
        randomCard.click();

        WebElement recipientsName = driver.findElement(By.xpath("//input[@id='giftcard_43_RecipientName']"));
        recipientsName.clear();
        recipientsName.sendKeys("Grup 5");

        WebElement recipientsEmail = driver.findElement(By.xpath("//input[@id='giftcard_43_RecipientEmail']"));
        recipientsEmail.clear();
        recipientsEmail.sendKeys("grup5555555@gmail.com");

        WebElement yourName = driver.findElement(By.xpath("//input[@id='giftcard_43_SenderName']"));
        yourName.clear();
        yourName.sendKeys("Grup4 Grup4");

        WebElement yourEmail = driver.findElement(By.xpath("//input[@id='giftcard_43_SenderEmail']"));
        yourEmail.clear();
        yourEmail.sendKeys("grup4@gmail.com");

        WebElement message = driver.findElement(By.xpath("//textarea[@id='giftcard_43_Message']"));
        message.clear();
        message.sendKeys("Enjoy your gift!");

        WebElement addToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-button-43']"));
        addToCart.click();

        WebElement shoppingCart = driver.findElement(By.cssSelector("p[class='content']>a"));
        shoppingCart.click();

        wait.until(ExpectedConditions.urlContains("cart"));

        WebElement myList = driver.findElement(By.cssSelector("a[class='product-name']"));
        wait.until(ExpectedConditions.visibilityOf(myList));
        Assert.assertTrue(myList.getText().contains("Virtual Gift Card"));

    }
    @Test (priority = 5)
    void OrderComputerTest() throws InterruptedException {

        Thread.sleep(3000);
        Actions action=new Actions(driver);

        WebElement computer= driver.findElement(By.linkText("Computers"));
        action.moveToElement(computer).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops")));
        WebElement desktop= driver.findElement(By.linkText("Desktops"));
        desktop.click();

//        action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(2000);
        WebElement item= driver.findElement(By.linkText("Build your own computer"));
        item.click();

        WebElement ram= driver.findElement(By.cssSelector("select[id='product_attribute_2']"));
        Select itemRam=new Select(ram);
        itemRam.selectByValue("5");

        WebElement hdd= driver.findElement(By.cssSelector("input[id='product_attribute_3_7']"));
        hdd.click();

        WebElement addTocrt= driver.findElement(By.cssSelector("button[id='add-to-cart-button-1']"));
        addTocrt.click();

        WebElement confirm= driver.findElement(By.cssSelector("p[class='content']"));
        Assert.assertTrue(confirm.getText().contains("added to your"));

    }

    @Test (priority = 6)
    @Parameters("world")
    void ParametreliSearchTest(String gelenMsj) throws InterruptedException {
        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='small-searchterms']"));
        searchBox.sendKeys(gelenMsj);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class='button-1 search-box-button']"));
        searchButton.click();

        wait.until(ExpectedConditions.urlContains("Adobe+Photoshop+CS4"));
        WebElement adobeProduct = driver.findElement(By.linkText("Adobe Photoshop CS4"));

        Assert.assertEquals(adobeProduct.getText(), "Adobe Photoshop CS4", "aradığınız ürün bulunamadı");
    }
}

