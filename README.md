# 🚀 Mobile Automation Final Project

Un proyecto de automatización de pruebas para aplicaciones móviles Android utilizando **Appium**, **Selenium** y **TestNG**. Implementa el patrón **Page Object Model** para mantener un código mantenible y escalable.

**Desarrollado por:** LUIS MATEO OCHOA AGUDELO

---

## 📋 Descripción

Este proyecto automatiza pruebas de regresión para aplicaciones móviles Android, cubriendo escenarios de:
- **Login**: Validación de credenciales y autenticación
- **Login Inválido**: Pruebas de casos de error y validación de mensajes
- **Signup**: Registro de nuevos usuarios
- **Navegación**: Flujos de navegación en la aplicación
- **Interacciones**: Gestos como swipe en la aplicación

---

## 🛠️ Tecnologías y Versiones Específicas

Para garantizar la estabilidad y compatibilidad (evitando errores de clases no encontradas), el proyecto utiliza:

- **Java JDK**: 17 (Amazon Corretto / OpenJDK)
- **Appium Java Client**: 8.6.0
- **Selenium Java**: 4.13.0
- **TestNG**: 7.8.0
- **Java Faker**: 1.0.2 (Para generación de datos dinámicos)
- **Maven**: 3.6+
- **Appium Server**: 2.x con Driver **UiAutomator2**

---

## 📁 Estructura del Proyecto

```
mobile-automation-final-project/
├── src/
│   └── test/
│       └── java/
│           ├── screens/                    # Page Object Models
│           │   ├── BaseScreen.java         # Clase base con métodos reutilizables
│           │   ├── HomeScreen.java         # Page Object para la pantalla principal
│           │   ├── LoginScreen.java        # Page Object para login
│           │   ├── MenuScreen.java         # Page Object para el menú
│           │   └── SwipeScreen.java        # Page Object para gestos de swipe
│           └── tests/                      # Clases de prueba (Test Cases)
│               ├── BaseTest.java           # Clase base con setup/teardown
│               ├── LoginTest.java          # Pruebas de login válido
│               ├── InvalidLoginTest.java   # Pruebas de login inválido
│               ├── NavigationTest.java     # Pruebas de navegación
│               ├── SignupTest.java         # Pruebas de registro
│               └── SwipeTest.java          # Pruebas de gestos swipe
├── target/                                 # Archivos compilados (generado por Maven)
│   ├── classes/
│   ├── test-classes/
│   └── surefire-reports/                   # Reportes de pruebas
├── pom.xml                                 # Configuración de Maven
├── testng.xml                              # Configuración de TestNG
└── README.md
```

---

## ✨ Características Principales

### 🔧 Page Object Model (POM)
- **BaseScreen**: Clase base con métodos reutilizables para todas las operaciones comunes
  - `click()` - Hacer click en elementos
  - `sendKeys()` - Enviar texto a campos
  - `waitForVisibility()` - Esperar a que elementos sean visibles
  - `isDisplayed()` - Verificar si un elemento está visible
  
- **Screens específicas**: 
  - `HomeScreen` - Pantalla principal de la aplicación
  - `LoginScreen` - Pantalla de login con campos de usuario y contraseña
  - `MenuScreen` - Menú de navegación de la aplicación
  - `SwipeScreen` - Pantalla para pruebas de gestos

### ⏱️ Gestión de Waits
- Esperas explícitas configurables (por defecto 10 segundos)
- Manejo inteligente de elementos con visibilidad controlada
- Prevención de falsos negativos por timing

### 📊 Generación de Datos de Prueba
- Utiliza **JavaFaker** para generar datos dinámicos en tests
- Datos únicos y aleatorios para cada ejecución
- Facilita la reutilización de scripts de prueba

### 🧪 TestNG
- Anotaciones `@BeforeMethod` y `@AfterMethod` para setup y teardown
- Suite de pruebas configuradas en `testng.xml`
- Reportes HTML automáticos tras cada ejecución
- Integración con Maven para CI/CD

---

## 🔧 Requisitos Previos

- **Java 8 o superior**
- **Maven 3.6+**
- **Android Emulator o Device**
- **Appium Server 2.0+**
- **Android SDK**

### Instalación de Dependencias

