package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() {
        try {
            // Set up the exact same capabilities used in the Appium Inspector
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setDeviceName("emulator-5554")
                    .setAppPackage("com.wdiodemoapp")
                    .setAppActivity(".MainActivity") // Forma resumida de la actividad
                    .setAutoGrantPermissions(true);  // Excelente práctica para evitar popups

            URL url = new URL("http://127.0.0.1:4723");

            // Inicializando el AndroidDriver con las capacidades del Inspector
            driver = new AndroidDriver(url, options);

            // Wait implícito establecido en segundos como se vio en clase
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } catch (Exception e) {
            throw new RuntimeException("Error al iniciar la sesión de Appium: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}