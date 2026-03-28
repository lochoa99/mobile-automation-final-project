package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import screens.LoginScreen;
import screens.MenuScreen;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void testInvalidLoginShowsError() {
        MenuScreen menuScreen = new MenuScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);

        // Implementación de Soft Assertion discutida en clase
        SoftAssert softAssert = new SoftAssert();

        menuScreen.navigateToLogin();
        loginScreen.goToLoginTab();

        // Intento de login con formato de email inválido
        loginScreen.fillLoginForm("invalid_email", "Pass123!");
        loginScreen.clickLoginButton();

        // 1. Validamos que muestre el error (Soft Assert permite seguir ejecutando aunque falle)
        softAssert.assertTrue(loginScreen.isEmailErrorDisplayed(), "El mensaje de error no se mostró");

        // 2. Validamos que el popup de éxito NO se dispare
        softAssert.assertFalse(loginScreen.isLoginSuccessful(), "El login no debió ser exitoso");

        // Consolidamos resultados (Aquí explotará si alguna validación previa falló)
        softAssert.assertAll();
    }
}