# Introducción a Node.js y npm

## 📘 Objetivo de la clase
Aprender los fundamentos de **Node.js** y **npm**, comprendiendo cómo se configuran proyectos JavaScript del lado del servidor y cómo se gestionan dependencias, scripts y módulos.  
Esta base será esencial antes de avanzar hacia **TypeScript** y arquitecturas más complejas.

---

## 🧩 1. ¿Qué es Node.js?

**Node.js** es un entorno de ejecución que permite ejecutar código JavaScript fuera del navegador (por ejemplo, en un servidor o terminal).

👉 En otras palabras, gracias a Node.js, podemos usar JavaScript para:
- Crear **servidores web**.
- Automatizar tareas o scripts.
- Construir herramientas de línea de comandos.
- Crear **APIs REST** o **aplicaciones backend completas**.

Node se basa en:
- **Motor V8** de Google Chrome (para ejecutar JS).
- **Event Loop**: maneja operaciones de forma **asíncrona y no bloqueante**.

### 🔍 Verificar instalación

```bash
node -v
npm -v
```

Si no lo tienes instalado, descárgalo desde:  
👉 [https://nodejs.org](https://nodejs.org)

---

## 📦 2. ¿Qué es npm?

**npm (Node Package Manager)** es el gestor de paquetes que viene con Node.js.  
Permite instalar librerías y frameworks de terceros, o publicar tus propios módulos.

Ejemplo:
```bash
npm install express
```

Esto descarga e instala la librería `express` (un framework para crear servidores web).

---

## 🏗️ 3. Crear un proyecto Node.js

### Paso 1: Crear una carpeta de proyecto
```bash
mkdir mi-proyecto-node
cd mi-proyecto-node
```

### Paso 2: Inicializar el proyecto
```bash
npm init -y
```

Esto genera un archivo **`package.json`** que contiene la información del proyecto, scripts y dependencias.

Ejemplo:
```json
{
  "name": "mi-proyecto-node",
  "version": "1.0.0",
  "main": "index.js",
  "scripts": {
    "start": "node index.js"
  }
}
```

---

## 📂 4. Crear tu primer script con Node.js

Crea un archivo `index.js`:

```js
console.log("👋 ¡Hola desde Node.js!");
```

Ejecuta:
```bash
node index.js
```

Salida esperada:
```
👋 ¡Hola desde Node.js!
```

---

## ⚙️ 5. Importar y exportar módulos

Node.js usa el sistema de módulos **CommonJS** (`require`) y también soporta **ES Modules** (`import/export`).

### 🔸 CommonJS (forma tradicional)
**math.js**
```js
function sumar(a, b) {
  return a + b;
}

module.exports = { sumar };
```

**index.js**
```js
const { sumar } = require('./math');
console.log(sumar(2, 3)); // 5
```

### 🔸 ES Modules (moderno)
Usa `"type": "module"` en el `package.json`:

```json
{
  "type": "module"
}
```

**math.js**
```js
export function sumar(a, b) {
  return a + b;
}
```

**index.js**
```js
import { sumar } from './math.js';
console.log(sumar(10, 5)); // 15
```

---

## 📚 6. Instalar dependencias

### 🔹 Dependencias de producción
```bash
npm install express
```

### 🔹 Dependencias de desarrollo
```bash
npm install nodemon --save-dev
```

Esto agrega las librerías al `package.json`:
```json
"dependencies": {
  "express": "^4.18.2"
},
"devDependencies": {
  "nodemon": "^3.0.1"
}
```

### 🔹 Ejecutar con nodemon
Agrega en `package.json`:
```json
"scripts": {
  "start": "node index.js",
  "dev": "nodemon index.js"
}
```

Y ejecuta:
```bash
npm run dev
```

---

## 🌐 7. Crear un servidor web simple

Crea `index.js`:

```js
const http = require('http');

const server = http.createServer((req, res) => {
  res.writeHead(200, { 'Content-Type': 'text/plain' });
  res.end('¡Hola desde mi servidor Node.js!');
});

server.listen(3000, () => {
  console.log('🚀 Servidor escuchando en http://localhost:3000');
});
```

Ejecuta:
```bash
npm start
```

Abre en tu navegador:  
👉 [http://localhost:3000](http://localhost:3000)

---

## ⚡ 8. Usando Express.js (framework web)

Instala:
```bash
npm install express
```

Crea `index.js`:

```js
const express = require('express');
const app = express();
const PORT = 3000;

app.get('/', (req, res) => {
  res.send('🚀 Servidor Express funcionando correctamente');
});

app.listen(PORT, () => {
  console.log(`Servidor corriendo en http://localhost:${PORT}`);
});
```

Ejecuta:
```bash
npm start
```

---

## 🧰 9. Scripts útiles en package.json

```json
"scripts": {
  "start": "node index.js",
  "dev": "nodemon index.js",
  "test": "echo \"Ejecutando tests...\""
}
```

Ejemplo de ejecución:
```bash
npm run dev
npm run test
```

---

## 🧑‍💻 10. Ejercicio práctico

1. Crear un proyecto nuevo con:
   ```bash
   npm init -y
   npm install express
   npm install nodemon --save-dev
   ```

2. Crear un servidor Express con 3 rutas:
   - `/` → retorna un saludo
   - `/saludo/:nombre` → retorna “Hola, {nombre}”
   - `/fecha` → retorna la fecha actual

3. Configurar script `"dev": "nodemon index.js"` y ejecutarlo.

4. Probar las rutas en el navegador o con `curl`:
   ```bash
   curl http://localhost:3000/
   curl http://localhost:3000/saludo/Emilio
   curl http://localhost:3000/fecha
   ```

---

## 🧠 11. Conceptos clave para recordar

| Concepto | Descripción |
|-----------|--------------|
| `Node.js` | Entorno para ejecutar JS fuera del navegador |
| `npm` | Gestor de paquetes |
| `package.json` | Archivo de configuración del proyecto |
| `module.exports` / `require` | Exportar e importar módulos (CommonJS) |
| `import` / `export` | Exportar e importar módulos (ESM) |
| `scripts` | Comandos personalizados del proyecto |
| `dependencies` | Librerías necesarias para el proyecto |
| `devDependencies` | Librerías usadas solo en desarrollo |

---

## 🚀 12. Próximos pasos

Después de dominar Node.js y npm, el siguiente paso es aprender:
- **TypeScript:** para agregar tipado estático y mayor robustez.
- **Express avanzado:** middlewares, rutas, validaciones.
- **APIs RESTful y persistencia (MySQL, MongoDB).**

---

## 🧾 Recursos recomendados

- [Node.js Official Docs](https://nodejs.org/en/docs/)
- [npm Documentation](https://docs.npmjs.com/)
- [Express.js Guide](https://expressjs.com/)
- [MDN JavaScript Reference](https://developer.mozilla.org/es/docs/Web/JavaScript)


---

## 📘 13. Diferencia entre `package.json` y `package-lock.json`

### 📦 `package.json`

Archivo principal de configuración del proyecto Node.js.  
Define qué dependencias usa, qué scripts puede ejecutar y la información básica del proyecto.

Ejemplo:
```json
{
  "name": "mi-proyecto-node",
  "version": "1.0.0",
  "scripts": {
    "start": "node index.js",
    "dev": "nodemon index.js"
  },
  "dependencies": {
    "express": "^4.18.2"
  },
  "devDependencies": {
    "nodemon": "^3.0.1"
  }
}
```

🟢 Puede editarse manualmente.

---

### 🔒 `package-lock.json`

Se genera automáticamente cuando instalas dependencias con `npm install`.  
Guarda las **versiones exactas** de todas las dependencias y sus subdependencias.

Ejemplo simplificado:
```json
{
  "name": "mi-proyecto-node",
  "lockfileVersion": 3,
  "packages": {
    "node_modules/express": {
      "version": "4.18.2",
      "resolved": "https://registry.npmjs.org/express/-/express-4.18.2.tgz",
      "integrity": "sha512-..."
    }
  }
}
```

🔒 No debe editarse manualmente.

---

### 🧠 Resumen

| Archivo | Función | Editable | Generado automáticamente | Incluye |
|----------|----------|----------|--------------------------|----------|
| `package.json` | Define el proyecto, scripts y dependencias declaradas | ✅ Sí | 🚫 No | Versiones **aproximadas** (`^`, `~`) |
| `package-lock.json` | Registra las versiones exactas instaladas | 🚫 No | ✅ Sí | Versiones **exactas** de todas las dependencias |

---

### 💡 Ejemplo práctico

Si en tu `package.json` tenés:
```json
"dependencies": {
  "express": "^4.18.2"
}
```
El símbolo `^` indica:  
> Instalar cualquier versión **compatible** con 4.18.x (pero no 5.x).

Entonces, `npm install` podría traer `4.18.3` o `4.18.4`.  
El archivo `package-lock.json` **asegura que todos los entornos usen exactamente la misma versión (por ejemplo, 4.18.2)**.

---

© 2025 - Capacitación de Desarrollo de Software - UTN FRLP