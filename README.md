# appGateMobile
Es un robot de pruebas End to End para la aplicación TimeZoneApp, construida en Android, con propiedades para la ejecución en un celuar físico Samsung A52.

El robot se construye utilizando Intellij Community y el lenguaje de programación Java y gradle como gestor de dependencias y compilador del proyecto.

Se utiliza la técnica de pruebas BDD; esta se implementa haciendo uso del lenguaje Gherkin escrito en la herramienta Cucumber.

Se usa Appium como driver de conectividad con el dispositivo móvil y se complementa con Serenity para lograr la conectividad entre la automatización y el dispositivo. Se utiliza Selenium para realizar la adherencia con la aplicación móvil

Se hace uso de Serenitybdd como herramienta para la implementación del patrón de automatización Screenplay y la generación de informes de resultados de las pruebas.

Para versionar el código fuente se utiliza git como herramienta de gestión de código, Gihub com repositorio, trunk base development como estándar de versionamiento y Sonar como herramienta para realizar análisis de código estático.

Las versiones de las herramientas se detallan a continuación.

```shell
Intellij Community 2021.3.2
Java 11 Openjdk version "11.0.2" 2019-01-15
Gradle wrapper 7.4.1
SerenityBdd 3.2.5
Cucumber 3.2.5
Appium 1.22.0
Git 2.35.1.2 
Sonar 9.4.0.54424
```
------------------------------------------------------
#Automatización

##Configuraciones de ejecución
###En Local

Para correr la automatización de forma local se debe:
1. Tener conectado un celular físico al PC, este debe tener habilitada la opción **Debug USB** la cual encuentras en **Opciones de desarrollador**. Para más información sobree estas opciones visita [Habilita las Opciones para desarrolladores y la depuración por USB](https://developer.android.com/studio/debug/dev-options?hl=es-419#enable)
2. Instalar y ejecutar [Appium](https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4)
3. Instalar [Java](https://openjdk.java.net/projects/jdk/11) y configurar la [varialbe de entorno](https://www.java.com/es/download/help/path_es.html)
4. Instalar [Gradle](https://gradle.org/releases) y su [variable de entorno configurada]((https://gradle.org/install/#manually))
5. Tener sin comentarios las capabilities **LOCAL** del archivo serenity.properties
6. Se debe modificar la capability appium.app. Deben poner la direcció donde esté el APK

###En Granjas de dispotivos -> Kobiton
1. Instalar [Java](https://openjdk.java.net/projects/jdk/11) y configurar la [varialbe de entorno](https://www.java.com/es/download/help/path_es.html)
2. Instalar [Gradle](https://gradle.org/releases) y su [variable de entorno configurada]((https://gradle.org/install/#manually))
3. Tener sin comentarios las capabilities **KOBITON** del archivo serenity.properties
4. Consultar y cambiar el valor de las capabilities: deviceName, platformVersion, app, username y accessKey. Para mayor información consulte [Desired Capabilities](https://kobiton.com/book/chapter-3-understanding-the-desired-capabilities)
5. **El celular en la granja debe ser un dispositivo físico Android**

##Ejecución
###Datos para la ejecución
Los datos para la ejecución los encuentra en cada uno de los archivos feature

###Todos los test
gradlew clen build test aggregate
####Test Capturar Coordenadas
Debe ejecutar el comando gradlew clen build test --tests "com.appgate.prueba.runners.CaptureCoordinatesRunner" aggregate
####Test Consultar información de zona horaria
Debe ejecutar el comando gradlew clen build test --tests "com.appgate.prueba.runners.TimeZoneDataQueryRunner" aggregate
####Test Reiniciar Consulta
Debe ejecutar el comando gradlew clen build test --tests "com.appgate.prueba.runners.RestartQueryRunner" aggregate

###Informe de resultados
El informe de resultados lo encuentran en la carpeta donde está el proyecto en la ruta target\site\serenity\index.html


------------------------------------------------------
#DevOps
Para este Robot de automatización de pruebas se realizaron los procesos de continuous integration, continuous deployment y Release Management. Estos procesos se hicieron usando Jenkins 2.348 integrado con GitHub y Sonar

##Configuraciones

###Análisis de código estático
Para realizar este análisis tenga en cuenta
1. se utilizó Sonar configurado en el mismo PC donde se ejecutan las pruebas. Esta herramienta debe quedar configurada en el puerto 9000
2. Se debe tener, en el build.gradle, la tarea **sonarqube** tal como se muestra a continaución

```shell

sonarqube {
    properties {
        property "sonar.projectKey", "appGateMobile"      
        property "sonar.host.url", "http://localhost:9000"
        property "sonar.java.binaries", "src/main/java"
  }
}
```
3. Se debe crear una token en Sonar
4. Se debe configurar el token de sonar en Jenkins con el nombre **SONAR_TOKEN**

###Jenkins Files

####CI
Se realiza continuos integration haciendo uso de Git y GitHub sincronizado, a través de un job, con Jenkins.
Jenkins está censando el Repositorio de GitHub para encontrar cambios y correr los pipelines

####CD
**Consideraciones**
1. Crear un pipeline en Jenkins, este debe estar apuntando al respositorio de código en GitHub. 
2. Tener un archivo JenkinsFile llamado JenkinsFile_CI el cual debe tener la siguiente configuración

```shell
pipeline {
    agent any

    stages {
        stage('Descargar Fuentes') {
            steps {
				echo 'Incia Pipeline'
                echo 'Descarga Repositorio'
                checkout([$class: 'GitSCM', branches: [[name: '*/trunk']], extensions: [], userRemoteConfigs: [[credentialsId: 'GitHubAtuwaku', url: 'https://github.com/ATUWAKU/appGateServices.git']]])
				echo 'Termina Descarga Repositorio'
            }
        }
		stage('Compilacion'){
			steps{
				echo 'Inicia Compilacion'
				echo 'Incia Comando Clean'
				bat 'gradlew clean'
				echo 'Termina Comando Clean'
				echo 'Incia Comando build -x test'
				bat 'gradlew build -x test'
				echo 'Termina Comando build -x test'
			}
		}
		stage('Analisis de codigo estatico'){
			steps{
				withCredentials([string(credentialsId: 'SONAR_TOKEN', variable: 'SONAR_TOKEN')]) {
					echo 'Incia Análisis de Código Estático'                
					bat 'gradlew sonarqube'	
				}
				echo 'Termina Análisis de Código Estático'
				echo 'Termina Pipeline'
			}
		}
    }
}
```


####RM
**Consideraciones**
1. Crear un pipeline en Jenkins, este debe estar apuntando al respositorio de código en GitHub.
2. Se debe configurar en la sección Extended E-mail Notification el smtp para enviar los correos con los resultados
3. Tu servicio de Email debe permitir la conexión de aplicaciones externas
4. Tener un archivo JenkinsFile llamado JenkinsFile_RM el cual debe tener la siguiente configuración

```shell
pipeline {
    agent any
	triggers {
	  upstream 'appGateServices_CI'	
	}	
    stages {
        stage('Ejecucion') {
            steps {         
				echo 'Inicia la ejecucion'
				bat 'gradlew clean build test aggregate'				
				echo 'Termina Ejecucion'
            }
        }
		stage('Email') {
			steps {				
				echo 'Inicia Envio de Email'
				script {					
					emailext body: '''Se ha ejecutado el appGateServices_RM
					Resultado: ${BUILD_STATUS}''',					
					subject: " Resultado Pipeline appGateServices_RM",
					to: "david_muner@hotmail.com"
				}
				echo 'Termina Envio de Email'
			}
		}
		
    }
}
```