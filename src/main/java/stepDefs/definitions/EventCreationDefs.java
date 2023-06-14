package stepDefs.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import stepDefs.steps.EventCreationSteps;

public class EventCreationDefs {
    @Steps
    EventCreationSteps eventCreationSteps;

    @Given("I am on the event creation login page")
    public void iAmOnTheEventCreationPage() {
        eventCreationSteps.openEventCreationDashboard();
    }

    @And("I login to MIO as MIO user")
    public void iLoginToMIOAsMIOUser() {
        eventCreationSteps.loginToMIO();
    }

    @When("I create new event")
    public void iCreateEvent() {
        eventCreationSteps.createEvent();
    }

    @When("I select Basics eventType {string}, Artist {string}, Title {string}, Genre {string}, Venue name {string}")
    public void iSelectBasicsEventTypeArtistTitleGenreVenueNameVenueCountryStreetAddressStateRegionCityPostcode(String eventType, String artist, String title, String genre, String venueName) {
        eventCreationSteps.fillInBasicsDetails(eventType, artist, title, genre, venueName);
    }

    @When("I fill in Timeline details timeZone {string}")
    public void iFillInTimelineDetailsTimeZone(String timezone) {
        eventCreationSteps.fillInTimelineDetails(timezone);
    }

    @When("I fill in Information details timeZone")
    public void iFillInInformationDetailsTimeZone() {
        eventCreationSteps.fillInInformationDetails();
    }

    @When("I create ticket type {string}")
    public void iCreateTicketType(String ticketType) {
        eventCreationSteps.fillInTicketDetails(ticketType);
    }

    @When("I fill in Settings details")
    public void iFillInSettingsDetails() {
        eventCreationSteps.fillInSettingsDetails();
    }

    @And("I save draft")
    public void iSaveDraft() {
        eventCreationSteps.saveDraft();
    }

    @And("I click on Add Tickets button")
    public void iClickOnAddTicketsButton() {
        eventCreationSteps.addTickets();
    }
}
