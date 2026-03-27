package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class SwipePage extends BasePage {

    private final By swipeScreenTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"Swipe horizontal\")");
    private final By hiddenText = AppiumBy.androidUIAutomator("new UiSelector().text(\"You found me!!!\")");

    public SwipePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isSwipeScreenDisplayed() {
        return isElementVisible(swipeScreenTitle);
    }

    // --- TÉCNICA 1: W3C Actions (Swipe Horizontal) ---
    // Simula un dedo que toca el lado derecho de la pantalla y arrastra hacia el izquierdo
    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.8); // Empieza en el 80% del ancho (derecha)
        int endX = (int) (size.width * 0.2);   // Termina en el 20% del ancho (izquierda)
        int startY = (int) (size.height * 0.5); // A la mitad de la altura de la pantalla

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        // 1. Mover el dedo a la posición inicial
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        // 2. Tocar la pantalla
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        // 3. Arrastrar el dedo hasta la posición final en 1 segundo (1000 ms)
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, startY));
        // 4. Levantar el dedo
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    // --- TÉCNICA 2: UiScrollable Nativo (Scroll Vertical) ---
    // Le dice a Android: "Desliza hacia abajo mágicamente hasta que veas este texto"
    public void scrollToHiddenText() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"You found me!!!\"));"
        ));
    }

    public boolean isHiddenTextDisplayed() {
        return isElementVisible(hiddenText);
    }
}