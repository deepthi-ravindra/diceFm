package webstore.components;

import log.Log;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import utility.Utilities;

public class TicketsModel extends CommonComponents {
    TicketTypeModal ticketTypeModal;
    @FindBy(css = "[data-id='wizardStep[tickets]']")
    WebElementFacade ticketForm;

    @FindBy(className = "ListAddButton__AddButton-sc-f24vz4-0")
    WebElementFacade addTicketAgain;

    /**
     * Clicks Add ticket button
     */
    public void addTickets() {
        ticketForm.waitUntilVisible();

        findAll(buttons).get(0).waitUntilVisible();
        clickOn(findAll(buttons).get(0));
    }

    /**
     * Fill in ticket type and other ticket details
     *
     * @param ticketType
     */
    public void fillInTicketForm(String ticketType) {
        try {
            if (ticketType.equalsIgnoreCase("Unreserved Seating")) {
                addTicketAgain.waitUntilVisible();
                addTicketAgain.click();
            }
        } catch (NoSuchElementException noSuchElementException) {
            //Move on as this is expected first time
        } catch (ElementClickInterceptedException elementClickInterceptedException) {
            clickOn(addTicketAgain);
        }
        setTicketTypeFields(ticketType);
    }

    /**
     * Set ticket type fields - type, description, price, allocation of seats and save
     *
     * @param ticketType
     */
    private void setTicketTypeFields(String ticketType) {
        ticketTypeModal.selectTicketTypeIcon(ticketType);
        ticketTypeModal.enterTicketDescription(ticketType + " Ticket description");

        ticketTypeModal.enterTicketPrice(Utilities.getRandomNumberBetween(20, 60));
        ticketTypeModal.enterTicketAllocation(Utilities.getRandomNumberBetween(1, 10));

        ticketTypeModal.saveTicketTypeDetails();
        Log.info("Created ticket type: " + ticketType);
    }
}
