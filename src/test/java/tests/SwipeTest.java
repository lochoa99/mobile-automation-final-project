package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.MenuScreen;
import screens.SwipeScreen;

public class SwipeTest extends BaseTest {

    @Test
    public void testSwipeAndScroll() {
        MenuScreen menuPage = new MenuScreen(driver);
        SwipeScreen swipePage = new SwipeScreen(driver);

        // Paso 1: Navegar a la sección Swipe
        menuPage.navigateToSwipe();
        Assert.assertTrue(swipePage.isSwipeScreenDisplayed(), "No estamos en la pantalla de Swipe");

        // Paso 2: Deslizar horizontalmente las tarjetas (lo hacemos 2 veces para que se note)
        swipePage.swipeLeft();
        swipePage.swipeLeft();

        // Paso 3: Hacer scroll hacia abajo dinámicamente hasta encontrar el texto oculto
        swipePage.scrollToHiddenText();

        // Paso 4: Verificar que el texto está visible
        Assert.assertTrue(swipePage.isHiddenTextDisplayed(), "No se encontró el texto oculto 'You found me!!!'");
    }
}