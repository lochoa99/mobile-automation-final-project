package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Localizamos la pestaña superior de Login
    private final By loginScreenTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"Login / Sign up Form\")");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isLoginPageDisplayed() {
        return isElementVisible(loginScreenTitle);
    }
}