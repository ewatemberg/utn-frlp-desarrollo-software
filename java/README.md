# Introducción a Java
TypeScript es un lenguaje de programación de código abierto desarrollado por Microsoft, que extiende JavaScript al agregar tipos estáticos opcionales. Fue diseñado para facilitar el desarrollo de aplicaciones JavaScript a gran escala, permitiendo a los desarrolladores detectar errores y mejorar la mantenibilidad del código. 

## Índice de contenidos
* [Java Esencial](#java-esencial)
* [Build Tools](#build-tools)
* [Hola Mundo](#hola-mundo-en-typescript)
* [Funciones](#definición-de-funciones)
* [Clases](#clases)
* [Interfaces](#interfaces)
* [Clases Abstractas](#clase-abstracta)

## Java Esencial

### JDK vs JRE vs JVM
JVM (Java Virtual Machine): La JVM es la encargada de ejecutar el bytecode, que es el formato intermedio en el que se compilan los programas Java. La JVM es independiente de la plataforma, permitiendo que el mismo programa Java funcione en diferentes sistemas operativos, siempre y cuando haya una JVM compatible en ese sistema. Es el componente que hace que Java sea un lenguaje "independiente de la plataforma".

JRE (Java Runtime Environment): El JRE incluye la JVM y las bibliotecas y archivos necesarios para ejecutar aplicaciones Java. Es el entorno de ejecución, por lo que si solo quieres ejecutar programas Java y no necesitas compilar ni desarrollar, el JRE es suficiente. Incluye, además de la JVM, las bibliotecas estándar y los archivos de soporte requeridos para que las aplicaciones Java funcionen correctamente.

JDK (Java Development Kit): El JDK es el paquete completo para el desarrollo de aplicaciones Java. Incluye el JRE (que a su vez incluye la JVM), además de herramientas como el compilador (javac), el depurador y otras utilidades para desarrollar, compilar y depurar programas en Java. Es el kit esencial para los desarrolladores de Java, ya que ofrece todas las herramientas necesarias para escribir y compilar código Java.

![JDK-JRE-JVM](/doc/img/jdk_jre_jvm.jpg)

### Code Conventions

Las **Java Code Conventions** son un conjunto de normas y prácticas recomendadas que los desarrolladores de Java deben seguir al escribir código. Estas convenciones fueron establecidas originalmente por Sun Microsystems y posteriormente por Oracle, con el objetivo de hacer que el código sea más legible, mantenible y consistente entre diferentes equipos de desarrollo.

Seguir estas convenciones facilita la colaboración en proyectos grandes y el mantenimiento a largo plazo del código, ya que las reglas ayudan a garantizar que el código escrito por diferentes desarrolladores tenga un estilo coherente.


Principales [convenciones](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html) de código en Java:
- Nombres de clases:
    - Las clases deben tener nombres en CamelCase (cada palabra comienza con mayúscula).
    - Ejemplo: `CustomerService`, `EmployeeDetails`.
- Nombres de métodos:
    - Los métodos deben comenzar con una letra minúscula y usar camelCase.
    - Ejemplo: `calculateTotal()`, `findCustomerById()`.
- Nombres de variables:
    - Las variables también deben utilizar camelCase.
    - Ejemplo: `customerName`, `totalAmount`.
- Nombres de constantes:
    - Las constantes se escriben en mayúsculas completas separadas por guiones bajos (_).
    - Ejemplo: `MAX_HEIGHT`, `DEFAULT_TIMEOUT`.
- Nombres de variables:
    - Las variables también deben utilizar camelCase.
    - Ejemplo: `customerName`, `totalAmount`.
- Nombres de constantes:
    - Las constantes se escriben en mayúsculas completas separadas por guiones bajos (_).
    - Ejemplo: `MAX_HEIGHT`, `DEFAULT_TIMEOUT`.
- Indentación:
    - Se recomienda usar 4 espacios por nivel de indentación en lugar de un tabulador.
    - Facilita la legibilidad del código en editores diferentes.
- Longitud de las líneas:
    - Se sugiere que las líneas de código no superen los 80 caracteres de largo. Si es necesario, se debe dividir la línea para mejorar la legibilidad.

## Build Tools
Son herramientas que ayudan a automatizar tareas (ciclo de vida de un desarrollo).

### Maven
Maven es una herramienta de gestión y construcción de proyectos, principalmente usada en proyectos Java. Facilita la automatización de tareas como la compilación del código, la ejecución de pruebas, la creación de paquetes (como archivos JAR o WAR) y la gestión de dependencias de terceros. Su principal propósito es simplificar y estandarizar el ciclo de vida del desarrollo de software, especialmente en proyectos que involucran muchas bibliotecas externas.

#### Caracteristicas
- Gestión de dependencias: Maven permite especificar todas las dependencias externas que un proyecto necesita (bibliotecas, frameworks, etc.) en un archivo llamado pom.xml. Maven se encarga de descargarlas automáticamente desde repositorios remotos y de administrarlas.

- Ciclo de vida de construcción: Maven define un conjunto de fases que cubren las etapas de construcción de un proyecto. Estas incluyen fases como la compilación (compile), las pruebas (test), el empaquetado (package), la verificación (verify) y la instalación (install).

- Estandarización: Maven usa una estructura de proyecto estándar y un archivo de configuración XML (pom.xml). Esto permite que cualquier desarrollador pueda entender y trabajar en un proyecto Maven fácilmente, independientemente de cómo esté estructurado.

- Plugins: Maven es extensible mediante plugins, que ofrecen una variedad de funcionalidades para tareas específicas, como generar documentación, ejecutar pruebas unitarias, o compilar archivos de recursos adicionales.

[¿Que es maven y cómo funciona?](https://www.arquitecturajava.com/que-es-maven/)

![Goals](/doc/img/maven_goals.jpg)
