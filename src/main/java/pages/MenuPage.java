package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {

    private final By homeIcon = AppiumBy.accessibilityId("Home");
    private final By loginIcon = AppiumBy.accessibilityId("Login");
    private final By swipeIcon = AppiumBy.accessibilityId("Swipe");

    public MenuPage(AndroidDriver driver) {
        super(driver);
    }

    public void navigateToHome() {
        click(homeIcon);
    }

    public void navigateToLogin() {
        click(loginIcon);
    }

    public void navigateToSwipe() {
        click(swipeIcon);
    }
}