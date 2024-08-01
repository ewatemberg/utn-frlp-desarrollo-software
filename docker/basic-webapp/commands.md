# Aplicación Web en Docker

**Objetivo:** Mostrar cómo contenerizar una aplicación web simple utilizando una imagen de un servidor web.

# Ejemplo

1. Usa el siguiente comando para ejecutar un contenedor que sirva una página web simple con Nginx:

```bash
docker run --name web-server -d -p 8080:80 nginx
```
### Explicación:

- `--name web-server`: Asigna un nombre al contenedor.
- `-d`: Ejecuta el contenedor en segundo plano (modo "detached").
- `-p 8080:80`: Mapea el puerto 80 del contenedor al puerto 8080 del host.

### Verificar el resultado:

Abre un navegador web y accede a http://localhost:8080. Deberías ver la página de bienvenida de Nginx.

### Detener y eliminar el contenedor:

- Para detener el contenedor

```bash
docker stop web-server
```

- Para eliminar el contenedor

```bash
docker rm web-server
```