# appGateMobile
Es un robot de pruebas funcionales para la aplicación TimeZoneApp (Android) con propiedades para la ejecución en un celuar físico Samsung A52.

La aplicación se construye utilizando el lenguaje de programación Java y gradle como gestor de dependencias y compilador del proyecto.

Se utiliza la técnica de pruebas BDD; esta se implementa haciendo uso del lenguaje Gherkin escrito en la herramienta Cucumber.

Se usa Appium como driver de conectividad con el dispositivo móvil y se complementa con Serenity para lograr la conectividad entre la automatización y el dispositivo. Se utiliza Selenium para realizar la adherencia con la aplicación móvil

Se hace uso de Serenitybdd como herramienta para la implementación del patrón de automatización Screenplay y la generación de informes de resultados de las pruebas.

Para versionar el código fuente se utiliza git como herramienta de gestión de código, Gihub com repositorio, trunk base development como estándar de versionamiento y Sonar como herramienta para realizar análisis de código estático.

Las versiones de las herramientas se detallan a continuación.

```
Java 11 Openjdk version "11.0.2" 2019-01-15
Gradle wrapper 7.4.1
SerenityBdd 3.2.5
Cucumber 3.2.5
Appium 1.22.0
Git 2.35.1.2 
Sonar 9.4.0.54424
```

##Configuraciones de ejecución
###En Local

Para correr la automatización de forma local se debe:
1. Tener conectado un celular físico al PC, este debe tener habilitada la opción **Debug USB** la cual encuentras en **Opciones de desarrollador**. Para más información sobree estas opciones visita [Habilita las Opciones para desarrolladores y la depuración por USB](https://developer.android.com/studio/debug/dev-options?hl=es-419#enable)
2. Instalar y ejecutar [Appium](https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4)
3. Instalar [Java](https://openjdk.java.net/projects/jdk/11) y configurar la [varialbe de entorno](https://www.java.com/es/download/help/path_es.html)
4. Instalar [Gradle](https://gradle.org/releases) y su [variable de entorno configurada]((https://gradle.org/install/#manually))
5. Descargar la APP [TimeZoneApp](https://github.com/ATUWAKU/AppMobAndroidAppGate) ge





