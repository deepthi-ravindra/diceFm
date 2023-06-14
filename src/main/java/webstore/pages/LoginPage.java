package webstore.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(name = "email")
    WebElementFacade emailField;
    @FindBy(name = "password")
    WebElementFacade passwordField;

    @FindBy(className = "-preset-primary-outline")
    WebElementFacade signInButton;

    EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    public void loginToMio() {
        enterUsername();
        enterPassword();
        clickSignInButton();
    }

    private void clickSignInButton() {
        signInButton.waitUntilEnabled();
        signInButton.click();
        signInButton.waitUntilNotVisible();
    }

    private void enterPassword() {
        passwordField.waitUntilVisible();
        typeInto(passwordField, environmentVariables.getProperty("mio.password"));
        signInButton.waitUntilEnabled();
    }

    public void enterUsername() {
        emailField.waitUntilVisible();
        typeInto(emailField, environmentVariables.getProperty("mio.username"));

    }
}
