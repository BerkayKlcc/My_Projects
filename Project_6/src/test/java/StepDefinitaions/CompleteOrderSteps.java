package StepDefinitaions;

import Pages.DialogContent;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class CompleteOrderSteps {

    DialogContent dc = new DialogContent();

    @When("User click to shopping cart button")
    public void userClickToShoppingCartButton(DataTable elements) throws InterruptedException {
        List<String> listelements = elements.asList(String.class);
        for (String strButtonName : listelements) {
            dc.findAndClick(strButtonName);
        }
    }

    @And("User click to Checkout button")
    public void userClickToCheckoutButton(DataTable elements) {
        List<String> listelements = elements.asList(String.class);
        for (String strButtonName : listelements) {
            dc.findAndClick(strButtonName);
        }
    }

    @And("User fills the address form")
    public void userFillsTheAddressForm(DataTable elements) {
        List<List<String>> listelements = elements.asLists(String.class);

        for (int i = 0; i < listelements.size(); i++)
            dc.findAndSend(listelements.get(i).get(0), listelements.get(i).get(1));
    }

    @Then("User clicks next button")
    public void userClicksNextButton(DataTable elements) {
        List<String> listelements = elements.asList(String.class);
        for (String strButtonName : listelements) {
            dc.findAndClick(strButtonName);
        }
    }

    @When("User click to account Click")
    public void userClickToAccountClick(DataTable elements) {
        List<String> listelements = elements.asList(String.class);
        for (String strButtonName : listelements) {
            dc.findAndClick(strButtonName);
        }

    }

    @Then("User can logout")
    public void userCanLogout(DataTable elements) {
        List<String> listelements = elements.asList(String.class);
        for (String strButtonName : listelements) {
            dc.findAndClick(strButtonName);
        }
    }
}
