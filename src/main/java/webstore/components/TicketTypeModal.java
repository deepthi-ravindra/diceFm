package webstore.components;

import log.Log;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utility.Utilities;

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

    public void selectTicketTypeIcon(String ticketType) {
//        ticketTypeIconStanding.waitUntilVisible();
        switch (ticketType) {
            case "Standing" -> ticketTypeIconStanding.click();
            case "Unreserved Seating" -> ticketTypeIconUnreservedSeating.click();
            default -> Log.info("Please select a correct ticket type.");
        }
    }

    public void enterTicketName(String ticketNameInput) {
       setFieldText(findAll(ticketNameField).get(1), ticketNameInput);
    }

    public void enterTicketDescription(String ticketDescription) {
        setFieldText(findAll(descriptionField).get(1), ticketDescription);

    }

    public void addTicketTimeline() {
        findAll(onSaleDate).get(1).waitUntilVisible();

        findAll(announcementDate).get(1).waitUntilVisible();
        typeInto(findAll(announcementDate).get(1), Utilities.getDateInFormat(Utilities.datesToModify(-3)));
        new Actions(getDriver()).click(ticketTypeForm).perform();
        new Actions(getDriver()).click(ticketTypeForm).perform();
        waitABit(1000);

        findAll(onSaleDate).get(1).waitUntilVisible();
        typeInto(findAll(onSaleDate).get(1), Utilities.getDateInFormat(Utilities.datesToModify(-1)));
        new Actions(getDriver()).click(ticketTypeForm).perform();
        new Actions(getDriver()).click(ticketTypeForm).perform();
        waitABit(1000);

        findAll(offSaleDate).get(1).waitUntilVisible();
        typeInto(findAll(offSaleDate).get(1), Utilities.getDateInFormat(Utilities.datesToModify(3)));
        new Actions(getDriver()).click(ticketTypeForm).perform();
        new Actions(getDriver()).click(ticketTypeForm).perform();
        waitABit(1000);
    }

    public void enterTicketPrice(int price) {
        ticketPrice.waitUntilVisible();
        typeInto(ticketPrice,String.valueOf(price+".00"));
    }

    public void saveTicketTypeDetails() {
        findAll(buttons).get(1).waitUntilVisible();
        clickOn(findAll(buttons).get(1));
    }
}
