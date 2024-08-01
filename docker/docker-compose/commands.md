# Docker Compose con una Aplicación Multi-Contenedor

**Objetivo:** Mostrar cómo utilizar Docker Compose para orquestar una aplicación compuesta por múltiples servicios, como un servidor web y una base de datos.

# Ejemplo

1. Crear una aplicación web que use una base de datos en un directorio llamado `mi_aplicacion`.

2. Dentro del directorio `mi_aplicacion`, crea un archivo llamado `docker-compose.yml` con el siguiente contenido:

```bash
version: '3.8'
services:
  web:
    image: nginx:alpine
    ports:
      - "8080:80"
    volumes:
      - ./html:/usr/share/nginx/html

  db:
    image: mysql:5.7
    environment:
      MYSQL_ROOT_PASSWORD: example
      MYSQL_DATABASE: ejemplo_db
```
#### Explicación:

- Define dos servicios: `web` y `db`.
- El servicio `web` usa la imagen de Nginx y mapea el puerto 80 del contenedor al puerto 8080 del host.
- El servicio `db` usa la imagen de MySQL con algunas variables de entorno para .


3. Crear el directorio `html` y el archivo `index.html`:
- Dentro del directorio `mi_aplicacion`, crea un directorio llamado `html`.
- Dentro del directorio `html`, crea un archivo `index.html` con el siguiente contenido:

```bash
<!DOCTYPE html>
<html>
<head>
    <title>Página de Ejemplo</title>
</head>
<body>
    <h1>¡Aplicación Multi-Contenedor!</h1>
</body>
</html>
```

3. Ejecutar Docker Compose:

```bash
docker-compose up -d
```

#### Explicación:

- Este comando levanta todos los servicios definidos en docker-compose.yml en segundo plano.


5. Verificar el resultado:

- Abre un navegador web y accede a http://localhost:8080. Deberías ver la página web servida por Nginx.

6. Detener y eliminar los contenedores:

```bash
docker-compose down
```