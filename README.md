# 🚀 Mobile Automation Final Project

Un proyecto de automatización de pruebas para aplicaciones móviles Android utilizando **Appium**, **Selenium** y **TestNG**. Implementa el patrón **Page Object Model** para mantener un código mantenible y escalable.

## 📋 Descripción

Este proyecto automatiza pruebas de regresión para aplicaciones móviles Android, cubriendo escenarios de:
- **Login**: Validación de credenciales y autenticación
- **Signup**: Registro de nuevos usuarios
- **Navegación**: Flujos de navegación en la aplicación
- **Interacciones**: Gestos como swipe en la aplicación

## 🛠️ Tecnologías Utilizadas

- **Java 8+**: Lenguaje de programación
- **Appium 8.6.0**: Framework de automatización móvil
- **Selenium 4.13.0**: Biblioteca de automatización web
- **TestNG 7.8.0**: Framework de testing
- **Maven**: Gestor de dependencias y proyectos
- **Java Faker 1.0.2**: Generación de datos de prueba

## 📁 Estructura del Proyecto

```
mobile-automation-final-project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── screens/              # Page Object Models
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── MenuPage.java
│   │   │   │   └── SwipePage.java
│   │   │   └── utils/              # Clases de utilidad
│   │   └── resources/              # Archivos de recursos
│   └── test/
│       └── java/
│           └── tests/              # Clases de prueba
│               ├── BaseTest.java
│               ├── LoginTest.java
│               ├── NavigationTest.java
│               ├── SignupTest.java
│               └── SwipeTest.java
├── pom.xml                         # Configuración de Maven
├── testng.xml                      # Configuración de TestNG
└── README.md
```

## ✨ Características Principales

### Page Object Model (POM)
- **BasePage**: Clase base con métodos reutilizables (click, sendKeys, waitForVisibility)
- **Pages específicas**: HomePage, LoginPage, MenuPage, SwipePage con elementos y acciones particulares

### Gestión de Waits
- Esperas explícitas configurables (por defecto 10 segundos)
- Manejo inteligente de elementos con visibilidad controlada

### Generación de Datos de Prueba
- Utiliza JavaFaker para generar datos dinámicos en tests

### TestNG
- Anotaciones @BeforeMethod y @AfterMethod para setup y teardown
- Suite de pruebas configuradas en testng.xml
- Reportes automáticos

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
mvn test -Dtest=LoginTest
```

### Ejecutar un método específico

```bash
mvn test -Dtest=LoginTest#testValidLogin
```

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
