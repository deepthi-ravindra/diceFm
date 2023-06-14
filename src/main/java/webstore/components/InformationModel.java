package webstore.components;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import utility.Utilities;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class InformationModel extends CommonComponents{

    @FindBy(css = "[data-id='wizardStep[information]']")
    WebElementFacade informationForm;

    By uploadField = By.name("eventImages");



    public void fillInInformationForm() {
        informationForm.waitUntilVisible();

        clickOn(informationForm);
        find(uploadField).sendKeys(new File("./diceLondon.jpeg").getAbsolutePath());

        find(descriptionField).waitUntilVisible();
        find(descriptionField).clear();
        typeInto(find(descriptionField), "EVENT DESCRIPTION HERE");
    }
}
