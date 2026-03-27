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

        // Usamos Soft Assertion como se definió en la academia [cite: 84, 90]
        SoftAssert softAssert = new SoftAssert();

        // 1. Navegamos al login
        menuScreen.navigateToLogin();
        loginScreen.goToLoginTab();

        // 2. Intentamos loguearnos con datos incorrectos
        loginScreen.fillLoginForm("correoMalFormateado", "Clave123");
        loginScreen.clickLoginButton();

        // 3. Validamos que el error aparezca (Si falla, el test continúa gracias al SoftAssert)
        softAssert.assertTrue(loginScreen.isEmailErrorDisplayed(), "El mensaje de error de email no se mostró");

        // 4. Validamos que el popup de éxito NO haya salido
        softAssert.assertFalse(loginScreen.isLoginSuccessful(), "El login no debió ser exitoso");

        // 5. Consolidamos los resultados. Si alguna falló arriba, aquí explotará el test
        softAssert.assertAll();
    }
}