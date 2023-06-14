package webstore.components;

import log.Log;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import utility.Utilities;

import java.io.File;

public class TicketsModel extends CommonComponents {
    TicketTypeModal ticketTypeModal;
    @FindBy(css = "[data-id='wizardStep[tickets]']")
    WebElementFacade ticketForm;

    @FindBy(className = "ListAddButton__AddButton-sc-f24vz4-0")
    WebElementFacade addTicketAgain;

    public void addTickets() {
        ticketForm.waitUntilVisible();

        findAll(buttons).get(0).waitUntilVisible();
        clickOn(findAll(buttons).get(0));
    }

    public void fillInTicketForm(String ticketType) {
        try {
            addTicketAgain.waitUntilVisible();
            addTicketAgain.click();
        } catch (NoSuchElementException noSuchElementException) {
            //Move on as this is expected first time
        } catch(ElementClickInterceptedException elementClickInterceptedException) {
            clickOn(addTicketAgain);
        }
        setTicketTypeFields(ticketType);

    }

    private void setTicketTypeFields(String ticketType) {
        ticketTypeModal.selectTicketTypeIcon(ticketType);
        ticketTypeModal.enterTicketDescription(ticketType + " Ticket description");
        ticketTypeModal.addTicketTimeline();

        ticketTypeModal.enterTicketPrice(Utilities.getRandomNumberBetween(20, 60));
//        ticketTypeModal.enterTicketAllocation(Utilities.getRandomNumberBetween(1, 10));

        ticketTypeModal.saveTicketTypeDetails();
    }
}
