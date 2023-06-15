package webstore.components;

import log.Log;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CommonComponents extends PageObject {
    @FindBy(className = "gDmVIE")
    protected WebElementFacade dashboard;
    EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    By textBox = By.className("kbWUSc");
    protected By buttons = By.className("-preset-primary-outline");
    By descriptionField = By.className("public-DraftEditor-content");
    By onSaleDate = By.name("onSaleDate");
    By offSaleDate = By.name("offSaleDate");
    By announcementDate = By.name("announceDate");

    public void selectOption(By by, String option) {
        for (WebElementFacade webElementFacade : findAll(by)) {
            if (webElementFacade.getText().trim().contains(option.trim())) {
                try {
                    webElementFacade.waitUntilVisible();
                    webElementFacade.click();
                    waitABit(1000);
                } catch (ElementClickInterceptedException elementClickInterceptedException) {
                    clickOn(webElementFacade);
                } catch (StaleElementReferenceException staleElementReferenceException) {
                    Log.info("Stale element exception encountered as element already clicked");
                }
                break;
            }
        }

    }

    public void clickOn(WebElement webElement) {
        try {
            evaluateJavascript("arguments[0].scrollIntoView(true);", webElement);
            evaluateJavascript("arguments[0].click();", webElement);
        } catch (TimeoutException toe) {
            if (!webElement.isDisplayed()) {
                waitFor(webElement).waitUntilVisible();

                //retry
                evaluateJavascript("arguments[0].scrollIntoView(true);", webElement);
                evaluateJavascript("arguments[0].click();", webElement);
            } else if (!webElement.isEnabled()) {
                waitFor(webElement).waitUntilEnabled();

                //retry
                evaluateJavascript("arguments[0].scrollIntoView(true);", webElement);
                evaluateJavascript("arguments[0].click();", webElement);
            }
        } catch (SerenityManagedException sme) {
            if (sme.getMessage().contains("Session not started")) {
                sme.printStackTrace();
            }
        } catch (WebDriverException wde) {
            if (wde.getMessage().contains("Session not started")) {
                wde.printStackTrace();
            } else {
                //retry
                evaluateJavascript("arguments[0].scrollIntoView(true);", webElement);
                webElement.click();
            }
        }
    }

    public void setFieldText(WebElementFacade webElementFacade, String text) {
        webElementFacade.waitUntilVisible();
        webElementFacade.clear();
        webElementFacade.waitUntilEnabled();
        typeInto(webElementFacade, text);
    }
}
