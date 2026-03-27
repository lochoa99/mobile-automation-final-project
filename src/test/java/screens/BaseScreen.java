package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        // Se implementa WebDriverWait como se discutió en clase para manejar la visibilidad
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Inicialización del driver y localización de elementos usando Page Factory
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Manejo de excepciones con Try-Catch para NoSuchElementException
    // Validando con visibilityOf dentro de ExpectedConditions [cite: 94, 154]
    protected boolean isElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            System.out.println("Elemento no encontrado: " + e.getMessage());
            return false;
        }
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }
}