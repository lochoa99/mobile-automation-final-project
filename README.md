# 🚀 Mobile Automation Final Project

Un proyecto de automatización de pruebas para aplicaciones móviles Android utilizando **Appium**, **Selenium** y **TestNG**. Implementa el patrón **Page Object Model** para mantener un código mantenible y escalable.

**Desarrollado por:** LUIS MATEO OCHOA AGUDELO

---

## 📋 Descripción

Este proyecto automatiza pruebas de regresión para aplicaciones móviles Android, cubriendo escenarios de:
- ✅ **Login**: Validación de credenciales y autenticación
- ✅ **Login Inválido**: Pruebas de casos de error y validación de mensajes
- ✅ **Signup**: Registro de nuevos usuarios
- ✅ **Navegación**: Flujos de navegación en la aplicación
- ✅ **Interacciones**: Gestos como swipe en la aplicación

---

## 🛠️ Stack Tecnológico

| Tecnología | Versión | Descripción |
|-----------|---------|------------|
| **Java JDK** | 17 | Amazon Corretto / OpenJDK |
| **Appium Java Client** | 8.6.0 | Cliente para automatización móvil |
| **Selenium Java** | 4.13.0 | Framework de automatización web |
| **TestNG** | 7.8.0 | Framework de pruebas |
| **Java Faker** | 1.0.2 | Generación de datos dinámicos |
| **Maven** | 3.6+ | Gestor de dependencias |
| **Appium Server** | 2.x | Servidor de automatización (Driver UiAutomator2) |

---

## 📁 Estructura del Proyecto

```
mobile-automation-final-project/
│
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/
│   │   │   └── 📂 utils/                   # Clases de utilidad
│   │   └── 📂 resources/                   # Archivos de recursos
│   │
│   └── 📂 test/
│       └── 📂 java/
│           ├── 📂 screens/                 # Page Object Models
│           │   ├── BaseScreen.java         # Clase base con métodos reutilizables
│           │   ├── HomeScreen.java         # Pantalla principal
│           │   ├── LoginScreen.java        # Pantalla de login
│           │   ├── MenuScreen.java         # Menú de navegación
│           │   └── SwipeScreen.java        # Gestos de swipe
│           │
│           └── 📂 tests/                   # Test Cases
│               ├── BaseTest.java           # Clase base (setup/teardown)
│               ├── LoginTest.java          # Pruebas de login válido
│               ├── InvalidLoginTest.java   # Pruebas de login inválido
│               ├── NavigationTest.java     # Pruebas de navegación
│               ├── SignupTest.java         # Pruebas de registro
│               └── SwipeTest.java          # Pruebas de gestos
│
├── 📂 target/                              # Compilados y reportes (generado)
│   ├── 📂 classes/
│   ├── 📂 test-classes/
│   └── 📂 surefire-reports/                # Reportes de pruebas
│
├── pom.xml                                 # Configuración de Maven
├── testng.xml                              # Configuración de TestNG
└── README.md
```

---

## ✨ Características Principales

### 🔧 Page Object Model (POM)

La arquitectura utiliza POM para separar los localizadores de los tests, mejorando la mantenibilidad:

**BaseScreen** - Clase base reutilizable:
- `click(By locator)` - Hacer click en elementos
- `sendKeys(By locator, String text)` - Enviar texto a campos
- `getText(By locator)` - Obtener texto de elementos
- `waitForVisibility(By locator)` - Esperar a que elementos sean visibles
- `isDisplayed(By locator)` - Verificar visibilidad

**Screens específicas:**
- `HomeScreen` - Pantalla principal con métodos de validación
- `LoginScreen` - Campos de usuario, contraseña y botón login
- `MenuScreen` - Elementos de navegación del menú
- `SwipeScreen` - Gestos y validaciones de swipe

### ⏱️ Gestión de Waits
- ⏰ Esperas explícitas configurables (por defecto 10 segundos)
- 🎯 Manejo inteligente de elementos con visibilidad controlada
- ✔️ Prevención de falsos negativos por timing

### 📊 Generación de Datos Dinámicos
- 🎲 Utiliza **JavaFaker** para generar datos únicos
- 🔄 Datos aleatorios en cada ejecución
- ♻️ Facilita reutilización de scripts

### 🧪 Integración TestNG
- `@BeforeMethod` - Setup antes de cada prueba
- `@AfterMethod` - Teardown después de cada prueba
- 📋 Suite de pruebas en `testng.xml`
- 📊 Reportes HTML automáticos
- 🔗 Integración con Maven para CI/CD

---

## 🔧 Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

### Sistema Operativo
- Windows 10+ / macOS / Linux

