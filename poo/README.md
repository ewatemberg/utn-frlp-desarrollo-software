# Programación Orientada a Objetos (POO)
La Programación Orientada a Objetos (POO) es un paradigma de programación que organiza el código en torno a objetos en lugar de funciones y lógica. Los objetos representan entidades del mundo real o conceptos abstractos que tienen propiedades (atributos) y comportamientos (métodos). La POO busca hacer el código más modular, reutilizable y fácil de mantener.

## Índice de contenidos
* [Principales Conceptos](#principales-conceptos)
* [Ejemplos](#ejemplo-básico-de-poo-en-java)

## Principios Fundamentales de la POO

1. **Clases y Objetos**:
   - **Clase**: Una clase es una plantilla o modelo que define las propiedades y comportamientos que los objetos de ese tipo pueden tener. En Java, una clase define atributos (variables de instancia) y métodos (funciones) que describen las acciones que un objeto puede realizar.
   - **Objeto**: Un objeto es una instancia de una clase. Cuando creas un objeto a partir de una clase, estás creando una entidad con su propio estado y comportamiento basado en el modelo definido por la clase
2. **Encapsulamiento**: El encapsulamiento es el concepto de ocultar los detalles internos de un objeto y exponer solo lo necesario a través de métodos públicos. Esto se logra utilizando modificadores de acceso como `private`, `protected`, y `public`.
3. **Abstracción**: La abstracción consiste en ocultar los detalles complejos de la implementación y exponer solo los aspectos relevantes del objeto. Las clases abstractas e interfaces ayudan a implementar la abstracción en Java.
4. **Herencia**: La herencia es el mecanismo mediante el cual una clase puede derivar de otra clase, heredando sus atributos y métodos. Esto permite reutilizar código y crear jerarquías de clases.
5. **Polimorfismo**: El polimorfismo permite que una clase hija pueda sobrescribir métodos de una clase padre y que diferentes objetos puedan ser tratados como instancias de su clase padre, pero con comportamientos diferentes.

## Ejemplo básico de POO en Java
A continuación se muestra cómo se utilizan estos conceptos en un ejemplo simple de una clase Coche.

### Creación de una clase
```java
// Definición de la clase Coche
public class Coche {
    // Atributos (propiedades)
    private String marca;
    private String modelo;
    private int velocidad;

    // Constructor
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = 0;  // Todos los coches inician con velocidad 0
    }

    // Métodos (comportamientos)
    public void acelerar(int incremento) {
        velocidad += incremento;
        System.out.println(marca + " " + modelo + " ha acelerado a " + velocidad + " km/h.");
    }

    public void frenar(int decremento) {
        velocidad -= decremento;
        if (velocidad < 0) velocidad = 0;
        System.out.println(marca + " " + modelo + " ha frenado a " + velocidad + " km/h.");
    }

    // Getter para la velocidad
    public int getVelocidad() {
        return velocidad;
    }
}
```


### Creación de un objeto
Ahora, creamos un objeto a partir de la clase Coche y utilizamos sus métodos para interactuar con él:
```java
public class Main {
    public static void main(String[] args) {
        // Creación de un objeto Coche
        Coche miCoche = new Coche("Toyota", "Corolla");

        // Uso de los métodos del objeto
        miCoche.acelerar(50);  // Toyota Corolla ha acelerado a 50 km/h.
        miCoche.frenar(20);    // Toyota Corolla ha frenado a 30 km/h.
        System.out.println("Velocidad actual: " + miCoche.getVelocidad() + " km/h.");
    }
}
```

### Encapsulamiento
En el ejemplo anterior, los atributos `marca`, `modelo` y `velocidad` son **privados** (`private`), lo que significa que no pueden ser accedidos directamente desde fuera de la clase. Solo se puede acceder a ellos a través de los métodos públicos, como `acelerar()`, `frenar()`, y `getVelocidad()`, lo que garantiza un control más estricto sobre cómo se manipulan los datos.

### Herencia
Supongamos que tenemos una clase más específica que extiende de `Coche`, llamada `CocheDeportivo`:
```java
// Clase CocheDeportivo que hereda de Coche
public class CocheDeportivo extends Coche {
    private boolean turbo;

    public CocheDeportivo(String marca, String modelo) {
        super(marca, modelo);
        this.turbo = false;
    }

    public void activarTurbo() {
        turbo = true;
        System.out.println("El turbo ha sido activado.");
    }

    // Sobrescribiendo el método acelerar
    @Override
    public void acelerar(int incremento) {
        if (turbo) {
            incremento *= 2;  // El coche acelera el doble si el turbo está activado
        }
        super.acelerar(incremento);
    }
}
```
Aquí:
- `CocheDeportivo` hereda `Coche`usando la palabra clave `extends`.
- Sobrescribe el método `acelerar()` para modificar su comportamiento cuando el turbo está activado
- Usa `super()` para invocar el constructor de la clase padre y `super.acelerar()` para reutilizar la lógica de la clase padre.

### Uso de la herencia
```java
public class Main {
    public static void main(String[] args) {
        // Creación de un coche deportivo
        CocheDeportivo miCocheDeportivo = new CocheDeportivo("Ferrari", "488");

        miCocheDeportivo.acelerar(50);  // Ferrari 488 ha acelerado a 50 km/h.
        miCocheDeportivo.activarTurbo();
        miCocheDeportivo.acelerar(50);  // Ferrari 488 ha acelerado a 150 km/h.
    }
}
```

### Polimorfismo
El polimorfismo permite tratar a los objetos de diferentes clases derivadas de la misma clase base de forma uniforme. Por ejemplo, tanto `Coche` como `CocheDeportivo` pueden ser tratados como `Coche` en el código:

```java
public class Main {
    public static void main(String[] args) {
        // Polimorfismo
        Coche miCoche = new Coche("Toyota", "Corolla");
        Coche miCocheDeportivo = new CocheDeportivo("Ferrari", "488");

        miCoche.acelerar(50);            // Toyota Corolla ha acelerado a 50 km/h.
        miCocheDeportivo.acelerar(50);   // Ferrari 488 ha acelerado a 50 km/h.
        
        // Mi coche deportivo tiene turbo, pero se trata como un Coche
        ((CocheDeportivo) miCocheDeportivo).activarTurbo();  // El turbo ha sido activado.
        miCocheDeportivo.acelerar(50);   // Ferrari 488 ha acelerado a 150 km/h.
    }
}
```
Aquí, `miCocheDeportivo` se trata como un objeto de la clase base `Coche`, pero podemos acceder a las características adicionales de `CocheDeportivo` mediante un **casting**.

### Abstracción
Podemos usar la abstracción para definir clases abstractas que no se pueden instanciar directamente pero que sirven como base para otras clases.
```java
// Clase abstracta Vehiculo
public abstract class Vehiculo {
    protected String marca;

    public Vehiculo(String marca) {
        this.marca = marca;
    }

    public abstract void conducir();  // Método abstracto
}

// Clase concreta que extiende de Vehiculo
public class Moto extends Vehiculo {
    public Moto(String marca) {
        super(marca);
    }

    @Override
    public void conducir() {
        System.out.println(marca + " está en marcha.");
    }
}
```
Una **clase abstracta** no puede ser instanciada, pero otras clases pueden derivar de ella y proporcionar implementaciones específicas para los métodos abstractos.