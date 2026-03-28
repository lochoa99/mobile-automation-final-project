package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MenuScreen;

public class SignupTest extends BaseTest {

    @Test
    public void testSuccessfulSignUp() {
        MenuScreen menuScreen = new MenuScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);
        Faker faker = new Faker();

        // Generación dinámica de email para garantizar idempotencia
        String randomEmail = faker.internet().emailAddress();
        String password = "Password123!";

        menuScreen.navigateToLogin();
        loginScreen.goToSignUpTab();

        loginScreen.fillSignUpForm(randomEmail, password);
        loginScreen.clickSignUpButton();

        Assert.assertTrue(loginScreen.isSignupSuccessful(), "El mensaje de éxito de registro no apareció");
        loginScreen.closePopup();
    }
}