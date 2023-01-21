package TestNG_Project;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomElements extends BaseDriver {
    public PomElements() {
        PageFactory.initElements(BaseDriver.driver , this);

    }

    @FindBy(xpath = "(//p[normalize-space()='Catalog'])[1]")
    public WebElement menu1;

    @FindBy(css = "ul[class='nav nav-pills nav-sidebar flex-column nav-legacy']> :nth-child(2)")
    public WebElement menu2;

    @FindBy(xpath = "(//i[contains(@class,'right fas fa-angle-left')])[4]")
    public WebElement menu3;

    @FindBy(xpath = "(//i[contains(@class,'right fas fa-angle-left')])[5]")
    public WebElement menu4;

    @FindBy(xpath = "(//i[contains(@class,'right fas fa-angle-left')])[6]")
    public WebElement menu5;

    @FindBy(xpath = "(//i[contains(@class,'right fas fa-angle-left')])[7]")
    public WebElement menu6;

    @FindBy(xpath = "(//i[contains(@class,'right fas fa-angle-left')])[11]")
    public WebElement menu7;

    @FindBy(xpath = "(//i[contains(@class,'right fas fa-angle-left')])[12]")
    public WebElement menu8;

    @FindBy(xpath = "(//i[contains(@class,'right fas fa-angle-left')])[14]")
    public WebElement menu9;

    @FindBy(css = "ul[class='nav nav-treeview'][style='display: block;']>li")
    public WebElement catalogSubMenu;

    @FindBy(css = "[class='nav-icon far fa-user']~p")
    public WebElement mainCustomers;

    @FindBy(xpath = "(//i[@class='nav-icon far fa-dot-circle'])[13]")
    public WebElement customerSub;

    @FindBy(css = "a[class='btn btn-primary']")
    public WebElement addNewButton;

    @FindBy(css = "input[id='Email']")
    public WebElement email;

    @FindBy(css = "input[id='Password']")
    public WebElement password;

    @FindBy(css = "input[id='FirstName']")
    public WebElement firstNameTxt;

    @FindBy(css = "input[id='LastName']")
    public WebElement lastNameTxt;

    @FindBy(css = "input[id='Gender_Male']")
    public WebElement gender;

    @FindBy(css = "input[id='DateOfBirth']")
    public WebElement dateOfbirthday;

    @FindBy(css = "input[id='Company']")
    public WebElement companyName;

    @FindBy(css = "input[id='IsTaxExempt']")
    public WebElement taxExampt;

    @FindBy(css = "div[unselectable='on']")
    public WebElement newsletter;

    @FindBy(css ="div[class='k-list-scroller']>ul>li~li")
    public WebElement subNews;

    @FindBy(css = "select[id='VendorId']")
    public WebElement managerOfVendor;

    @FindBy(css = "textarea[class='form-control']")
    public WebElement textBoxComment;

    @FindBy(css = "button[class='btn btn-primary']")
    public WebElement saveButton;

    @FindBy(xpath = "(//div[@class='alert alert-success alert-dismissable'])[1]")
    public WebElement customerSaveSuccessfullText;

    @FindBy(id="SearchEmail")
    public WebElement emailEdit;

    @FindBy(id="SearchFirstName")
    public WebElement firstNameEdit;

    @FindBy(id="SearchLastName")
    public WebElement lastNameEdit;

    @FindBy(id="search-customers")
    public WebElement searchCustomersEdit;

    @FindBy(css = "div[class='row'] div[class='col-md-12']")
    public WebElement customerVerifiying;

    @FindBy(css = "td[class=' button-column']>a")
    public WebElement editButton;

    @FindBy(css = "button[class='btn btn-primary']")
    public WebElement saveButton2;

    @FindBy(css = "[class='alert alert-success alert-dismissable']")
    public WebElement editVerifiy;

    @FindBy(css = "#customer-delete")
    public WebElement deleteButton;

    @FindBy(css = "button[class='btn btn-danger float-right']")
    public WebElement deleteButton2;

    @FindBy(css = "input[placeholder='Search']")
    public WebElement searchBox;

    @FindBy(css = "strong[class='tt-highlight']")
    public WebElement searchClick;













}
