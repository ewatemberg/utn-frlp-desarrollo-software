# Hello World Spring Boot

El comando `mvn clean` se usa en Maven, una herramienta de gestión y construcción de proyectos en Java. Ejecutar `mvn clean` hace que Maven elimine todos los archivos generados por compilaciones anteriores en el directorio `target`, donde Maven guarda los resultados de las compilaciones, artefactos y otros archivos temporales.
```bash
mvn clean
```

**¿Por qué es útil?**

Al limpiar el proyecto, te aseguras de que la próxima vez que se compile, Maven construya todo desde cero, evitando posibles problemas causados por archivos obsoletos o cachés de compilaciones previas.

**Uso común:**

`mvn clean` se suele combinar con `mvn install` o `mvn package` para limpiar y luego compilar y empaquetar el proyecto en un solo paso:
```bash
mvn clean install
```
Esto garantiza una compilación limpia y completa de la aplicación, sin residuos de compilaciones anteriores.

Luego de limpiar los archivos de la carpeta `target` (`mvn clean`) y de bajar todas las dependencias y compilar y empaquetar el proyecto (`mvn clean install`), podremos ejecutar la app generada de la siguiente manera

Opcion 1:
> Click derecho sobre "App.java" -> Run As -> Java Application

Opcion 2:
> Primero, navega a la carpeta target donde se encuentra el archivo .class generado (en el directorio target/classes).
Luego, ejecuta la clase principal especificando su ruta completa.
```bash
java org.example.App
``` 
