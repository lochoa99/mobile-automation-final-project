package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.MenuScreen;
import screens.SwipeScreen;

public class SwipeTest extends BaseTest {

    @Test
    public void testSwipeAndScroll() {
        MenuScreen menuScreen = new MenuScreen(driver);
        SwipeScreen swipeScreen = new SwipeScreen(driver);

        menuScreen.navigateToSwipe();
        Assert.assertTrue(swipeScreen.isSwipeScreenDisplayed(), "No estamos en la pantalla de Swipe");

        // Swipe horizontal
        swipeScreen.swipeLeft();

        // Scroll vertical buscando el elemento oculto
        swipeScreen.scrollToHiddenText();

        Assert.assertTrue(swipeScreen.isHiddenTextDisplayed(), "No se encontró el texto oculto");
    }
}