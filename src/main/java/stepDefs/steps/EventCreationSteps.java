package stepDefs.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import webstore.components.*;
import webstore.pages.EventConfirmationPage;
import webstore.pages.EventCreationPage;
import webstore.pages.EventHomePage;
import webstore.pages.LoginPage;

import static sessionVariables.SessionVariables.CREATED_TICKET_TYPES;
import static sessionVariables.SessionVariables.EVENT_NAME;

public class EventCreationSteps extends ScenarioSteps {
    EventCreationPage eventCreationPage;
    EventConfirmationPage eventConfirmationPage;
    EventHomePage eventHomePage;
    LoginPage loginPage;
    BasicsModel basicsModel;
    TimelineModel timelineModel;
    InformationModel informationModel;
    TicketsModel ticketsModel;
    SettingsModel settingsModel;

    @Step
    public void createEvent() {
        eventCreationPage.clickNewEventButton();
    }

    @Step
    public void openEventCreationDashboard() {
        eventCreationPage.openDashboard();
    }

    @Step
    public void loginToMIO() {
        loginPage.loginToMio();
        Assert.assertTrue("Dashboard is not loaded", eventCreationPage.isDashboardVisible());
    }

    @Step
    public void fillInBasicsDetails(String eventType, String artist, String genre, String venueName) {
        basicsModel.fillInBasicsForm(eventType, artist, genre, venueName);
    }

    @Step
    public void fillInTimelineDetails(String timezone) {
        timelineModel.fillInTimelineForm(timezone);
    }

    @Step
    public void fillInInformationDetails() {
        informationModel.fillInInformationForm();
    }

    @Step
    public void fillInTicketDetails(String ticketType) {
        Serenity.setSessionVariable(CREATED_TICKET_TYPES).to(ticketType);
        ticketsModel.fillInTicketForm(ticketType);
    }

    @Step
    public void fillInSettingsDetails() {
        settingsModel.enterInternalNotes();
    }

    @Step
    public void saveAndContinue() {
        eventCreationPage.saveAndContinue();
    }

    @Step
    public void addTickets() {
        ticketsModel.addTickets();
    }

    @Step
    public void submitEventCreation() {
        eventCreationPage.submit();
    }

    @Step
    public void verifySuccessfulCreationAndSubmission() {
        Assert.assertEquals("The success message does not matched expected.", "Client Admin Account, your event’s been published.", eventConfirmationPage.returnSuccessMessage());
    }

    @Step
    public void previewEvent() {
        eventConfirmationPage.previewEvent();
        Assert.assertTrue("Event name does match on preview", eventConfirmationPage.getEventNameFromHeader().contains(Serenity.sessionVariableCalled(EVENT_NAME)));
    }

    @Step
    public void viewOnDice() {
        eventConfirmationPage.viewOnDiceWeb();
        Assert.assertTrue("Dice web page has not loaded", eventHomePage.isDiceLogoPresent());
    }

    @Step
    public void fillInIncorrectTimelineDetails(String timezone) {
        timelineModel.fillInTimelineFormWithIncorrectValues(timezone);
    }

    @Step
    public void verifyErrorMessageIsDisplayed() {
        Assert.assertEquals("Error message differs. ", "On sale date should be after announce date", timelineModel.getErrorMessage(0));
        Assert.assertEquals("Error message differs. ", "Off sale date should be before event end date", timelineModel.getErrorMessage(1));
        Assert.assertEquals("Error message differs. ", "Event start date should be before event end date", timelineModel.getErrorMessage(2));
    }
}
