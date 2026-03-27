package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class SwipeScreen extends BaseScreen {

    // --- Localizadores con Page Factory ---

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    private WebElement swipeScreenTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You found me!!!\")")
    private WebElement hiddenText;

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isSwipeScreenDisplayed() {
        return isElementVisible(swipeScreenTitle);
    }

    // --- TÉCNICA 1: W3C Actions (Swipe Horizontal) ---
    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        // Empezamos muy a la derecha (90% de la pantalla)
        int startX = (int) (size.width * 0.9);
        // Terminamos muy a la izquierda (10% de la pantalla)
        int endX = (int) (size.width * 0.1);
        int startY = (int) (size.height * 0.5);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        // Reducimos a 500ms para simular un "Fling" rápido y evitar el efecto liga
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, startY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    // --- TÉCNICA 2: UiScrollable Nativo (Scroll Vertical) ---
    public void scrollToHiddenText() {
        // Este localizador es especial porque ejecuta una acción de scroll a nivel de Android
        driver.findElement(io.appium.java_client.AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"You found me!!!\"));"
        ));
    }

    public boolean isHiddenTextDisplayed() {
        return isElementVisible(hiddenText);
    }
}