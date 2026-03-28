package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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
        // Estrategia de Explicit Wait solicitada en clase (10 segundos)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Inicialización de PageFactory usando el decorador de Appium
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Manejo robusto de excepciones con Try-Catch para NoSuchElementException
    protected boolean isElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Elemento no visible en el tiempo esperado: " + e.getMessage());
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