# Prueba Técnica - Backend con Spring Boot

Este proyecto es una implementación técnica basada en Spring Boot para una tienda de franquicias con funcionalidades CRUD. El objetivo es manejar entidades como **Franquicias** y **Sucursales**, además de exponer endpoints para realizar operaciones clave.

---

## **Requisitos Previos**

1. **Herramientas Necesarias:**

    - JDK 17 o superior.
    - Apache Maven.
    - IntelliJ IDEA (opcional).
    - MySQL (base de datos).
    - Git (para control de versiones).

2. **Configuración de MySQL:**

    - Crea una base de datos en MySQL:
      ```sql
      CREATE DATABASE prueba_tecnica;
      ```
    - me Actualiza el archivo `application.properties` con las credenciales de tu base de datos:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/prueba_tecnica
      spring.datasource.username=tu_usuario
      spring.datasource.password=tu_contraseña
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      ```

---

## **Paso a Paso del Desarrollo**

### **1. Configuración Inicial del Proyecto**

1. Crea un proyecto Spring Boot usando [Spring Initializr](https://start.spring.io/):

    - Dependencias necesarias:
        - Spring Web
        - Spring Data JPA
        - MySQL Driver
        - Lombok


### **2. Ejecución del Proyecto**

1. Compila y ejecuta el proyecto:
    -
    Ejecutar con IDE de desarrollo
   ```bash
   mvn spring-boot:run
   ```
   Compilar con docker
   ```bash
   mvn clean package
   docker build -t prueba-backend .
   docker run -p 8080:8080 prueba-backend
   docker-compose up --build
   docker-compose down



   ```

2. Accede al endpoint en Postman o cURL:

    - **URL:** `POST /api/franquicias/crear`
    - **Body:**
      ```json
      {
        "nombre": "Centro"
      }
      ```

3. Verifica que la franquicia se haya agregado correctamente en la base de datos.

---

### **3. Opcional: Endpoints Adicionales**

- **Obtener el producto con más stock por sucursal:**

  Implementa un endpoint para obtener el producto con más stock por sucursal para una franquicia puntual.

- **Gestor de Terraform:**
  Puedes integrar Terraform para gestionar la infraestructura de tu base de datos en la nube (Hostinger).

## **Notas Finales**

- Asegúrate de incluir un archivo `.gitignore` para evitar subir archivos innecesarios como `target/` o configuraciones locales.
- Verifica que los datos sean validados correctamente antes de guardar en la base de datos.

¡Buena suerte! Si tienes alguna duda, no dudes en consultarme.

