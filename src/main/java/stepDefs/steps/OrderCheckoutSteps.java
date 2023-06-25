package stepDefs.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import webstore.components.AuthenticationModal;
import webstore.components.PaymentModal;
import webstore.pages.EventHomePage;
import webstore.pages.OrderConfirmationPage;

import static sessionVariables.SessionVariables.*;

public class OrderCheckoutSteps extends ScenarioSteps {

    EventHomePage eventHomePage;
    OrderConfirmationPage orderConfirmationPage;
    AuthenticationModal authenticationModal;
    PaymentModal paymentModal;

    @Step
    public void clickBuyNow() {
        eventHomePage.clickBuyNowButton();
    }

    @Step
    public void purchaseTicket(String ticketType) {
        eventHomePage.purchaseTickets(ticketType);
    }

    @Step
    public void newUserAuthentication() {
        Assert.assertTrue("Authentication model is not visible", authenticationModal.isModalVisible());
        authenticationModal.enterAuthenticationDetails();

    }

    @Step
    public void makePayment() {
        Assert.assertTrue("Payment modal is not visible", paymentModal.isModalVisible());
        paymentModal.enterPaymentDetails();
    }

    @Step
    public void verifyOrderSuccess() {
        Assert.assertTrue("Order is not successful", orderConfirmationPage.isSuccessMessageVisible());
        Assert.assertTrue("Order success message differs. Expected: THE TICKET IS ALL YOURS" + " but actual: " + orderConfirmationPage.getSuccessMessage(), orderConfirmationPage.getSuccessMessage().contains("THE TICKET IS ALL YOURS"));
        Assert.assertEquals("Event name differs", Serenity.sessionVariableCalled(EVENT_NAME), orderConfirmationPage.getEventName());
        Assert.assertTrue("Event date differs. Expected: " + Serenity.sessionVariableCalled(EVENT_DATE) + " but actual: " + orderConfirmationPage.getEventVenueAndDate(), orderConfirmationPage.getEventVenueAndDate().contains(Serenity.sessionVariableCalled(EVENT_DATE)));
        Assert.assertTrue("Event venue differs. Expected: " + Serenity.sessionVariableCalled(EVENT_VENUE) + " but actual: " + orderConfirmationPage.getEventVenueAndDate(), orderConfirmationPage.getEventVenueAndDate().contains(Serenity.sessionVariableCalled(EVENT_VENUE)));
        Assert.assertTrue("App card is not present", orderConfirmationPage.isAppCardPresent());
    }

    @Step
    public void closePage() {
        orderConfirmationPage.clickCloseButton();
    }
}
