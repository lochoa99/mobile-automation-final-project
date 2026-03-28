package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class SwipeScreen extends BaseScreen {

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

    // TÉCNICA 1: W3C Actions (Uso de Pointers sugerido en clase)
    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.9); // Empezamos en el 90% (borde derecho)
        int endX = (int) (size.width * 0.1);   // Terminamos en el 10% (borde izquierdo)
        int startY = (int) (size.height * 0.5);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, startY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    // TÉCNICA 2: UiScrollable Nativo de Android
    public void scrollToHiddenText() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"You found me!!!\"));"
        ));
    }

    public boolean isHiddenTextDisplayed() {
        return isElementVisible(hiddenText);
    }
}