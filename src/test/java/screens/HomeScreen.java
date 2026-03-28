package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    // Validamos que el home cargue correctamente
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"WEBDRIVER\")")
    private WebElement homeScreenTitle;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isHomeScreenDisplayed() {
        return isElementVisible(homeScreenTitle);
    }
}