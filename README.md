# API Marvel - Búsqueda de Superhéroes

Este proyecto es un backend que permite realizar búsquedas de superhéroes utilizando datos de Marvel. 

## Requisitos previos

Antes de empezar, asegúrate de tener instalado lo siguiente:

- [Docker](https://www.docker.com/) y [Docker Compose](https://docs.docker.com/compose/).
- Archivo `.env` configurado según las instrucciones descritas a continuación.

## Configuración

### 1. Crear archivo `.env`
Crea un archivo `.env` en la raíz del proyecto basado en el archivo de ejemplo `.env.example`. 

Debes configurar:

- Credenciales de la base de datos MySQL (contenedor Docker).
- Variables de entorno necesarias para que la aplicación se conecte correctamente a la base de datos.

### 2. Construir y levantar el backend
1. Accede a la raíz del proyecto:
   ```bash
   cd /ruta/al/proyecto

2. Construye la imagen del contenedor
   ```bash
   docker compose build
3. Levanta el contenedor en segundo plano:
   ```bash
   docker compose up -d

### Uso
La aplicación está configurada para escuchar en el puerto 8080 por defecto. Para realizar peticiones al backend, utiliza la siguiente URL:
   ```bash
   http://localhost:8080
   ```

### Cambiar el puerto
Si necesitas cambiar el puerto predeterminado, edita el archivo docker-compose.yml en la línea 25:
   ```bash
    ports:
      - "8080:8080"
   ```

Modifica el primer valor (el puerto del host) por el puerto deseado. Por ejemplo, para usar el puerto 8084:
   ```bash
    ports:
     - "8084:8080"
   ```

Luego, reinicia los contenedores para aplicar el cambio:
   ```bash
docker compose down
docker compose up -d
   ```
## Notas adicionales

- La configuración de la base de datos MySQL ya está incluida en un contenedor Docker, lo que simplifica el proceso de configuración.
- Asegúrate de que el archivo `.env` esté correctamente configurado antes de iniciar los contenedores para evitar errores de conexión.


¡Listo para usar! 🚀
