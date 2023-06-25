package webstore.pages;

import log.Log;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends PageObject {

    @FindBy(className = "ConfirmationCard__Container-sc-5rszri-8")
    WebElementFacade orderConfirmationCard;
    @FindBy(className = "ConfirmationCard__Title-sc-5rszri-2")
    WebElementFacade successMessage;

    @FindBy(className = "ConfirmationCard__Text1-sc-5rszri-3")
    WebElementFacade eventName;

    @FindBy(css = "[class*='Purchase__CancelFlow']")
    WebElementFacade closeButton;

    @FindBy(className = "ConfirmationCard__Text2-sc-5rszri-4")
    WebElementFacade eventVenueAndDate;

    @FindBy(className = "AppCard__Container-sc-1iv59ds-0")
    WebElementFacade appCard;

    /**
     * Returns whether order success message is visible
     *
     * @return boolean
     */
    public boolean isSuccessMessageVisible() {
        orderConfirmationCard.waitUntilVisible();
        Log.info("Order successful! :) ");
        return orderConfirmationCard.isVisible();
    }

    /**
     * Returns success message text
     *
     * @return success message
     */
    public String getSuccessMessage() {
        successMessage.waitUntilVisible();
        return successMessage.getText().replace("\n", " ").trim().toUpperCase();
    }

    /**
     * Returns event name
     *
     * @return event name
     */
    public String getEventName() {
        eventName.waitUntilVisible();
        return eventName.getText();
    }

    /**
     * Returns event venue and date text from confirmation screen
     *
     * @return event venue and date
     */
    public String getEventVenueAndDate() {
        eventVenueAndDate.waitUntilVisible();
        return eventVenueAndDate.getText();
    }

    /**
     * Returns whether app details are present for customer tracking
     *
     * @return boolean
     */
    public boolean isAppCardPresent() {
        appCard.waitUntilVisible();
        return appCard.isVisible();
    }


    public void clickCloseButton() {
        closeButton.waitUntilVisible();
        closeButton.click();
    }
}
