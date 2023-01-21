package StepDefinitaions;


import Pages.DialogContent;
import Utilities.GenWebDr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    DialogContent dc=new DialogContent();
    @Given("Navigate to Luna")
    public void navigateToLuna() {

        GenWebDr.getDriver().get("https://magento.softwaretestingboard.com/");
        GenWebDr.getDriver().manage().window().maximize();

    }

    @When("Enter username and password click login button")
    public void enterUsernameAndPasswordClickLoginButton() {
        dc.findAndClick("signIn");
        dc.findAndSend("email"," grup3@gmail.com");
        dc.findAndSend("password","Grup4443");
        dc.findAndClick("signInBttn");
    }

    @Then("User should login successfuly")
    public void userShouldLoginSuccessfuly() {
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndCountainsText("signInAssert","Welcome, Grup4 4Grup!");
    }
}
