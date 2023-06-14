package webstore.components;

import log.Log;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class InformationModel extends CommonComponents {

    @FindBy(css = "[data-id='wizardStep[information]']")
    WebElementFacade informationForm;

    By uploadField = By.name("eventImages");

    /**
     * Fill in Information form with images and description of event
     */
    public void fillInInformationForm() {
        informationForm.waitUntilVisible();

        clickOn(informationForm);
        find(uploadField).sendKeys(new File("./diceLondon.jpeg").getAbsolutePath());

        find(descriptionField).waitUntilVisible();
        find(descriptionField).clear();
        typeInto(find(descriptionField), "EVENT DESCRIPTION HERE");
        Log.info("INFORMATION FORM FILLED - Uploaded Event images and filled in description field ");
    }
}
