package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    // Este es nuestro "control remoto", lo usaremos para interactuar con la app
    protected AndroidDriver driver;

    // @BeforeMethod le dice a TestNG que ejecute este bloque ANTES de cada prueba
    @BeforeMethod
    public void setUp() throws MalformedURLException {

        // 1. Configuramos las opciones para decirle a Appium qué emulador usar
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554"); // Este es el nombre por defecto de los emuladores en Android Studio
        options.setAutomationName("UiAutomator2");

        // 2. Le decimos dónde está nuestra aplicación (el archivo APK)
        File app = new File("src/test/resources/android.wdio.native.app.v2.2.0.apk");
        options.setApp(app.getAbsolutePath());

        // 3. Inicializamos el control remoto conectándolo al servidor de Appium en nuestra computadora
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // 4. Le damos un tiempo de espera básico por si la app tarda en cargar
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // @AfterMethod le dice a TestNG que ejecute esto DESPUÉS de cada prueba
    @AfterMethod
    public void tearDown() {
        // Cerramos la aplicación para que la siguiente prueba empiece totalmente limpia
        if (driver != null) {
            driver.quit();
        }
    }
}