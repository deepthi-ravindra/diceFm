package webstore.components;

import log.Log;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class SettingsModel extends PageObject {
    @FindBy(name = "extraNotes")
    WebElementFacade internalNotes;

    /**
     * Adds any internal notes
     */
    public void enterInternalNotes() {
        internalNotes.waitUntilVisible();
        typeInto(internalNotes, "Internal notes here");
        Log.info("SETTINGS FORM COMPLETED - Added internal notes in Settings");
    }
}
