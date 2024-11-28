# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Configurar directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar solo los archivos necesarios para descargar dependencias primero
COPY pom.xml ./
COPY .mvn ./.mvn
COPY mvnw ./
RUN ./mvnw dependency:resolve

# Copiar el resto del código
COPY src ./src

# Exponer el puerto de la aplicación
EXPOSE 8080

# Comando para iniciar la aplicación en modo desarrollo
CMD ["./mvnw", "spring-boot:run"]