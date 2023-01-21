package TestNG_Project;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Proje extends BaseDriver {
    @Test(priority = 1)
    void checkLeftNaw() throws InterruptedException {
        PomElements elements=new PomElements();
        Thread.sleep(1000);
        elements.menu9.click();
        Thread.sleep(1000);
        elements.menu8.click();
        Thread.sleep(1000);
        elements.menu7.click();
        Thread.sleep(1000);
        elements.menu6.click();
        Thread.sleep(1000);
        elements.menu5.click();
        Thread.sleep(1000);
        elements.menu4.click();
        Thread.sleep(1000);
        elements.menu3.click();
        Thread.sleep(1000);
        elements.menu2.click();
        Thread.sleep(1000);
        elements.menu1.click();
        Thread.sleep(1000);
        elements.menu1.click();
        Thread.sleep(1000);

        // TestCase3
    }
    @Test(priority = 2)
    void createCustomer() throws InterruptedException {
        PomElements elements=new PomElements();
        elements.mainCustomers.click();
        Thread.sleep(1000);
        elements.customerSub.click();
        Thread.sleep(1000);
        elements.addNewButton.click();
        elements.email.sendKeys("candeneme87@gmail.com");
        elements.password.sendKeys("12345C");
        elements.firstNameTxt.sendKeys("berk");
        elements.lastNameTxt.sendKeys("ismail");
        elements.gender.click();
        elements.dateOfbirthday.sendKeys("01/01/1990");
        elements.companyName.sendKeys("grup4");
        elements.taxExampt.click();
        elements.newsletter.click();
        Thread.sleep(1000);
        elements.subNews.click();
        Select slct=new Select(elements.managerOfVendor);
        slct.selectByVisibleText("Vendor 1");
        elements.textBoxComment.sendKeys("test");
        elements.saveButton.click();
        Assert.assertTrue(elements.customerSaveSuccessfullText.getText().contains("The new customer has been added successfully."));

    }

    @Test(priority = 3)
    void editCustomer() throws InterruptedException {
        PomElements elements=new PomElements();
        elements.mainCustomers.click();
        elements.customerSub.click();
        elements.emailEdit.sendKeys("candeneme87@gmail.com");
        elements.firstNameEdit.sendKeys("berk");
        elements.lastNameEdit.sendKeys("ismail");

        elements.searchCustomersEdit.click();
        Thread.sleep(1000);
        Assert.assertTrue(elements.customerVerifiying.getText().contains("candeneme87@gmail.com"));
        elements.editButton.click();
        elements.firstNameTxt.clear();
        elements.firstNameTxt.sendKeys("muhittin");
        elements.saveButton2.click();
        Assert.assertTrue(elements.editVerifiy.getText().contains("The customer has been updated successfully."));

    }
    @Test(priority = 4)
    void deleteCustomer() throws InterruptedException {
        PomElements elements=new PomElements();
        elements.mainCustomers.click();
        elements.customerSub.click();
        elements.emailEdit.sendKeys("candeneme87@gmail.com");
        elements.firstNameEdit.sendKeys("muhittin");
        elements.lastNameEdit.sendKeys("ismail");
        elements.searchCustomersEdit.click();
        Thread.sleep(1000);
        elements.editButton.click();
        elements.deleteButton.click();
        elements.deleteButton2.click();
        Assert.assertTrue(elements.editVerifiy.getText().contains("The customer has been deleted successfully."));
    }
    @Test(priority = 5)
    void searchTest() throws InterruptedException {
        PomElements elements=new PomElements();
        Thread.sleep(5000);
        elements.searchBox.sendKeys("Shipments");
        //Thread.sleep(2000);
        elements.searchClick.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("ShipmentList"));
    }
}
