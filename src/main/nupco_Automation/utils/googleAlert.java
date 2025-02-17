package utils;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class googleAlert {
    /**
     * This method is used to handle GoogleVignette Ads.
     * Note that you must provide a valid locator for the method to work, Target the element that will trigger the GoogleVignette Ads.
     *
     * @param driver
     * @param locatorForAlertTriggerElement
     * @return instance of googleAlert for further chaining usage.
     */
    public static googleAlert dismissAlert(SHAFT.GUI.WebDriver driver, By locatorForAlertTriggerElement) {
        driver.browser().refreshCurrentPage();
        try {
            driver.element().click(locatorForAlertTriggerElement);
        } catch (Throwable throwableVar) {
            //empty (Expected to be caught in case if the Ad didn't get triggered)
            //Must be a throwable (Firefox case)
        }
        return new googleAlert();
    }
}

