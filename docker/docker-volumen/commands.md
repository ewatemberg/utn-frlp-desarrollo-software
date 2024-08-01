# Persistencia de Datos con Volúmenes de Docker

**Objetivo:** Demostrar cómo utilizar volúmenes para persistir datos entre reinicios de contenedores.

# Ejemplo

1. Ejecutar un contenedor de MySQL con un volumen. Usa el siguiente comando para ejecutar un contenedor de MySQL con un volumen.

```bash
docker run --name mi-mysql -e MYSQL_ROOT_PASSWORD=example -d -v mi-datos:/var/lib/mysql mysql:5.7
```

#### Explicación:

- `-v mi-datos:/var/lib/mysql`: Crea un volumen llamado mi-datos y lo mapea al directorio de datos de MySQL en el contenedor.


2. Verificar la persistencia de datos:

- Detén el contenedor:

```bash
docker stop mi-mysql
```

- Vuelve a iniciar el contenedor:

```bash
docker start mi-mysql
```

Los datos almacenados en el volumen `mi-datos` persistirán incluso después de detener y eliminar el contenedor.