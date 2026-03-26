package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SwipePage extends BasePage {

    // Localizamos el título de la sección Swipe
    private final By swipeScreenTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"Swipe horizontal\")");

    public SwipePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isSwipePageDisplayed() {
        return isElementVisible(swipeScreenTitle);
    }
}