### Herramientas Requeridas
- **Java JDK 17+** - [Descargar](https://aws.amazon.com/es/corretto/)
- **Maven 3.6+** - [Descargar](https://maven.apache.org/)
- **Node.js** - Para instalar Appium
- **Android SDK** - Incluida en Android Studio
- **Appium Server 2.x** - Se instala vía npm

### Instalación de Dependencias

**Windows (con Chocolatey):**
```powershell
choco install maven
choco install nodejs
```

**macOS (con Homebrew):**
```bash
brew install maven
brew install node
```

**Appium:**
```bash
npm install -g appium
npm install -g appium-doctor
```

---

## 🚀 Configuración Inicial

### 1️⃣ Clonar el Repositorio

```bash
git clone <URL-del-repositorio>
cd mobile-automation-final-project
```

### 2️⃣ Instalar Dependencias del Proyecto

```bash
mvn clean install
```

### 3️⃣ Verificar Appium

```bash
appium-doctor --android
```

Asegúrate de que todos los componentes estén verificados ✓

### 4️⃣ Iniciar Appium Server

En una nueva terminal:
```bash
appium
```

El servidor se iniciará en `http://127.0.0.1:4723` (puerto por defecto)

### 5️⃣ Verificar Dispositivos

```bash
adb devices
```

Deberías ver tu emulador listado (ej: `emulator-5554`)

### 6️⃣ Configurar BaseTest.java

Actualiza los parámetros en `src/test/java/tests/BaseTest.java`:

```java
private static final String DEVICE_NAME = "emulator-5554";      // Tu emulador
private static final String APP_PACKAGE = "com.wdiodemoapp";    // Paquete de la app
private static final String APP_ACTIVITY = "com.wdiodemoapp.MainActivity";  // Actividad principal
private static final String APPIUM_URL = "http://127.0.0.1:4723";
```

---

## ⚙️ Configuración del Proyecto

### Configurar testng.xml

El archivo `testng.xml` define qué pruebas ejecutar:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="WebdriverIO App Test Suite">
    <test name="Regression Tests">
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.InvalidLoginTest"/>
            <class name="tests.SignupTest"/>
            <class name="tests.NavigationTest"/>
            <class name="tests.SwipeTest"/>
        </classes>
    </test>
</suite>
```

### Configurar pom.xml

El archivo `pom.xml` gestiona las dependencias y plugins:

```xml
<dependencies>
    <!-- Appium -->
    <dependency>
        <groupId>io.appium</groupId>
        <artifactId>java-client</artifactId>
        <version>8.6.0</version>
    </dependency>

    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.13.0</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
        <scope>test</scope>
    </dependency>

    <!-- JavaFaker -->
    <dependency>
        <groupId>com.github.javafaker</groupId>
        <artifactId>javafaker</artifactId>
        <version>1.0.2</version>
    </dependency>
</dependencies>
```

---

## ▶️ Ejecutar Pruebas

### Ejecutar todas las pruebas

```bash
mvn clean test
```

### Ejecutar suite específica

```bash
mvn clean test -Dsuite=testng.xml
```

### Ejecutar por clase de prueba

```bash
# Login válido
mvn test -Dtest=LoginTest

# Login inválido
mvn test -Dtest=InvalidLoginTest

# Registro
mvn test -Dtest=SignupTest

# Navegación
mvn test -Dtest=NavigationTest

# Gestos Swipe
mvn test -Dtest=SwipeTest
```

### Ejecutar método específico

```bash
mvn test -Dtest=LoginTest#testValidLogin
```

### Ejecutar con salida detallada

```bash
mvn clean test -X
```

### Ejecutar en paralelo

```bash
mvn clean test -DparallelRun=true
```

---

## 📊 Reportes

### Ubicación de Reportes

Los reportes se generan automáticamente en:

```
target/surefire-reports/
```

### Archivos Principales

| Archivo | Descripción |
|---------|------------|
| `index.html` | Resumen ejecutivo con gráficos |
| `emailable-report.html` | Reporte para enviar por email |
| `testng-results.xml` | Resultados en formato XML |
| `TEST-TestSuite.xml` | Detalles de ejecución |

### Visualizar Reportes

Abre en tu navegador:
```
target/surefire-reports/index.html
```

---

## 🧪 Ejemplos de Uso

### LoginTest - Ejemplo de Login Válido

```java
@Test
public void testValidLogin() {
    // Arrange
    String email = "user@example.com";
    String password = "password123";
    
    // Act
    loginScreen.enterEmail(email);
    loginScreen.enterPassword(password);
    loginScreen.clickLogin();
    
    // Assert
    assertTrue(homeScreen.isHomeScreenDisplayed(), 
        "La pantalla principal no se mostró");
}
```

### InvalidLoginTest - Ejemplo de Login Inválido

```java
@Test
public void testInvalidLogin() {
    // Arrange
    String email = "invalid@test.com";
    String password = "wrongpassword";
    
    // Act
    loginScreen.enterEmail(email);
    loginScreen.enterPassword(password);
    loginScreen.clickLogin();
    
    // Assert
    assertTrue(loginScreen.isErrorMessageDisplayed(), 
        "El mensaje de error no se mostró");
    assertEquals(loginScreen.getErrorMessage(), 
        "Invalid credentials", "Mensaje de error incorrecto");
}
```

### SwipeTest - Ejemplo de Gestos

```java
@Test
public void testSwipeGesture() {
    // Arrange
    swipeScreen.navigateToSwipePage();
    
    // Act
    swipeScreen.performSwipeLeft();
    
    // Assert
    assertTrue(swipeScreen.isNextItemDisplayed(), 
        "El siguiente item no se mostró después del swipe");
}
```

### SignupTest - Ejemplo de Registro

```java
@Test
public void testSuccessfulSignup() {
    // Arrange
    String fullName = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    
    // Act
    signupScreen.enterFullName(fullName);
    signupScreen.enterEmail(email);
    signupScreen.enterPassword(password);
    signupScreen.clickSignUp();
    
    // Assert
    assertTrue(homeScreen.isHomeScreenDisplayed(), 
        "Usuario no registrado correctamente");
}
```

---

## 📝 Buenas Prácticas Implementadas

✅ **Page Object Model (POM)**
- Separación clara entre localizadores y tests
- Reutilización de métodos

✅ **DRY (Don't Repeat Yourself)**
- Métodos reutilizables en BaseScreen
- Herencia de pantallas

✅ **Esperas Explícitas**
- Manejo robusto de tiempos
- Evita flakiness en tests

✅ **Datos Dinámicos**
- Generación con JavaFaker
- Tests independientes

✅ **Estructura Modular**
- Fácil de mantener
- Escalable para nuevas funcionalidades

✅ **Reportes Automatizados**
- TestNG genera reportes HTML
- Integración con Maven

---

## 🐛 Solución de Problemas

### ❌ Appium no se conecta

**Problema:** `Connection refused: http://127.0.0.1:4723`

**Solución:**
```bash
# Verifica que Appium esté corriendo
appium

# Si no inicia, instala drivers
appium driver install uiautomator2

# Reinicia el emulador
adb emu kill
emulator -avd <nombre_emulador>
```

### ❌ Dispositivo no encontrado

**Problema:** `No connected devices`

**Solución:**
```bash
# Lista dispositivos
adb devices

# Reconecta emulador
adb disconnect
adb connect emulator-5554

# Si no aparece, relanza
adb start-server
```

### ❌ Timeout en elementos

**Problema:** `TimeoutException: Element not found after 10 seconds`

**Solución:**
```java
// En BaseScreen.java, aumenta el tiempo de espera
private static final Duration WAIT_DURATION = Duration.ofSeconds(20);

// O espera específica en el test
swipeScreen.waitForElement(By.id("element_id"), 15);
```

### ❌ Clase no encontrada

**Problema:** `ClassNotFoundException` o imports incorrectos

**Solución:**
```bash
# Limpia y reconstruye
mvn clean install -U

# Verifica versiones
mvn dependency:tree
```

### ❌ App no abre

**Problema:** `Error starting app: Cannot find app`

**Solución:**
```java
// Verifica en BaseTest.java
System.out.println("Package: " + APP_PACKAGE);
System.out.println("Activity: " + APP_ACTIVITY);

// Obtén el paquete real
adb shell pm list packages | grep <nombre_app>

// Obtén la actividad principal
adb shell dumpsys window windows | grep mFocusedApp
```

### ❌ Tests fallidos aleatoriamente (Flakiness)

**Problema:** Los tests pasan a veces y fallan otras

**Solución:**
```java
// Aumenta waits explícitas
waitForVisibility(By.id("element"), 15);

// Usa implicitWait + explicit (con cuidado)
driver.manage().timeouts()
    .implicitlyWait(Duration.ofSeconds(5))
    .pageLoadTimeout(Duration.ofSeconds(15));
```

---

## 📚 Recursos Adicionales

- [Documentación Appium](https://appium.io/docs/en/latest/)
- [Documentación Selenium](https://www.selenium.dev/documentation/)
- [TestNG Official](https://testng.org/)
- [JavaFaker GitHub](https://github.com/DiUS/java-faker)
- [Android Debug Bridge (ADB)](https://developer.android.com/studio/command-line/adb)

---

