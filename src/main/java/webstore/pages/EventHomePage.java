package webstore.pages;

import log.Log;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class EventHomePage extends PageObject {

    @FindBy(className = "HomePageHeader__Logo-sc-15u1d7b-4")
    WebElementFacade diceLogo;

    @FindBy(className = "EventDetailsCallToAction__ActionButton-sc-12zjeg-5")
    WebElementFacade buyNowButton;

    @FindBy(css = "[href='/login']")
    WebElementFacade loginButton;

    @FindBy(css = "li.PurchaseTickets__TicketType-sc-1hge6pd-15")
    List<WebElementFacade> ticketTypes;

    @FindBy(className = "dFnwCo")
    WebElementFacade checkoutButton;

    /**
     * Purchase tickets on the Dice web page based on ticket type
     *
     * @param ticketType
     */
    public void purchaseTickets(String ticketType) {
        switch (ticketType) {
            case "Standing" -> {
                Log.info("First ticket type " + ticketType + "  selected for purchase");
                ticketTypes.get(0).waitUntilVisible();
                ticketTypes.get(0).click();
            }

            case "Unreserved Seating" -> {
                Log.info("Second ticket type " + ticketType + "  selected for purchase");
                ticketTypes.get(1).waitUntilVisible();
                ticketTypes.get(1).click();
            }

            default -> Log.error("Invalid Ticket Type selected");
        }
        checkoutButton.waitUntilVisible();
        checkoutButton.click();
        Log.info("Successfully Purchased ticket type: " + ticketType);
    }

    /**
     * Switch to new tab when view on Dice is clicked, go back to old tab, close it so we have only 1 tab to work on
     */
    private void switchToNewTab() {
        //Loop through and close the old tab and switch to new tab
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(0));
        getDriver().close();
        getDriver().switchTo().window(tabs.get(1));
        Log.info("Tab switched");
    }

    /**
     * Returns whether dice logo is present after opening the event on web to verify we landed on home page
     *
     * @return boolean
     */
    public boolean isDiceLogoPresent() {
        switchToNewTab();
        return diceLogo.isVisible();
    }

    /**
     * Clicks on Buy new button
     */
    public void clickBuyNowButton() {
        buyNowButton.waitUntilVisible();
        buyNowButton.click();
        Log.info("Clicked on buy new button to buy tickets");
    }

}
