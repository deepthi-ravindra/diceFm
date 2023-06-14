package webstore.components;

import log.Log;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentModal extends CommonComponents {

    @FindBy(name = "cardnumber")
    WebElementFacade cardNumber;

    @FindBy(className = "PurchasePaymentMethod__Container-dtjb3a-4")
    WebElementFacade paymentModal;

    @FindBy(name = "exp-date")
    WebElementFacade expiryDate;

    @FindBy(name = "cvc")
    WebElementFacade cvcField;

    @FindBy(className = "PurchasePaymentMethod__PurchaseTicketsButton-dtjb3a-5")
    WebElementFacade purchaseTicketsButton;

    @FindBy(css = ".Input__InputWrapper-g3cdq3-0 > input")
    WebElementFacade postcode;

    By paymentNameFrame = By.cssSelector("iframe[name^='__privateStripeFrame']");

    /**
     * Enter payment details - credit card details
     */
    public void enterPaymentDetails() {
        waitABit(4000);
        Log.info("Entering card number for payment..");
        //Switch to payment frame
        getDriver().switchTo().frame((WebElement) find(paymentNameFrame));

        cardNumber.waitUntilVisible();
        typeInto(cardNumber, environmentVariables.getProperty("mio.cardNumber"));
        Log.info("Entered credit card number for payment");

        Log.info("Entering expiry date of card for payment..");
        expiryDate.waitUntilVisible();
        typeInto(expiryDate, environmentVariables.getProperty("mio.expiryDate"));

        Log.info("Entering CVV of card for payment..");
        cvcField.waitUntilVisible();
        typeInto(cvcField, environmentVariables.getProperty("mio.cvc"));

        //switch back to default element from frame
        getDriver().switchTo().defaultContent();

        Log.info("Entered all credit card details for payment");

        Log.info("Entering Postcode of card for payment..");
        postcode.waitUntilVisible();
        typeInto(postcode, environmentVariables.getProperty("mio.postcode"));

        purchaseTicketsButton.waitUntilVisible();
        purchaseTicketsButton.click();
        purchaseTicketsButton.waitUntilNotVisible();
        Log.info("Clicked on purchase ticket button - PAYMENT DETAILS ENTERED");
    }

    /**
     * Returns whether payment modal is visible
     *
     * @return boolean
     */
    public boolean isModalVisible() {
        return paymentModal.isVisible();
    }
}
