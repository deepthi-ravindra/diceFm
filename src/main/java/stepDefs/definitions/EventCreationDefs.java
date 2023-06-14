package stepDefs.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    @When("I click create new event button")
    public void iCreateEvent() {
        eventCreationSteps.createEvent();
    }

    @When("I select Basics eventType {string}, Artist {string}, Genre {string}, Venue name {string}")
    public void iSelectBasicsEventTypeArtistTitleGenreVenueNameVenueCountryStreetAddressStateRegionCityPostcode(String eventType, String artist, String genre, String venueName) {
        eventCreationSteps.fillInBasicsDetails(eventType, artist, genre, venueName);
    }

    @When("I fill in Timeline details with timeZone {string}")
    public void iFillInTimelineDetailsTimeZone(String timezone) {
        eventCreationSteps.fillInTimelineDetails(timezone);
    }

    @When("I fill in Information details")
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

    @And("I save event and continue")
    public void iSaveAndContinue() {
        eventCreationSteps.saveAndContinue();
    }

    @And("I click on Add Tickets button")
    public void iClickOnAddTicketsButton() {
        eventCreationSteps.addTickets();
    }

    @And("I submit the event details")
    public void iSubmitTheEventDetails() {
        eventCreationSteps.submitEventCreation();
    }

    @Then("I verify the event creation are successful")
    public void iVerifyTheEventCreationAreSuccessful() {
        eventCreationSteps.verifySuccessfulCreationAndSubmission();
    }

    @And("I can successfully preview the event")
    public void iCanSuccessfullyPreviewTheEvent() {
        eventCreationSteps.previewEvent();
    }

    @And("I am able to view the event on the web")
    public void iAmAbleToViewTheEventOnTheWeb() {
        eventCreationSteps.viewOnDice();
    }

    @And("I fill in incorrect Timeline details with timeZone {string}")
    public void iFillInIncorrectTimelineDetailsWithTimeZone(String timezone) {
        eventCreationSteps.fillInIncorrectTimelineDetails(timezone);
    }

    @And("I verify error message is displayed")
    public void iVerifyErrorMessageIsDisplayed() {
        eventCreationSteps.verifyErrorMessageIsDisplayed();
    }
}
