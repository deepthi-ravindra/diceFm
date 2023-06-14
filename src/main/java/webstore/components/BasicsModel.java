package webstore.components;

import log.Log;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.FindBy;
import utility.DataGenerator;

import static sessionVariables.SessionVariables.EVENT_NAME;
import static sessionVariables.SessionVariables.EVENT_VENUE;

public class BasicsModel extends CommonComponents {
    @FindBy(css = "[data-slug='basics']")
    WebElementFacade basicsForm;
    @FindBy(id = "artists")
    WebElementFacade artists;

    @FindBy(id = "genres")
    WebElementFacade genres;

    @FindBy(id = "primaryVenue")
    WebElementFacade venue;

    By allTypeOptions = By.cssSelector("[id*='react-select-10-option-']");
    By allArtistOptions = By.cssSelector("[id*='react-select-11-option-']");

    By allGenreOptions = By.cssSelector("[id*='react-select-12-option-']");
    By allVenueOptions = By.cssSelector("[id*='react-select-13-option-']");

    @FindBy(css = "input[placeholder='Name of the event or headline artist']")
    WebElementFacade titleOfTheEvent;

    /**
     * Fill in Basics of the event form
     *
     * @param eventType
     * @param artist
     * @param genre
     * @param venueName
     */
    public void fillInBasicsForm(String eventType, String artist, String genre, String venueName) {
        basicsForm.waitUntilVisible();

        find(textBox).waitUntilVisible();
        find(textBox).click();
        selectOption(allTypeOptions, eventType);
        Log.info("Entered type of event: " + eventType);

        typeInto(artists, artist);
        selectOption(allArtistOptions, artist);
        Log.info("Entered Artist: " + artist);

        String title = new DataGenerator().getFirstName() + " Live in concert";
        titleOfTheEvent.waitUntilVisible();
        typeInto(titleOfTheEvent, title);
        Serenity.setSessionVariable(EVENT_NAME).to(title);
        Log.info("Entered title of event: " + title);

        waitABit(1000);
        typeInto(genres, genre);
        selectOption(allGenreOptions, genre);
        Log.info("Entered genre: " + genre);

        //click outside to come out of the field
        try {
            basicsForm.click();
        } catch (ElementClickInterceptedException elementClickInterceptedException) {
            clickOn(basicsForm);
        }

        waitABit(1000);
        typeInto(venue, venueName);
        selectOption(allVenueOptions, venueName);
        Serenity.setSessionVariable(EVENT_VENUE).to(venueName);
        Log.info("Entered venue of event: " + venueName);

        Log.info("BASICS FORM FILLED");
    }
}
