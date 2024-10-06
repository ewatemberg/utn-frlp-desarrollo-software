# Introducción a TypeScript
TypeScript es un lenguaje de programación de código abierto desarrollado por Microsoft, que extiende JavaScript al agregar tipos estáticos opcionales. Fue diseñado para facilitar el desarrollo de aplicaciones JavaScript a gran escala, permitiendo a los desarrolladores detectar errores y mejorar la mantenibilidad del código. 

## Índice de contenidos
* [Ventajas](#ventajas)
* [Conceptos Importantes](#conceptos-importantes)
* [Hola Mundo](#hola-mundo-en-typescript)
* [Funciones](#definición-de-funciones)
* [Clases](#clases)
* [Interfaces](#interfaces)
* [Clases Abstractas](#clase-abstracta)

## Ventajas

- Detección temprana de errores: Gracias al tipado estático, muchos errores se detectan en tiempo de compilación, en lugar de en tiempo de ejecución.
- Mejor mantenimiento del código: Facilita la lectura y el mantenimiento del código a largo plazo, especialmente en equipos grandes.
- Refactorización segura: Con la ayuda de tipos estáticos, es más fácil refactorizar el código sin temor a romper funcionalidades.

## Conceptos importes
[Principios SOLID](https://www.freecodecamp.org/espanol/news/los-principios-solid-explicados-en-espanol/)

## Hola Mundo en TypeScript
1. Crear un archivo `app.ts` con el siguiente contenido:

```javascript
const hello = 'Hello World!!!';
console.log(hello)
```

2. Crear un archivo `/hello-world/index.html` que importe `/hello-world/app.js`:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Typescript - Parte I</title>
</head>
<body>
    <script src="app.js"></script>
    
</body>
</html>
```

3. Compilar el archivo `app.ts` para que genere (transpile) el archivo `app.js`

```bash
tsc app.ts
```

## Definición de funciones:

Las funciones en TypeScript son muy similares a las de JavaScript, pero con la ventaja de contar con tipado estático, lo que permite definir tipos para parámetros, valores de retorno y evitar errores comunes. Aquí te muestro algunos ejemplos de funciones en TypeScript:


### Función simple con tipado

```typescript
function sumar(a: number, b: number): number {
    return a + b;
}

const resultado = sumar(5, 3);
console.log(resultado); // 8
```
En este ejemplo, tanto los parámetros `a` y `b` como el valor de retorno están tipados como `number`.

Otro ejemplo:

1. modificar el archivo `/funciones/index.html` para que importe el archivo `/funciones/functions.js`.

```html
<body>
    <script src="functions.js"></script>
</body>
```

2. Compilar el archivo `functions.ts` para que genere (transpile) el archivo `functions.js`

```bash
tsc functions.ts
```


### Funciones con parametros opcionales

Puedes hacer que uno o más parámetros sean opcionales utilizando el signo `?`.

```typescript
function saludar(nombre: string, apellido?: string): string {
    if (apellido) {
        return `Hola, ${nombre} ${apellido}`;
    } else {
        return `Hola, ${nombre}`;
    }
}

console.log(saludar("Juan")); // Hola, Juan
console.log(saludar("Juan", "Pérez")); // Hola, Juan Pérez
```

Otro ejemplo: 

1. modificar el archivo `/funciones/index.html` para que importe el archivo `/funciones/args-optionals.js`.

2. Compilar el archivo `args-optionals.ts` para que genere (transpile) el archivo `args-optionals.js`

```bash
tsc args-optionals.ts
```

### Funciones con valores por defecto
Puedes definir valores por defecto para los parámetros.

```typescript
function multiplicar(a: number, b: number = 1): number {
    return a * b;
}

console.log(multiplicar(5));  // 5
console.log(multiplicar(5, 3));  // 15
```

Otro ejemplo: 

1. modificar el archivo `/funciones/index.html` para que importe el archivo `/funciones/args-default.js`.

2. Compilar el archivo `args-default.ts` para que genere (transpile) el archivo `args-default.js`

```bash
tsc args-default.ts
```

### Función con tipos complejos (objetos, arrays, interfaces)
Puedes usar tipos más complejos como objetos, arrays o interfaces para los parámetros y valores de retorno.

```typescript
interface Persona {
    nombre: string;
    edad: number;
}

function describirPersona(persona: Persona): string {
    return `${persona.nombre} tiene ${persona.edad} años.`;
}

const persona: Persona = { nombre: 'Ana', edad: 28 };
console.log(describirPersona(persona)); // Ana tiene 28 años.

```

### Función anónima (Arrow Function)
Las funciones también pueden escribirse en formato de arrow function.

```typescript
const dividir = (a: number, b: number): number => a / b;

console.log(dividir(10, 2)); // 5
```

### Función anónima (Arrow Function)
En TypeScript, los parámetros rest permiten a las funciones aceptar un número indefinido de argumentos como un array. Esto es útil cuando no sabes cuántos argumentos recibirá una función. Los parámetros rest se definen usando `...` seguido del nombre del parámetro.

```typescript
function sumarTodos(...numeros: number[]): number {
    return numeros.reduce((acumulador, numero) => acumulador + numero, 0);
}

console.log(sumarTodos(1, 2, 3)); // 6
console.log(sumarTodos(10, 20, 30, 40)); // 100
```

Otro ejemplo: 

1. modificar el archivo `/funciones/index.html` para que importe el archivo `/funciones/args-rest.js`.

2. Compilar el archivo `args-rest.ts` para que genere (transpile) el archivo `args-rest.js`

```bash
tsc args-rest.ts
```

## Clases
Las clases en TypeScript son una característica fundamental del lenguaje y permiten la definición de estructuras orientadas a objetos con soporte para el tipado estático, herencia, encapsulamiento y métodos. TypeScript extiende la sintaxis de las clases de JavaScript con características adicionales como tipos, modificadores de acceso y propiedades públicas o privadas.

### Definición básica de una clase

```typescript
class Persona {
    nombre: string;
    edad: number;

    constructor(nombre: string, edad: number) {
        this.nombre = nombre;
        this.edad = edad;
    }

    saludar(): void {
        console.log(`Hola, mi nombre es ${this.nombre} y tengo ${this.edad} años.`);
    }
}

const persona1 = new Persona("Juan", 30);
persona1.saludar(); // Hola, mi nombre es Juan y tengo 30 años.
```

Otro ejemplo: 

1. modificar el archivo `/clases/index.html` para que importe el archivo `/clases/basica.js`.

2. Compilar el archivo `basica.ts` para que genere (transpile) el archivo `basica.js`

```bash
tsc basica.ts
```

### Modificadores de acceso
TypeScript admite modificadores de acceso que permiten controlar la visibilidad de las propiedades y métodos de una clase:

- `public`: Propiedad o método accesible desde cualquier parte. (Es el valor predeterminado).
- `private`: Propiedad o método accesible solo desde dentro de la clase.
- `protected`: Similar a private, pero accesible también desde clases heredadas.

```typescript
class Empleado {
    public nombre: string;
    private salario: number;
    protected puesto: string;

    constructor(nombre: string, salario: number, puesto: string) {
        this.nombre = nombre;
        this.salario = salario;
        this.puesto = puesto;
    }

    public obtenerSalario(): number {
        return this.salario;
    }

    protected mostrarPuesto(): void {
        console.log(`El puesto de ${this.nombre} es ${this.puesto}`);
    }
}

const empleado1 = new Empleado("Ana", 5000, "Desarrolladora");
console.log(empleado1.nombre); // Ana
console.log(empleado1.obtenerSalario()); // 5000
// console.log(empleado1.puesto); // Error: 'puesto' es protected
```

### Herencia
TypeScript permite la herencia mediante la palabra clave `extends`. Las clases derivadas heredan tanto las propiedades como los métodos de la clase base.

```typescript
class Gerente extends Empleado {
    private departamento: string;

    constructor(nombre: string, salario: number, puesto: string, departamento: string) {
        super(nombre, salario, puesto); // Llamada al constructor de la clase base
        this.departamento = departamento;
    }

    public gestionar(): void {
        console.log(`${this.nombre} está gestionando el departamento de ${this.departamento}`);
    }

    public mostrarInformacion(): void {
        super.mostrarPuesto(); // Llamada a método protegido de la clase base
    }
}

const gerente1 = new Gerente("Carlos", 8000, "Gerente de TI", "Tecnología");
gerente1.gestionar(); // Carlos está gestionando el departamento de Tecnología
gerente1.mostrarInformacion(); // El puesto de Carlos es Gerente de TI
```

Otro ejemplo: 

1. modificar el archivo `/clases/index.html` para que importe el archivo `/clases/extends.js`.

2. Compilar el archivo `extends.ts` para que genere (transpile) el archivo `extends.js`

```bash
tsc extends.ts
```

### Propiedades y métodos estáticos
Las propiedades estáticas y los métodos estáticos se asocian a la clase en sí, no a una instancia específica.

```typescript
class Calculadora {
    static PI: number = 3.1416;

    static calcularAreaCirculo(radio: number): number {
        return Calculadora.PI * radio * radio;
    }
}

console.log(Calculadora.PI); // 3.1416
console.log(Calculadora.calcularAreaCirculo(5)); // 78.54
```

### Getters y Setters
Puedes definir getters y setters en una clase para controlar el acceso y la modificación de las propiedades.

```typescript
class Rectangulo {
    private _ancho: number;
    private _alto: number;

    constructor(ancho: number, alto: number) {
        this._ancho = ancho;
        this._alto = alto;
    }

    get area(): number {
        return this._ancho * this._alto;
    }

    set ancho(nuevoAncho: number) {
        if (nuevoAncho <= 0) {
            throw new Error("El ancho debe ser mayor a 0");
        }
        this._ancho = nuevoAncho;
    }
}

const rect = new Rectangulo(10, 5);
console.log(rect.area); // 50
rect.ancho = 20; // Cambia el ancho
console.log(rect.area); // 100
```

### Resumen
- Clases permiten la definición de estructuras orientadas a objetos.
- Modificadores de acceso (public, private, protected) controlan la visibilidad de propiedades y métodos.
- Herencia (extends) permite crear clases derivadas que heredan funcionalidad de una clase base.
- Propiedades estáticas son propiedades asociadas a la clase, no a una instancia.
- Getters y Setters permiten el acceso controlado a las propiedades.

## Interfaces
En TypeScript, las interfaces se utilizan para definir contratos o estructuras que los objetos deben cumplir. Una interfaz define la forma de un objeto, es decir, qué propiedades y métodos debe tener, pero no implementa la funcionalidad. Las interfaces son muy útiles para definir tipos más complejos en tus aplicaciones y garantizar que las clases o los objetos que las implementen cumplan con las reglas especificadas.

### Definición básica de una interfaz

```typescript
interface Persona {
    nombre: string;
    edad: number;
    saludar(): void;  // Método que debe estar presente
}

const persona1: Persona = {
    nombre: "Juan",
    edad: 25,
    saludar() {
        console.log(`Hola, mi nombre es ${this.nombre}`);
    }
};

persona1.saludar();  // Hola, mi nombre es Juan
```

Otro ejemplo: 

1. modificar el archivo `/interfaces/index.html` para que importe el archivo `/interfaces/basicas.js`.

2. Compilar el archivo `basicas.ts` para que genere (transpile) el archivo `basicas.js`

```bash
tsc basicas.ts
```

### Propiedades opcionales
Puedes hacer que algunas propiedades de una interfaz sean opcionales utilizando el operador `?`.

```typescript
interface Producto {
    nombre: string;
    precio: number;
    descripcion?: string;  // Propiedad opcional
}

const producto1: Producto = {
    nombre: "Laptop",
    precio: 1000
};

const producto2: Producto = {
    nombre: "Teléfono",
    precio: 500,
    descripcion: "Último modelo"
};

console.log(producto1);  // { nombre: 'Laptop', precio: 1000 }
console.log(producto2);  // { nombre: 'Teléfono', precio: 500, descripcion: 'Último modelo' }
```

### Propiedades opcionales
Las interfaces también pueden definir métodos que deben estar presentes en los objetos que implementen la interfaz.

```typescript
interface Animal {
    nombre: string;
    hacerSonido(): void;
}

class Perro implements Animal {
    nombre: string;

    constructor(nombre: string) {
        this.nombre = nombre;
    }

    hacerSonido(): void {
        console.log("Guau guau");
    }
}

const miPerro = new Perro("Firulais");
miPerro.hacerSonido();  // Guau guau
```

En este caso:
- La interfaz `Animal` define el método `hacerSonido`.
- La clase `Perro` que implementa la interfaz debe definir ese método.

### Propiedades opcionales
Las interfaces pueden extender otras interfaces, lo que permite reutilizar estructuras y añadir más propiedades o métodos.

```typescript
interface Persona {
    nombre: string;
    edad: number;
}

interface Empleado extends Persona {
    salario: number;
}

const empleado1: Empleado = {
    nombre: "Ana",
    edad: 30,
    salario: 5000
};

console.log(empleado1);  // { nombre: 'Ana', edad: 30, salario: 5000 }
```

Aquí, la interfaz `Empleado` extiende `Persona`, por lo que hereda las propiedades `nombre` y `edad`, y añade la propiedad `salario`.

### Interfaz para funciones
Puedes definir interfaces que describan el tipo de una función, incluyendo los tipos de parámetros y el valor de retorno.

```typescript
interface Calculadora {
    (a: number, b: number): number;
}

const sumar: Calculadora = (a: number, b: number) => a + b;
const multiplicar: Calculadora = (a: number, b: number) => a * b;

console.log(sumar(10, 20));  // 30
console.log(multiplicar(10, 20));  // 200
```

Otro ejemplo: 

1. modificar el archivo `/interfaces/index.html` para que importe el archivo `/interfaces/funciones.js`.

2. Compilar el archivo `funciones.ts` para que genere (transpile) el archivo `funciones.js`

```bash
tsc funciones.ts
```

### Implementación de múltiples interfaces
Una clase puede implementar varias interfaces al mismo tiempo, lo que obliga a que la clase implemente los métodos y propiedades de todas ellas.

```typescript
interface Volador {
    volar(): void;
}

interface Nadador {
    nadar(): void;
}

class Pato implements Volador, Nadador {
    volar(): void {
        console.log("El pato está volando.");
    }

    nadar(): void {
        console.log("El pato está nadando.");
    }
}

const pato = new Pato();
pato.volar();  // El pato está volando.
pato.nadar();  // El pato está nadando.
```

### Interfaces vs. Tipos
En TypeScript, tanto las **interfaces** como los **tipos** (type) se pueden usar para describir la forma de un objeto, pero las interfaces están más orientadas a contratos que pueden extenderse y son más flexibles para la herencia. Los type son más adecuados para definiciones complejas como uniones o intersecciones de tipos.

Diferencias clave:
- Las interfaces se pueden extender (con extends), mientras que los tipos se pueden combinar (con &).
- Los tipos pueden representar uniones, tipos literales, y otros tipos avanzados, mientras que las interfaces no.

### Resumen
- Las interfaces definen contratos para las estructuras de datos y permiten la reutilización de tipos.
- Puedes tener propiedades opcionales, de solo lectura, y definir métodos en las interfaces.
- Las interfaces pueden extenderse o combinarse entre sí, proporcionando flexibilidad.
- También pueden aplicarse a funciones, describiendo su tipo de parámetros y retorno.

## Clase Abstracta
Las clases abstractas en TypeScript proporcionan una estructura para las clases que no se pueden instanciar directamente, sino que sirven como base para otras clases. Las clases abstractas pueden definir métodos que deben ser implementados por las clases derivadas, así como métodos y propiedades comunes que serán compartidos por las subclases. Este enfoque es útil para modelar conceptos genéricos que luego se especializan en clases concretas.


### Definición de una clase abstracta
Para declarar una clase abstracta, se utiliza la palabra clave `abstract`. Una clase abstracta puede contener tanto métodos abstractos (que deben ser implementados en las subclases) como métodos concretos (que tienen una implementación).

```typescript
abstract class Animal {
    constructor(public nombre: string) {}

    // Método abstracto (sin implementación)
    abstract hacerSonido(): void;

    // Método concreto
    moverse(): void {
        console.log(`${this.nombre} está en movimiento.`);
    }
}

// Error: No se puede crear una instancia de una clase abstracta
// const animal = new Animal('Animal'); // Esto daría error
```

En este ejemplo:

- `Animal` es una clase abstracta que define el método abstracto `hacerSonido()`, que debe ser implementado por cualquier subclase.
- El método `moverse()` tiene una implementación y puede ser usado por las clases derivadas.

### Implementación de subclases
Las clases que extienden una clase abstracta deben proporcionar implementaciones para todos los métodos abstractos de la clase base.

```typescript
class Perro extends Animal {
    hacerSonido(): void {
        console.log("Guau guau");
    }
}

class Gato extends Animal {
    hacerSonido(): void {
        console.log("Miau miau");
    }
}

const miPerro = new Perro("Firulais");
miPerro.hacerSonido();  // Guau guau
miPerro.moverse();      // Firulais está en movimiento.

const miGato = new Gato("Michi");
miGato.hacerSonido();   // Miau miau
miGato.moverse();       // Michi está en movimiento.
```

### Métodos abstractos
Los métodos abstractos no tienen una implementación en la clase abstracta. Estos métodos deben ser implementados por cualquier clase que herede de la clase abstracta.

```typescript
abstract class Vehiculo {
    abstract arrancar(): void;
    abstract detener(): void;

    // Método concreto
    mover(): void {
        console.log("El vehículo está en movimiento.");
    }
}

class Coche extends Vehiculo {
    arrancar(): void {
        console.log("El coche ha arrancado.");
    }

    detener(): void {
        console.log("El coche se ha detenido.");
    }
}

const miCoche = new Coche();
miCoche.arrancar();  // El coche ha arrancado.
miCoche.mover();     // El vehículo está en movimiento.
miCoche.detener();   // El coche se ha detenido.
```

### Resumen de características clave de las clases abstractas:
- **No se pueden instanciar directamente:** No puedes crear una instancia de una clase abstracta.
- **Métodos y propiedades abstractas:** Los métodos o propiedades abstractas no tienen implementación en la clase abstracta y deben ser implementados en las clases derivadas.
- **Métodos concretos:** Una clase abstracta puede contener métodos concretos con implementación que las subclases heredan.
- **Herencia obligatoria:** Cualquier clase que herede de una clase abstracta debe proporcionar una implementación de todos los métodos abstractos.

Las clases abstractas son una excelente herramienta cuando deseas crear una estructura común para un grupo de clases relacionadas, donde algunas funcionalidades se deben implementar de forma específica en cada subclase.