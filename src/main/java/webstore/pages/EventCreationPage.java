package webstore.pages;

import log.Log;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import webstore.components.CommonComponents;


public class EventCreationPage extends CommonComponents {

    @FindBy(className = "gDmVIE")
    WebElementFacade dashboard;
    @FindBy(className = "iNrbEm")
    WebElementFacade signInform;

    @FindBy(css = "[href = '/events/new']")
    WebElementFacade newEventButton;

    @FindBy(css = "[data-id = 'saveButton']")
    WebElementFacade saveDraftButton;
    EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    public void createEventOnSale() {

    }

    public void openDashboard() {
        try {
            openAt(environmentVariables.getProperty("dice.base.url"));
            signInform.waitUntilVisible();
        } catch (SerenityManagedException sme) {
            Log.error(sme.getMessage());
        } catch (WebDriverException wde) {
            Log.error(wde.getMessage());
        }
    }

    public boolean isDashboardVisible() {
        return dashboard.isVisible();
    }

    public void clickNewEventButton() {
        newEventButton.waitUntilVisible();
        newEventButton.click();
        newEventButton.waitUntilNotVisible();
    }

    public void saveDraft() {
        saveDraftButton.waitUntilEnabled();
        clickOn(saveDraftButton);
    }
}
