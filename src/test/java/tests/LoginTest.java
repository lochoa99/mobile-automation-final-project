package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MenuScreen;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        MenuScreen menuPage = new MenuScreen(driver);
        LoginScreen loginPage = new LoginScreen(driver);
        Faker faker = new Faker();

        // 1. Generamos credenciales únicas que usaremos para TODO el flujo
        String uniqueEmail = faker.internet().emailAddress();
        String password = "SuperPassword123!";

        // --- FASE DE PRECONDICIÓN: Crear el usuario ---
        menuPage.navigateToLogin();
        loginPage.goToSignUpTab();
        loginPage.fillSignUpForm(uniqueEmail, password);
        loginPage.clickSignUpButton();

        // Esperamos que el registro sea exitoso y cerramos el popup
        Assert.assertTrue(loginPage.isSignupSuccessful(), "Falló la precondición de registro");
        loginPage.closePopup();

        // --- FASE DE PRUEBA: Login Exitoso ---
        // 2. Volvemos a la pestaña de Login
        loginPage.goToLoginTab();

        // 3. Llenamos el formulario con las MISMAS credenciales que acabamos de crear [cite: 33, 35]
        loginPage.fillLoginForm(uniqueEmail, password);

        // 4. Hacemos clic en el botón de Login
        loginPage.clickLoginButton();

        // 5. Verificamos que aparezca el popup de "Success" [cite: 36]
        Assert.assertTrue(loginPage.isLoginSuccessful(), "El mensaje de éxito de login no apareció");

        // Dejamos limpio cerrando el popup
        loginPage.closePopup();
    }
}