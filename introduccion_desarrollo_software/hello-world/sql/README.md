# "Hello, World!"
Ejemplo sencillo de cómo escribir un programa "Hello, World!" en MySQL.




## Cómo ejecutar el programa ✏️

Es necesario tener instalado el motor de BD [MySQL](https://www.mysql.com/downloads/). Podemos optar por descargar el instalador o ejecutar un contenedor [Docker](https://hub.docker.com/_/mysql).

1.  Primero, debes asegurarte de tener Docker instalado en tu sistema. Luego, ejecuta el siguiente comando para iniciar un contenedor de MySQL:

```bash
docker run --name mysql-hello-world -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
```

- `--name mysql-hello-world`: Le da un nombre al contenedor.
- `-e MYSQL_ROOT_PASSWORD=my-secret-pw`: Establece la contraseña del usuario root de MySQL.
- `-d mysql:latest`: Ejecuta el contenedor en segundo plano con la última versión de MySQL.

2.  Una vez que el contenedor esté en ejecución, puedes acceder a él usando el siguiente comando:

```bash
docker exec -it mysql-hello-world mysql -uroot -p
```

- `exec -it`: Ejecuta un comando en un contenedor en modo interactivo.
- `mysql-hello-world`: Es el nombre del contenedor.
- `mysql -uroot -p`: Abre la interfaz de línea de comandos de MySQL, solicitando la contraseña del usuario root.

3.  Una vez que estés dentro del CLI de MySQL, puedes crear una base de datos y una tabla para almacenar el mensaje "Hello, World!".

```sql
CREATE DATABASE HelloWorldDB;
USE HelloWorldDB;

CREATE TABLE greetings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    message VARCHAR(255) NOT NULL
);

INSERT INTO greetings (message) VALUES ('Hello, World!');

```

4. Consultar el mensaje "Hello, World!"
```sql
SELECT * FROM greetings;
```

Esto debería devolver algo como:
```diff
+----+-------------+
| id | message     |
+----+-------------+
|  1 | Hello, World! |
+----+-------------+

```

5.  (Opcional) Detener y eliminar el contenedor. Cuando hayas terminado, puedes detener y eliminar el contenedor con los siguientes comandos:

```bash
docker stop mysql-hello-world
docker rm mysql-hello-world
```