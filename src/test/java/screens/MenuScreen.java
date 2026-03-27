package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MenuScreen extends BaseScreen {

    // Localizadores del menú inferior
    private final By homeMenuButton = AppiumBy.accessibilityId("Home"); // ¡Agregamos el botón Home!
    private final By loginMenuButton = AppiumBy.accessibilityId("Login");
    private final By swipeMenuButton = AppiumBy.accessibilityId("Swipe");

    public MenuScreen(AndroidDriver driver) {
        super(driver);
    }

    // Métodos de navegación
    public void navigateToHome() {
        click(homeMenuButton);
    }

    public void navigateToLogin() {
        click(loginMenuButton);
    }

    public void navigateToSwipe() {
        click(swipeMenuButton);
    }
}