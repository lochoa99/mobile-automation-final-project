package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    // Localizamos el título principal del Home
    private final By homeTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"WEBDRIVER\")");

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isHomePageDisplayed() {
        return isElementVisible(homeTitle);
    }
}