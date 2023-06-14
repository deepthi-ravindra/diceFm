package webstore.pages;

import log.Log;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.support.FindBy;
import webstore.components.CommonComponents;

public class LoginPage extends CommonComponents {

    @FindBy(name = "email")
    WebElementFacade emailField;
    @FindBy(name = "password")
    WebElementFacade passwordField;

    @FindBy(className = "-preset-primary-outline")
    WebElementFacade signInButton;

    EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    /**
     * Login to MIO Dashboard
     */
    public void loginToMio() {
        enterUsername();
        enterPassword();
        clickSignInButton();
    }

    /**
     * Click Sign in button
     */
    private void clickSignInButton() {
        signInButton.waitUntilEnabled();
        signInButton.click();
        dashboard.waitUntilVisible();

        Log.info("Signed in as MIO user");
    }

    /**
     * Enter password
     */
    private void enterPassword() {
        passwordField.waitUntilVisible();
        typeInto(passwordField, environmentVariables.getProperty("mio.password"));
        signInButton.waitUntilEnabled();
    }

    /**
     * Enter username
     */
    public void enterUsername() {
        emailField.waitUntilVisible();
        typeInto(emailField, environmentVariables.getProperty("mio.username"));

    }
}
