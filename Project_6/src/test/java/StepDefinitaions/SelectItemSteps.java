package StepDefinitaions;

import Pages.DialogContent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectItemSteps {

    DialogContent dc=new DialogContent();
//    @When("User clicks item button")
//    public void userClicksItemButton() {
//        dc.findAndClick("signIn");
//    }

    @And("User selects sizes")
    public void userSelectsSizes() {
        dc.findAndClick("size");
    }

    @And("User selects color")
    public void userSelectsColor() {
        dc.findAndClick("color");
    }

    @Then("User clicks add to cart button")
    public void userClicksAddToCartButton() {
        dc.findAndClick("addToCart");
    }

    @And("User selects size")
    public void userSelectsSize() {
        dc.findAndClick("size");
    }

    @When("User clicks women button")
    public void userClicksWomenButton() {
        dc.findAndClick("women");
        dc.findAndClick("shorts");
        dc.findAndClick("item1");
    }
}
