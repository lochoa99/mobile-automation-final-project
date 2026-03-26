package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.SwipePage;

public class NavigationTest extends BaseTest {

    @Test
    public void testBottomNavigation() {
        MenuPage menuPage = new MenuPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SwipePage swipePage = new SwipePage(driver);

        // Validar condición inicial: estamos en Home [cite: 18]
        Assert.assertTrue(homePage.isHomePageDisplayed(), "El Home no se mostró correctamente al iniciar");

        // Navegar a Login y validar [cite: 20, 21]
        menuPage.navigateToLogin();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "No se pudo validar la pantalla de Login");

        // Navegar a Swipe y validar [cite: 20, 21]
        menuPage.navigateToSwipe();
        Assert.assertTrue(swipePage.isSwipePageDisplayed(), "No se pudo validar la pantalla de Swipe");

        // Volver a Home y validar [cite: 20, 21]
        menuPage.navigateToHome();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "No se pudo volver al Home");
    }
}