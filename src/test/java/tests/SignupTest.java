package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MenuScreen;

public class SignupTest extends BaseTest {

    @Test
    public void testSuccessfulSignUp() {
        MenuScreen menuPage = new MenuScreen(driver);
        LoginScreen loginPage = new LoginScreen(driver);

        // Inicializamos Faker para generar un email aleatorio cada vez que corra la prueba
        Faker faker = new Faker();
        String randomEmail = faker.internet().emailAddress();
        String password = "Password123!";

        // Paso 1: Ir a la sección de Login desde el menú inferior
        menuPage.navigateToLogin();

        // Paso 2: Cambiar a la pestaña de Sign Up [cite: 27]
        loginPage.goToSignUpTab();

        // Paso 3: Llenar el formulario con los datos generados [cite: 28]
        loginPage.fillSignUpForm(randomEmail, password);

        // Paso 4: Hacer clic en el botón de registrarse
        loginPage.clickSignUpButton();

        // Paso 5: Verificar que el proceso fue exitoso validando el popup [cite: 29]
        Assert.assertTrue(loginPage.isSignupSuccessful(), "El mensaje de éxito de registro no apareció");

        // Paso 6: Cerramos el popup dando clic en OK
        loginPage.closePopup();
    }
}