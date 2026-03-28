package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {

    // --- Localizadores con Page Factory ---

    // ¡Aquí está el localizador nuevo que faltaba!
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login / Sign up Form\")")
    private WebElement loginScreenTitle;

    @AndroidFindBy(accessibility = "button-sign-up-container")
    private WebElement signUpTab;

    @AndroidFindBy(accessibility = "button-login-container")
    private WebElement loginTab;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInput;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement confirmPasswordInput;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement signUpButton;

    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginButton;

    // Elementos nativos (Popups y Alertas)
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Signed Up!\")")
    private WebElement signupSuccessTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Success\")")
    private WebElement loginSuccessTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please enter a valid email address\")")
    private WebElement emailErrorMessage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")
    private WebElement okButtonPopup;

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    // --- Métodos de Acción ---

    // ¡Aquí está el método nuevo para el NavigationTest!
    public boolean isLoginScreenDisplayed() {
        return isElementVisible(loginScreenTitle);
    }

    public void goToSignUpTab() { click(signUpTab); }

    public void goToLoginTab() { click(loginTab); }

    public void fillSignUpForm(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        type(confirmPasswordInput, password);
    }

    public void fillLoginForm(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
    }

    public void clickSignUpButton() { click(signUpButton); }

    public void clickLoginButton() { click(loginButton); }

    public boolean isSignupSuccessful() { return isElementVisible(signupSuccessTitle); }

    public boolean isLoginSuccessful() { return isElementVisible(loginSuccessTitle); }

    public boolean isEmailErrorDisplayed() { return isElementVisible(emailErrorMessage); }

    public void closePopup() { click(okButtonPopup); }
}