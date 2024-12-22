# Usar la imagen oficial de OpenJDK 23
FROM openjdk:23-jdk-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/pruebaBackend-0.0.1-SNAPSHOT.jar myapp.jar

# Exponer el puerto en el que Spring Boot ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "myapp.jar"]