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
        MenuScreen menuPage = new MenuScreen(driver);
        HomeScreen homePage = new HomeScreen(driver);
        LoginScreen loginPage = new LoginScreen(driver);
        SwipeScreen swipePage = new SwipeScreen(driver);

        // Validar condición inicial: estamos en Home [cite: 18]
        Assert.assertTrue(homePage.isHomePageDisplayed(), "El Home no se mostró correctamente al iniciar");

        // Navegar a Login y validar [cite: 20, 21]
        menuPage.navigateToLogin();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "No se pudo validar la pantalla de Login");

        // Navegar a Swipe y validar [cite: 20, 21]
        menuPage.navigateToSwipe();
        Assert.assertTrue(swipePage.isSwipeScreenDisplayed(), "No se pudo validar la pantalla de Swipe");

        // Volver a Home y validar [cite: 20, 21]
        menuPage.navigateToHome();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "No se pudo volver al Home");
    }
}