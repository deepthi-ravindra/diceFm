package webstore.components;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class SettingsModel extends PageObject {
    @FindBy(name = "extraNotes")
    WebElementFacade internalNotes;

    public void enterInternalNotes() {
        internalNotes.waitUntilVisible();
        typeInto(internalNotes, "Internal notes here");
    }
}
