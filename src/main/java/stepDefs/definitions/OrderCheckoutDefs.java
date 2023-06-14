package stepDefs.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import stepDefs.steps.OrderCheckoutSteps;

public class OrderCheckoutDefs {

    @Steps
    OrderCheckoutSteps orderCheckoutSteps;

    @When("I click on Buy Now button on Dice home page")
    public void iClickOnBuyNowButtonOnDiceHomePage() {
        orderCheckoutSteps.clickBuyNow();
    }

    @And("I purchase ticket type {string}")
    public void iPurchaseTicketType(String ticketType) {
        orderCheckoutSteps.purchaseTicket(ticketType);
    }

    @And("I register as new user by entering authentication details")
    public void iRegisterAsNewUserByEnteringAuthenticationDetails() {
        orderCheckoutSteps.newUserAuthentication();
    }

    @And("I successfully make payment using credit card")
    public void iSuccessfullyMakePaymentUsingCreditCard() {
        orderCheckoutSteps.makePayment();
    }

    @Then("I verify the Order Confirmation success parameters")
    public void iShouldSeeTheOrderConfirmation() {
        orderCheckoutSteps.verifyOrderSuccess();
    }
}
