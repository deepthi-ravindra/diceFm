package webstore.components;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public void fillInBasicsForm(String eventType, String artist, String title, String genre, String venueName) {
        basicsForm.waitUntilVisible();

        find(textBox).waitUntilVisible();
        find(textBox).click();
        selectOption(allTypeOptions, eventType);

        typeInto(artists, artist);
        selectOption(allArtistOptions, artist);

        titleOfTheEvent.waitUntilVisible();
        typeInto(titleOfTheEvent, title);

        waitABit(1000);
        typeInto(genres, genre);
        selectOption(allGenreOptions, genre);
        try {
            basicsForm.click();
        }catch(ElementClickInterceptedException elementClickInterceptedException) {
            clickOn(basicsForm);
        }

        waitABit(1000);
        typeInto(venue, venueName);
        selectOption(allVenueOptions, venueName);
    }
}
