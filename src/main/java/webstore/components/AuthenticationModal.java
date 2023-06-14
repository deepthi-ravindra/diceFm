package webstore.components;

import log.Log;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class AuthenticationModal extends CommonComponents {


    @FindBy(className = "PurchasePhone__Container-sc-1odqjnb-3")
    WebElementFacade authenticationModal;

    @FindBy(css = ".PhoneField__Container-sc-1i75a8x-7 > input")
    WebElementFacade mobileNumberField;

    @FindBy(css = "button[type='submit']")
    WebElementFacade continueButton;

    @FindBy(className = "CodeInput__Input-pxula4-2")
    WebElementFacade codeInputField;

    /**
     * Enter authentication details  - phone number and code to register as new user
     */
    public void enterAuthenticationDetails() {
        Log.info("Entering mobile number on authentication model..");
        mobileNumberField.waitUntilVisible();
        typeInto(mobileNumberField, environmentVariables.getProperty("mio.phoneNumber"));

        continueButton.waitUntilVisible();
        continueButton.click();

        Log.info("Entering code on authentication model..");
        codeInputField.waitUntilVisible();
        typeInto(codeInputField, environmentVariables.getProperty("mio.code"));
        authenticationModal.waitUntilNotVisible();

        Log.info("Entered authentication details");
    }

    /**
     * Returns whether authentication modal is visible
     *
     * @return boolean
     */
    public boolean isModalVisible() {
        return authenticationModal.isVisible();
    }
}