```bash
# Instalar Maven (si no está instalado)
# En Windows con Chocolatey:
choco install maven

# En macOS con Homebrew:
brew install maven
```

## 🚀 Configuración Inicial

### 1. Clonar el Repositorio

```bash
git clone <URL-del-repositorio>
cd mobile-automation-final-project
```

### 2. Instalar Appium

```bash
npm install -g appium
npm install -g appium-doctor
```

### 3. Verificar Instalación

```bash
appium-doctor --android
```

### 4. Iniciar Appium Server

```bash
appium
```

El servidor debería iniciarse en `http://127.0.0.1:4723` (puerto por defecto)

### 5. Configurar el Emulador

```bash
# Listar dispositivos disponibles
adb devices

# Verificar el nombre del emulador (ejemplo: emulator-5554)
```

## ⚙️ Configuración del Proyecto

### Actualizar BaseTest.java

Asegúrate de que los siguientes parámetros coincidan con tu entorno:

```java
options.setDeviceName("emulator-5554");        // Nombre de tu emulador
options.setAppPackage("com.wdiodemoapp");      // Paquete de la app
options.setAppActivity("com.wdiodemoapp.MainActivity");  // Actividad principal
```

### Configurar testng.xml

Para ejecutar suites específicas de pruebas, edita `testng.xml`:

```xml
<suite name="WebdriverIO App Test Suite">
    <test name="Regression Tests">
        <classes>
            <class name="tests.NavigationTest"/>
            <class name="tests.SignupTest"/>
            <class name="tests.LoginTest"/>
            <class name="tests.SwipeTest"/>
        </classes>
    </test>
</suite>
```

## ▶️ Cómo Ejecutar las Pruebas

### Ejecutar todas las pruebas

```bash
mvn clean test
```

### Ejecutar con suite específica

```bash
mvn clean test -Dsuite=testng.xml
```

### Ejecutar una clase de prueba específica

```bash
# Pruebas de Login válido
mvn test -Dtest=LoginTest

# Pruebas de Login inválido
mvn test -Dtest=InvalidLoginTest

# Pruebas de Signup
mvn test -Dtest=SignupTest

# Pruebas de Navegación
mvn test -Dtest=NavigationTest

# Pruebas de Swipe
mvn test -Dtest=SwipeTest
```

### Ejecutar un método específico

```bash
mvn test -Dtest=LoginTest#testValidLogin
```

### Ejecutar con depuración

```bash
mvn clean test -X
```

---

## 📊 Reportes

Los reportes se generan automáticamente en:

```
target/surefire-reports/
```

Archivos principales:
- `index.html` - Resumen ejecutivo
- `emailable-report.html` - Reporte enviable por email
- `testng-results.xml` - Resultados en formato XML

## 🧪 Ejemplos de Uso

### LoginTest
```java
@Test
public void testValidLogin() {
    loginPage.enterEmail("user@example.com");
    loginPage.enterPassword("password123");
    loginPage.clickLogin();
    assertTrue(homePage.isHomeScreenDisplayed());
}
```

### SwipeTest
```java
@Test
public void testSwipeGesture() {
    swipePage.navigateToSwipePage();
    swipePage.performSwipe();
    assertTrue(swipePage.isNextItemDisplayed());
}
```

## 📝 Buenas Prácticas Implementadas

✅ **Page Object Model**: Separación de localizadores y acciones
✅ **DRY (Don't Repeat Yourself)**: Métodos reutilizables en BasePage
✅ **Esperas Explícitas**: Manejo robusto de tiempos
✅ **Datos Dinámicos**: Generación con JavaFaker
✅ **Estructura Modular**: Fácil de mantener y escalar

## 🐛 Solución de Problemas

### Appium no se conecta
```
- Verifica que Appium Server esté corriendo: http://127.0.0.1:4723
- Revisa la consola de Appium para errores
- Reinicia el emulador Android
```

### Dispositivo no encontrado
```bash
# Listar dispositivos conectados
adb devices

# Desconectar y reconectar
adb disconnect
adb connect emulator-5554
```

### Timeout en elementos
- Aumenta el Duration en BasePage (línea con Duration.ofSeconds(10))
- Verifica que los localizadores sean correctos
- Comprueba que la app esté en el estado esperado

---

**Última actualización**: Marzo 2026

**Versión del Proyecto**: 1.0-SNAPSHOT
