package stepDefs.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import webstore.components.*;
import webstore.pages.EventCreationPage;
import webstore.pages.LoginPage;

public class EventCreationSteps {
    EventCreationPage eventCreationPage;
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
    public void fillInBasicsDetails(String eventType, String artist, String title, String genre, String venueName) {
        basicsModel.fillInBasicsForm(eventType, artist, title, genre, venueName);
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
        ticketsModel.fillInTicketForm(ticketType);
    }

    @Step
    public void fillInSettingsDetails() {
        settingsModel.enterInternalNotes();
    }

    @Step
    public void saveDraft() {
        eventCreationPage.saveDraft();
    }

    @Step
    public void addTickets() {
        ticketsModel.addTickets();
    }
}
