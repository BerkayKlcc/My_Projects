package Pages;

import Utilities.GenWebDr;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Parent {

    WebDriverWait wait = new WebDriverWait(GenWebDr.getDriver(), Duration.ofSeconds(30));

    public void sendKeysFunction(WebElement element, String value) {

        waitUntilVisiable(element);
       scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void clickFunction(WebElement element) {

        waitUntilClickable(element);
       scrollToElement(element);
        element.click();

    }

    public void waitUntilVisiable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GenWebDr.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilClickable(WebElement element) {
//        Duration dr=Duration.ofSeconds(20);
//        GenWebDr.getDriver().manage().timeouts().implicitlyWait(dr);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void verifyContainsTextFunc(WebElement element, String value) {

       // waitUntilVisiable(element);
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()), "The text you searched could not be find");
        new Actions(GenWebDr.getDriver()).sendKeys(Keys.ESCAPE).perform(); // dialog kutusunu kapatir
    }

//    public void waitUntilLoading() {
//       wait.until(ExpectedConditions.elementToBeSelected(By.xpath("(//span[text()='My Cart'])[1]")));
//        // progressbar ın çocukları
//    }

}

// case sensitive, stringin bir parçası olabilir
//wait.until(ExpectedCondition.textToBePresentInElement(By,"Looking4TextOnElement");//This verifies if text is present on element By.
//wait.until(ExpectedCondition.textToBePresentInElementValue(By,"Looking4TextOnValueAttribute");//This verifies if text is present in value attribute of element By.
