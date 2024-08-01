# Aplicación Web en Docker

**Objetivo:**  Crear su propia imagen de Docker usando un `Dockerfile`.

# Ejemplo

1. Crear una aplicación web simple.
Escribir el archivo `index.html`con el siguiente contenido:

```html
<!DOCTYPE html>
<html>
<head>
    <title>Página de Ejemplo</title>
</head>
<body>
    <h1>¡Hola desde Docker!</h1>
</body>
</html>
```

2. Crea un archivo llamado `Dockerfile` en el mismo directorio que `index.html` con el siguiente contenido:

```bash
# Usa la imagen base de Nginx
FROM nginx:alpine

# Copia el archivo HTML al directorio de Nginx
COPY index.html /usr/share/nginx/html/index.html
```

3. Construir la imagen de Docker:

```bash
docker build -t mi-web .
```

### Explicación:

- `-t mi-web`: Asigna el nombre `mi-web` a la imagen.
- `.`: Indica que el contexto de construcción es el directorio actual.

### Ejecutar el contenedor:

- Usa el siguiente comando para ejecutar el contenedor con la imagen creada:

```bash
docker run --name mi-web-server -d -p 8080:80 mi-web
```

### Verificar el resultado:

- Abre un navegador web y accede a http://localhost:8080. Deberías ver la página personalizada con el mensaje "¡Hola desde Docker!"