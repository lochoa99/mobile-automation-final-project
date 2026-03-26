package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    // Este es el constructor. Se ejecuta cada vez que abrimos una pantalla nueva.
    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        // Definimos una espera explícita de máximo 10 segundos
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Método reutilizable para esperar a que un elemento sea visible en pantalla
    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Método reutilizable para hacer clic (primero espera a que se vea, luego hace clic)
    protected void click(By locator) {
        waitForVisibility(locator).click();
    }

    // Método reutilizable para escribir texto en un campo
    protected void type(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear(); // Limpiamos el campo por si tenía texto antes
        element.sendKeys(text); // Escribimos el texto nuevo
    }

    // Método para verificar si un elemento está visible (devuelve verdadero o falso)
    protected boolean isElementVisible(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false; // Si pasan los 10 segundos y no lo encuentra, devuelve falso
        }
    }
}