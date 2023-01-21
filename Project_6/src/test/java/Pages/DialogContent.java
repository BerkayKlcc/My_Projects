package Pages;

import Utilities.GenWebDr;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DialogContent extends Parent {
    public DialogContent(){

        PageFactory.initElements(GenWebDr.getDriver(),this);
}
    @FindBy(linkText="Sign In")
    private WebElement signIn;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(xpath="(//input[@id='pass'])[1]")
    private WebElement password;

    @FindBy(xpath="//span[text()='Sign In']")
    private WebElement signInBttn;

    @FindBy(xpath="//span[text()='Welcome, Grup4 4Grup!']")
    private WebElement signInAssert;

    @FindBy(xpath="//span[text()='Women']")
    private WebElement women;

    @FindBy(linkText="Shorts")
    private WebElement shorts;

    @FindBy(xpath="//span[@class='product-image-wrapper']/img")
    private WebElement item1;

    @FindBy(xpath="//div[@id='option-label-size-143-item-171'] ")
    private WebElement size;

    @FindBy(css="div[option-id='57'][option-label='Purple']")
    private WebElement color;

    @FindBy(xpath="//span[text()='Add to Cart']")
    private WebElement addToCart;

    @FindBy(xpath="//div[@class='minicart-wrapper']//a")
    private WebElement clickCart;

    @FindBy(css="button[id='top-cart-btn-checkout']")
    private WebElement checkout;

    @FindBy(xpath="(//input[@class='input-text'])[6]")
    private WebElement streetAddress;

    @FindBy(xpath="(//input[@class='input-text'])[9]")
    private WebElement city;

    @FindBy(xpath="(//input[@class='input-text'])[11]")
    private WebElement zipCode;

    @FindBy(xpath="(//input[@class='input-text'])[12]")
    private WebElement phoneNumber;

//    @FindBy(xpath="(//select[@class='select'])[1]")
//    private WebElement state;

    @FindBy(xpath="(//option[@data-title='Turkey'])[1]")
    private WebElement country;

    @FindBy(css="input[type='radio']")
    private WebElement radioBttn;

    @FindBy(xpath="//span[normalize-space()='Next']")
    private WebElement addressNextBttn;

    @FindBy(css="button[class='action primary checkout']")
    private WebElement placeOrderBttn;

    @FindBy(xpath="//div[@class='panel header']//button[@type='button']")
    private WebElement accountClick ;

    @FindBy(xpath="//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
    private WebElement signoutButton  ;


    WebElement myElement;

    public void findAndSend(String strElement, String value){
        //element get

        switch (strElement){
            case "email" : myElement=email;break;
            case "password" : myElement=password;break;
            case "streetAddress" : myElement=streetAddress;break;
            case "city" : myElement=city;break;
            case "zipCode" : myElement=zipCode;break;
            case "phoneNumber" : myElement=phoneNumber;break;


        }
        sendKeysFunction(myElement,value);
    }

    public void findAndClick(String strElement){
        //element get
        switch (strElement){
            case "signIn" : myElement=signIn;break;
            case "signInBttn" : myElement=signInBttn;break;
            case "women" : myElement=women;break;
            case "shorts" : myElement=shorts;break;
            case "item1" : myElement=item1;break;
            case "size" : myElement=size;break;
            case "color" : myElement=color;break;
            case "addToCart" : myElement=addToCart;break;
            case "clickCart" : myElement=clickCart;break;
            case "checkout" : myElement=checkout;break;
            case "country" : myElement=country;break;
            case "radioBttn" : myElement=radioBttn;break;
            case "addressNextBttn" : myElement=addressNextBttn;break;
            case "placeOrderBttn" : myElement=placeOrderBttn;break;
            case "accountClick" : myElement=accountClick;break;
            case "signoutButton" : myElement=signoutButton;break;

        }
        clickFunction(myElement);
    }

    public void findAndCountainsText(String strElement,String text){
        //element get

        switch (strElement){
            case "signInAssert" : myElement=signInAssert;break;
        }
        verifyContainsTextFunc(myElement,text);
    }
    public void  findAndDelete(String searchTex){
//        findAndSend("searchInput",searchTex);
//        findAndClick("searchButton");
        // wait.until(ExpectedConditions.stalenessOf(deleteButton)); zaman araligini yakalayamadi
//        waitUntilLoading();
//        findAndClick("deleteButton");
//        findAndClick("deleteDialogBtn");
    }
}
