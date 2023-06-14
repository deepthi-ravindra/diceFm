package webstore.components;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utility.Utilities;

public class TimelineModel extends CommonComponents{

    @FindBy(css = "[data-id='wizardStep[timeline]']")
    WebElementFacade timelinesForm;


    @FindBy(name = "date")
    WebElementFacade eventStartDate;

    @FindBy(name = "endDate")
    WebElementFacade eventEndDate;
    @FindBy(name = "lineup[0].time")
    WebElementFacade linupTime;
    By allTimezoneOptions = By.cssSelector("[id*='react-select-14-option-']");
    String endDateSetter = "react-datepicker__day--0";

    By textBox = By.className("kbWUSc");

    public void fillInTimelineForm(String timezone) {
        timelinesForm.waitUntilVisible();

        findAll(textBox).get(1).waitUntilVisible();
        clickOn(findAll(textBox).get(1));
        selectOption(allTimezoneOptions, timezone);

        waitABit(1000);
        new Actions(getDriver()).click(timelinesForm).perform();
        find(announcementDate).waitUntilVisible();
        typeInto(find(announcementDate), Utilities.getDateInFormat(Utilities.datesToModify(-3)));
        new Actions(getDriver()).click(timelinesForm).perform();
        new Actions(getDriver()).click(timelinesForm).perform();
        waitABit(1500);

        find(onSaleDate).waitUntilVisible();
        typeInto(find(onSaleDate), Utilities.getDateInFormat(Utilities.datesToModify(-2)));
        new Actions(getDriver()).click(timelinesForm).perform();
        new Actions(getDriver()).click(timelinesForm).perform();
        waitABit(1000);

        find(offSaleDate).waitUntilVisible();
        typeInto(find(offSaleDate), Utilities.getDateInFormat(Utilities.datesToModify(5)));
        new Actions(getDriver()).click(timelinesForm).perform();
        new Actions(getDriver()).click(timelinesForm).perform();
        waitABit(1000);

        eventStartDate.waitUntilVisible();
        typeInto(eventStartDate, Utilities.getDateInFormat(Utilities.datesToModify(1)));
        new Actions(getDriver()).click(timelinesForm).perform();
        new Actions(getDriver()).click(timelinesForm).perform();
        waitABit(1000);

        eventEndDate.waitUntilVisible();
        typeInto(eventEndDate, Utilities.getDateInFormat(Utilities.datesToModify(6)));
        find(By.className(endDateSetter+Utilities.getDate(Utilities.datesToModify(6)))).click();
        new Actions(getDriver()).click(timelinesForm).perform();
        new Actions(getDriver()).click(timelinesForm).perform();
    }
}
