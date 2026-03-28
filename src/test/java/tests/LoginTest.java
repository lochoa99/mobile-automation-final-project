package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MenuScreen;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        MenuScreen menuScreen = new MenuScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);
        Faker faker = new Faker();

        String uniqueEmail = faker.internet().emailAddress();
        String password = "SuperPassword123!";

        // Precondición: Crear usuario
        menuScreen.navigateToLogin();
        loginScreen.goToSignUpTab();
        loginScreen.fillSignUpForm(uniqueEmail, password);
        loginScreen.clickSignUpButton();
        Assert.assertTrue(loginScreen.isSignupSuccessful(), "Falló la precondición de registro");
        loginScreen.closePopup();

        // Flujo principal: Login
        loginScreen.goToLoginTab();
        loginScreen.fillLoginForm(uniqueEmail, password);
        loginScreen.clickLoginButton();

        Assert.assertTrue(loginScreen.isLoginSuccessful(), "El mensaje de éxito de login no apareció");
        loginScreen.closePopup();
    }
}