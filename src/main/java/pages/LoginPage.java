package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By loginScreenTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"Login / Sign up Form\")");

    private final By signUpTab = AppiumBy.accessibilityId("button-sign-up-container");
    private final By loginTab = AppiumBy.accessibilityId("button-login-container");

    private final By emailInput = AppiumBy.accessibilityId("input-email");
    private final By passwordInput = AppiumBy.accessibilityId("input-password");
    private final By confirmPasswordInput = AppiumBy.accessibilityId("input-repeat-password");

    private final By signUpButton = AppiumBy.accessibilityId("button-SIGN UP");
    private final By loginButton = AppiumBy.accessibilityId("button-LOGIN");

    // Popups nativos
    private final By signupSuccessTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"Signed Up!\")");
    private final By loginSuccessTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"Success\")");
    private final By okButtonPopup = AppiumBy.androidUIAutomator("new UiSelector().text(\"OK\")");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isLoginPageDisplayed() {
        return isElementVisible(loginScreenTitle);
    }

    public void goToSignUpTab() {
        click(signUpTab);
    }

    public void goToLoginTab() {
        click(loginTab);
    }

    public void fillSignUpForm(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        type(confirmPasswordInput, password);
    }

    // Nuevo método para llenar solo el login
    public void fillLoginForm(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
    }

    public void clickSignUpButton() {
        click(signUpButton);
    }

    // Nuevo método para hacer clic en Login
    public void clickLoginButton() {
        click(loginButton);
    }

    public boolean isSignupSuccessful() {
        return isElementVisible(signupSuccessTitle);
    }

    // Nuevo método para verificar el popup de Login exitoso
    public boolean isLoginSuccessful() {
        return isElementVisible(loginSuccessTitle);
    }

    public void closePopup() {
        click(okButtonPopup);
    }
}