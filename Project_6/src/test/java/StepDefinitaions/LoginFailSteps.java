package StepDefinitaions;

import Pages.DialogContent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class LoginFailSteps {

    DialogContent dc=new DialogContent();

    @And("Click on the element")
    public void clickOnTheElement() {
        dc.findAndClick("signIn");
        dc.findAndClick("signInBttn");
    }

    @When("User enters email as {string} password as {string}")
    public void userEntersEmailAsPasswordAs(String email, String password) {
        dc.findAndSend("email",email);
        dc.findAndSend("password",password );
    }

    @And("Click on the sigin Button")
    public void clickOnTheSiginButton() {
        dc.findAndClick("signIn");
    }

    @And("Click on the login button")
    public void clickOnTheLoginButton() {
        dc.findAndClick("signInBttn");
    }
}
