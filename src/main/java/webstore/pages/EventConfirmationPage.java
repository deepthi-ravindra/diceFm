package webstore.pages;

import log.Log;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import webstore.components.CommonComponents;

public class EventConfirmationPage extends CommonComponents {

    @FindBy(className = "EventSuccess__HeaderText-sc-iib5cz-2")
    WebElementFacade successMessage;

    @FindBy(css = "[data-id='goToEvent']")
    WebElementFacade manageEventButton;

    @FindBy(css = "[data-id='previewOnDiceButton']")
    WebElementFacade preview;

    @FindBy(className = "EventHeaderData__EventTitle-sc-2npiyx-5")
    WebElementFacade eventHeader;

    @FindBy(css = "[data-id='showOnDiceButton']")
    WebElementFacade viewOnDice;

    /**
     * Returns success message after event submission for verification
     *
     * @return success message
     */
    public String returnSuccessMessage() {
        waitABit(2000);
        successMessage.waitUntilVisible();
        Log.info("Event successfully created and submitted");
        return successMessage.getText();
    }

    /**
     * Clicks manage event button
     */
    public void previewEvent() {
        manageEventButton.waitUntilVisible();
        manageEventButton.click();
        Log.info("Preview event clicked");
    }

    /**
     * Clicks View on Dice button
     */
    public void viewOnDiceWeb() {
        waitABit(2000);
        try {
            viewOnDice.waitUntilVisible();
            viewOnDice.click();
        } catch (NoSuchElementException noSuchElementException) {
            preview.waitUntilVisible();
            preview.click();
        }
        Log.info("Clicked on View on Dice button");
    }

    /**
     * Returns event header name for further verifications
     *
     * @return event header name
     */
    public String getEventNameFromHeader() {
        return eventHeader.getTextValue();
    }
}
