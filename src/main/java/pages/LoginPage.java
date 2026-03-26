package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // --- Localizadores ---
    private final By loginScreenTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"Login / Sign up Form\")");

    // Pestañas superiores
    private final By signUpTab = AppiumBy.accessibilityId("button-sign-up-container");
    private final By loginTab = AppiumBy.accessibilityId("button-login-container");

    // Campos del formulario (se usan tanto en login como en signup)
    private final By emailInput = AppiumBy.accessibilityId("input-email");
    private final By passwordInput = AppiumBy.accessibilityId("input-password");
    private final By confirmPasswordInput = AppiumBy.accessibilityId("input-repeat-password");

    // Botones de acción
    private final By signUpButton = AppiumBy.accessibilityId("button-SIGN UP");
    private final By loginButton = AppiumBy.accessibilityId("button-LOGIN");

    // Mensaje de éxito (Actualizado para buscar los textos nativos del popup)
    private final By successMessageTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"Signed Up!\")");
    private final By okButtonPopup = AppiumBy.androidUIAutomator("new UiSelector().text(\"OK\")");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    // --- Métodos de Acción ---

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

    public void clickSignUpButton() {
        click(signUpButton);
    }

    // Devuelve verdadero si aparece el popup de "Signed Up!"
    public boolean isSignupSuccessful() {
        return isElementVisible(successMessageTitle);
    }

    public void closeSuccessPopup() {
        click(okButtonPopup);
    }
}