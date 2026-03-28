package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.MenuScreen;
import screens.SwipeScreen;

public class NavigationTest extends BaseTest {

    @Test
    public void testBottomNavigation() {
        MenuScreen menuScreen = new MenuScreen(driver);
        HomeScreen homeScreen = new HomeScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);
        SwipeScreen swipeScreen = new SwipeScreen(driver);

        // 1. Verificamos que iniciamos en Home
        Assert.assertTrue(homeScreen.isHomeScreenDisplayed(), "La pantalla Home no cargó correctamente");

        // 2. Navegamos a Login
        menuScreen.navigateToLogin();
        // ¡Ya actualizamos el nombre a isLoginScreenDisplayed!
        Assert.assertTrue(loginScreen.isLoginScreenDisplayed(), "La pantalla Login no cargó");

        // 3. Naveamos a Swipe
        menuScreen.navigateToSwipe();
        Assert.assertTrue(swipeScreen.isSwipeScreenDisplayed(), "La pantalla Swipe no cargó");

        // 4. Volvemos a Home
        menuScreen.navigateToHome();
        Assert.assertTrue(homeScreen.isHomeScreenDisplayed(), "No se pudo volver a la pantalla Home");
    }
}