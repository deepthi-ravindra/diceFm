package webstore.pages;

import log.Log;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import webstore.components.CommonComponents;


public class EventCreationPage extends CommonComponents {
    @FindBy(className = "iNrbEm")
    WebElementFacade signInform;

    @FindBy(css = "[href = '/events/new']")
    WebElementFacade newEventButton;
    @FindBy(css = "[data-id = 'saveButton']")
    WebElementFacade saveAndContinueButton;

    @FindBy(css = "[data-id = 'save']")
    WebElementFacade submitButton;

    EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

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

    /**
     * Clicks Create new event button
     */
    public void clickNewEventButton() {
        newEventButton.waitUntilVisible();
        newEventButton.click();
        newEventButton.waitUntilNotVisible();
    }

    /**
     * Click Save and continue
     */
    public void saveAndContinue() {
        saveAndContinueButton.waitUntilVisible();
        saveAndContinueButton.click();
        Log.info("Event Saved an continued to submit");
    }

    /**
     * Click Submit event button
     */
    public void submit() {
        waitABit(2000);
        try {
            submitButton.waitUntilVisible();
            submitButton.click();
        } catch (NoSuchElementException noSuchElementException) {
            saveAndContinueButton.click();
        }
        Log.info("Event Submitted");
    }
}
