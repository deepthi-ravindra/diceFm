package webstore.components;

import log.Log;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class TicketTypeModal extends CommonComponents {
    @FindBy(css = "[data-id='iconButton[standing]']")
    WebElementFacade ticketTypeIconStanding;

    @FindBy(css = "[data-id='iconButton[unreserved_seating]']")
    WebElementFacade ticketTypeIconUnreservedSeating;

    @FindBy(className = "Modal__ModalContent-sc-1pb5y5w-5")
    WebElementFacade ticketTypeForm;

    @FindBy(name = "faceValue")
    WebElementFacade ticketPrice;
    @FindBy(name = "allocation")
    WebElementFacade ticketAllocation;
    By ticketNameField = By.cssSelector("input[name='name']");

    /**
     * Based, on ticket type, clicks on ticket type icon
     *
     * @param ticketType
     */
    public void selectTicketTypeIcon(String ticketType) {
        switch (ticketType) {
            case "Standing" -> ticketTypeIconStanding.click();
            case "Unreserved Seating" -> ticketTypeIconUnreservedSeating.click();
            default -> Log.error("Please select a correct ticket type.");
        }
    }

    /**
     * Enters ticket description
     *
     * @param ticketDescription
     */
    public void enterTicketDescription(String ticketDescription) {
        setFieldText(findAll(descriptionField).get(1), ticketDescription);

    }

    /**
     * Enters ticket price
     *
     * @param price
     */
    public void enterTicketPrice(int price) {
        ticketPrice.waitUntilVisible();
        typeInto(ticketPrice, String.valueOf(price + ".00"));
    }

    /**
     * Enters ticket allocation
     *
     * @param allocation
     */
    public void enterTicketAllocation(int allocation) {
        ticketAllocation.waitUntilVisible();
        //extra step to make field is cleared before entering
        evaluateJavascript("arguments[0].value = ''", ticketAllocation);
        ticketAllocation.clear();
        ticketAllocation.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), String.valueOf(allocation));
    }

    /**
     * Clicks on Save to save specific ticket type
     */
    public void saveTicketTypeDetails() {
        findAll(buttons).get(1).waitUntilVisible();
        clickOn(findAll(buttons).get(1));
        Log.info("Saved ticket type");
    }
}
