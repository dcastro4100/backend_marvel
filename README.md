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

## Estructura de base de datos


CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE roles (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL,
    PRIMARY KEY ( id )
) ENGINE = InnoDB CHARACTER SET utf8;
 
CREATE TABLE users_roles (
    user_id BIGINT NOT NULL ,
    role_id BIGINT NOT NULL
) ENGINE = InnoDB CHARACTER SET utf8;
 
ALTER TABLE roles
ADD CONSTRAINT UK_roles_name
UNIQUE (name);
 
ALTER TABLE users_roles
ADD CONSTRAINT UK_user_id_roles_id
UNIQUE (user_id, role_id);
 
ALTER TABLE users_roles
ADD CONSTRAINT FK_users_roles_roles_id
FOREIGN KEY (role_id) REFERENCES roles(id);
 
ALTER TABLE users_roles
ADD CONSTRAINT FK_users_roles_user_id
FOREIGN KEY (user_id) REFERENCES users(id);

CREATE TABLE `api_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `endpoint` varchar(255) NOT NULL,
  `http_method` varchar(255) NOT NULL,
  `request_body` text,
  `request_headers` text,
  `response_body` text,
  `response_status` int(11) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


insert into roles(name) values('ROLE_USER'),('ROLE_ADMIN');

insert into users values
('1','jperez','jperez@gmail.com','$2a$10$Rg4EAgKiOhfxNUT0/0u3Eud9af2T5huvDrgwW46JNcKSS2G10ure2'),
('2','johan.perez','johan.perez@gmail.com','$2a$10$6s/50vavk4c1U.yYz8fJI.DRWUL0VycjRLZTJ1jzzBSXqJXakEMIy');

insert into users_roles values('2','2');
insert into users_roles values('1','1');


## Credenciales de prueba

URL: {{base_url}}/login


{
	"username": "johan.perez",
    "password":"P@ssw0rd"
}


{
	"username": "jperez",
    "password":"P@ssw0rd"
}


## Documentacion de API
La documentacion ha sido realizada con swagger y la encontrara en la siguiente URL

http://localhost:8080/doc/swagger-ui/index.html




## Arquitectura Modular del Proyecto
El proyecto está diseñado con una arquitectura modular, lo que significa que se organiza en módulos independientes que facilitan la escalabilidad, mantenibilidad y reutilización del código. Cada módulo tiene una responsabilidad específica y se comunica con otros módulos mediante interfaces bien definidas. Esto permite desarrollar, probar y desplegar módulos de forma aislada.

La aplicación utiliza el marco Spring Boot, que simplifica la configuración y el desarrollo de aplicaciones Java, proporcionando una base robusta y extensible. Además, se implementan diversas librerías para cubrir aspectos clave como persistencia de datos, seguridad, comunicación entre servicios, validación y generación de documentación.


## Principales Bibliotecas Utilizadas
### Persistencia de Datos:

spring-boot-starter-data-jpa: Proporciona una integración con JPA para manejar operaciones con bases de datos relacionales de forma sencilla y eficiente.
mysql-connector-j: Permite la conexión a bases de datos MySQL.
Seguridad:

spring-boot-starter-security: Facilita la configuración y gestión de seguridad en la aplicación, incluyendo autenticación y autorización.
io.jsonwebtoken (jjwt-api, jjwt-impl, jjwt-jackson): Manejo de JSON Web Tokens (JWT) para implementar autenticación basada en tokens.
### Desarrollo Web:

spring-boot-starter-web: Soporte para el desarrollo de aplicaciones web basadas en Spring MVC, incluyendo APIs REST.
spring-cloud-starter-openfeign: Facilita la comunicación entre servicios mediante clientes HTTP declarativos.
### Validación:

spring-boot-starter-validation: Permite realizar validaciones de datos de entrada utilizando anotaciones como @NotNull, @Size, entre otras.
### Documentación:

springdoc-openapi-starter-webmvc-ui: Proporciona integración con OpenAPI/Swagger para generar documentación interactiva de la API REST.

### Herramientas de Desarrollo:

spring-boot-devtools: Mejora la experiencia de desarrollo con características como recarga automática de cambios.

### Notas adicionales

- La configuración de la base de datos MySQL ya está incluida en un contenedor Docker, lo que simplifica el proceso de configuración.
- Asegúrate de que el archivo `.env` esté correctamente configurado antes de iniciar los contenedores para evitar errores de conexión.


¡Listo para usar! 🚀
