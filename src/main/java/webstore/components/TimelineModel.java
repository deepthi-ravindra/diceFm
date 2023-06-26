package webstore.components;

import log.Log;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeInvisibleException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utility.Utilities;

import static sessionVariables.SessionVariables.EVENT_DATE;

public class TimelineModel extends CommonComponents {

    @FindBy(css = "[data-id='wizardStep[timeline]']")
    WebElementFacade timelinesForm;

    By dateErrorMessage = By.className("FormGroup__FormGroupError-sc-5g86qj-4");

    @FindBy(className = "DateTimePicker__StyledPickerContainer-sc-1jdcxrv-1")
    WebElementFacade datePickerModal;
    @FindBy(css = "input[name='date']")
    WebElementFacade eventStartDate;

    @FindBy(css = "input[name='endDate']")
    WebElementFacade eventEndDate;
    @FindBy(name = "lineup[0].details")
    WebElementFacade lineupDetails;
    By allTimezoneOptions = By.cssSelector("[id*='react-select-14-option-']");
    String dateSetter = "react-datepicker__day--0";
    By selectedDate = By.className("react-datepicker__day--selected");

    By textBox = By.className("kbWUSc");

    /**
     * Fill in timeline form - details of event dates
     *
     * @param timezone
     */
    public void fillInTimelineForm(String timezone) {
        timelinesForm.waitUntilVisible();

        findAll(textBox).get(1).waitUntilVisible();
        clickOn(findAll(textBox).get(1));
        selectOption(allTimezoneOptions, timezone);

        waitABit(1000);
        new Actions(getDriver()).click(timelinesForm).perform();
        find(announcementDate).waitUntilVisible();
        typeInto(find(announcementDate), Utilities.getDateInFormat(Utilities.datesToModify(-4)));
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(-4)))).click();
        try {
            datePickerModal.waitUntilNotVisible();
        } catch (ElementShouldBeInvisibleException elementShouldBeInvisibleException) {
            new Actions(getDriver()).click(timelinesForm).perform();
        }
        Log.info("Entered announcement date " + Utilities.getDateInFormat(Utilities.datesToModify(-4)));
        waitABit(1000);


        eventStartDate.waitUntilVisible();
        String startDate = Utilities.getDateInFormat(Utilities.datesToModify(3));
        new Actions(getDriver()).sendKeys(eventStartDate, Keys.BACK_SPACE).sendKeys(eventStartDate, Keys.BACK_SPACE).sendKeys(eventStartDate, Keys.BACK_SPACE).sendKeys(eventStartDate, Keys.BACK_SPACE).sendKeys(eventStartDate, Keys.BACK_SPACE).sendKeys(eventStartDate, Keys.BACK_SPACE).perform();

        typeInto(eventStartDate, startDate);
        try {
            waitABit(1000);
            datePickerModal.waitUntilNotVisible();
        } catch (ElementShouldBeInvisibleException elementShouldBeInvisibleException) {
            new Actions(getDriver()).click(timelinesForm).perform();
        }
        Log.info("Entered event start date " + startDate);

        waitABit(1000);
        WebElementFacade onsaledate = find(onSaleDate);
        find(onSaleDate).waitUntilVisible();

        new Actions(getDriver()).sendKeys(onsaledate, Keys.BACK_SPACE).sendKeys(onsaledate, Keys.BACK_SPACE).sendKeys(onsaledate, Keys.BACK_SPACE).sendKeys(onsaledate, Keys.BACK_SPACE).sendKeys(onsaledate, Keys.BACK_SPACE).sendKeys(onsaledate, Keys.BACK_SPACE).perform();
        String onSaleDay = Utilities.getDateInFormat(Utilities.datesToModify(-1));
        typeInto(find(onSaleDate), onSaleDay);
        waitABit(2000);

        //Added extra clicks as this field is a bit flaky and this is to make sure the date is clicked
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(-1)))).click();
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(-1)))).click();
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(-1)))).click();
        waitABit(2000);
        new Actions(getDriver()).click(timelinesForm).perform();
        new Actions(getDriver()).click(timelinesForm).perform();
        new Actions(getDriver()).click(timelinesForm).perform();
        new Actions(getDriver()).click(timelinesForm).perform();
        new Actions(getDriver()).click(timelinesForm).perform();
        waitABit(1000);
        clickOn(timelinesForm);
        try {
            waitABit(1000);
            datePickerModal.waitUntilNotVisible();
        } catch (ElementShouldBeInvisibleException elementShouldBeInvisibleException) {
            new Actions(getDriver()).click(timelinesForm).perform();
        }
        Log.info("Entered event on sale date " + onSaleDay);

        waitABit(1000);
        find(offSaleDate).waitUntilVisible();
        typeInto(find(offSaleDate), Utilities.getDateInFormat(Utilities.datesToModify(7)));
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(7)))).click();
        clickOn(timelinesForm);
        try {
            datePickerModal.waitUntilNotVisible();
        } catch (ElementShouldBeInvisibleException elementShouldBeInvisibleException) {
            new Actions(getDriver()).click(timelinesForm).perform();
        }
        Log.info("Entered event off sale date " + Utilities.getDateInFormat(Utilities.datesToModify(7)));

        waitABit(1000);
        eventEndDate.waitUntilVisible();
        String endDate = Utilities.getDateInFormat(Utilities.datesToModify(10));
        new Actions(getDriver()).sendKeys(eventEndDate, Keys.BACK_SPACE).sendKeys(eventEndDate, Keys.BACK_SPACE).sendKeys(eventEndDate, Keys.BACK_SPACE).sendKeys(eventEndDate, Keys.BACK_SPACE).sendKeys(eventEndDate, Keys.BACK_SPACE).perform();
        typeInto(eventEndDate, endDate);
        waitABit(2000);
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(10)))).click();
        try {
            datePickerModal.waitUntilNotVisible();
        } catch (ElementShouldBeInvisibleException elementShouldBeInvisibleException) {
            new Actions(getDriver()).click(timelinesForm).perform();
        }
        Log.info("Entered event end sale date " + Utilities.getDateInFormat(Utilities.datesToModify(8)));

        //Save for future verifications
        String finalEventDate = Utilities.getDateInSimpleFormat(Utilities.datesToModify(3)) + " - " + Utilities.getDateInSimpleFormat(Utilities.datesToModify(10));
        Serenity.setSessionVariable(EVENT_DATE).to(finalEventDate);
        Log.info("TIMELINE FORM FILLED");
    }

    /**
     * Fill in timeline form with incorrect values and verify error message is displayed
     *
     * @param timezone
     */
    public void fillInTimelineFormWithIncorrectValues(String timezone) {
        timelinesForm.waitUntilVisible();

        findAll(textBox).get(1).waitUntilVisible();
        clickOn(findAll(textBox).get(1));
        selectOption(allTimezoneOptions, timezone);

        waitABit(1000);
        new Actions(getDriver()).click(timelinesForm).perform();
        find(announcementDate).waitUntilVisible();

        //ENTER ANNOUNCEMENT DATE AFTER ON SALE DATE
        typeInto(find(announcementDate), Utilities.getDateInFormat(Utilities.datesToModify(4)));
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(4)))).click();
        try {
            datePickerModal.waitUntilNotVisible();
        } catch (ElementShouldBeInvisibleException elementShouldBeInvisibleException) {
            new Actions(getDriver()).click(timelinesForm).perform();
        }
        Log.info("Entered announcement date " + Utilities.getDateInFormat(Utilities.datesToModify(-4)));
        waitABit(1000);


        //ENTER EVENT START DATE AFTER END DATE
        eventStartDate.waitUntilVisible();
        String startDate = Utilities.getDateInFormat(Utilities.datesToModify(3));
        typeInto(eventStartDate, startDate);
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(3)))).click();
        try {
            datePickerModal.waitUntilNotVisible();
        } catch (ElementShouldBeInvisibleException elementShouldBeInvisibleException) {
            find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(3)))).click();
            new Actions(getDriver()).click(timelinesForm).perform();
        }
        Log.info("Entered event start date " + startDate);

        waitABit(1000);
        find(onSaleDate).waitUntilVisible();
        String onSaleDay = Utilities.getDateInFormat(Utilities.datesToModify(-1));
        typeInto(find(onSaleDate), onSaleDay);
        waitABit(2000);

        //Added extra clicks as this field is a bit flaky and this is to make sure the date is clicked
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(-1)))).click();
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(-1)))).click();
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(-1)))).click();
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(-1)))).click();
        new Actions(getDriver()).click(timelinesForm).perform();
        new Actions(getDriver()).click(timelinesForm).perform();
        waitABit(1000);
        clickOn(timelinesForm);
        try {
            waitABit(1000);
            datePickerModal.waitUntilNotVisible();
        } catch (ElementShouldBeInvisibleException elementShouldBeInvisibleException) {
            find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(-1)))).click();
            new Actions(getDriver()).click(timelinesForm).perform();
        }
        Log.info("Entered event on sale date " + onSaleDay);

        waitABit(1000);
        find(offSaleDate).waitUntilVisible();
        typeInto(find(offSaleDate), Utilities.getDateInFormat(Utilities.datesToModify(7)));
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(7)))).click();
        clickOn(timelinesForm);
        try {
            datePickerModal.waitUntilNotVisible();
        } catch (ElementShouldBeInvisibleException elementShouldBeInvisibleException) {
            new Actions(getDriver()).click(timelinesForm).perform();
        }
        Log.info("Entered event off sale date " + Utilities.getDateInFormat(Utilities.datesToModify(7)));

        waitABit(1000);
        eventEndDate.waitUntilVisible();
        String endDate = Utilities.getDateInFormat(Utilities.datesToModify(2));
        typeInto(eventEndDate, endDate);
        find(By.className(dateSetter + Utilities.getDate(Utilities.datesToModify(2)))).click();
        try {
            datePickerModal.waitUntilNotVisible();
        } catch (ElementShouldBeInvisibleException elementShouldBeInvisibleException) {
            new Actions(getDriver()).click(timelinesForm).perform();
        }
        Log.info("Entered event end sale date " + Utilities.getDateInFormat(Utilities.datesToModify(8)));
    }

    /**
     * Returns error message
     *
     * @return error message
     */
    public String getErrorMessage(int errorMessageNumber) {
        return findAll(dateErrorMessage).get(errorMessageNumber).getText();
    }
}
