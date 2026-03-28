package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MenuScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Home")
    private WebElement homeMenuButton;

    @AndroidFindBy(accessibility = "Login")
    private WebElement loginMenuButton;

    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipeMenuButton;

    public MenuScreen(AndroidDriver driver) {
        super(driver);
    }

    public void navigateToHome() {
        click(homeMenuButton);
    }

    public void navigateToLogin() {
        click(loginMenuButton);
    }

    public void navigateToSwipe() {
        click(swipeMenuButton);
    }
}