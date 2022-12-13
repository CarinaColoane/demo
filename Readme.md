
<!-- ABOUT THE PROJECT -->
## Acerca del proyecto

La siguiente demo trata de una API RESTful de creación de usuarios en Spring Boot. Se utilizo Gradle para su construcción, H2 para la base de datos en memoria y Hibernate (JPA) para la persistencia de datos.

Diagrama de la solución:
![Diagrama Demo](ejercicio.jpg)


### Construido con

* Spring boot / Java
* Gradle
* H2


<!-- GETTING STARTED -->
## Getting Started

### Prerequisitos

- Considerar las siguientes versiones con las cuales se trabajó:
    - Java 11
    - Spring Boot 2.5.14
    - H2 2.1.212

<!-- TODO -->
### Instalación
1. Clonar el repo y situarse en el directorio raiz
2. Ejecutar el proyecto
   ```sh
   ./gradlew bootRun
   ```
3. Probar método POST en el endpoint http://localhost:8080/user/create , con body de ejemplo:
   ```sh
   {
    "name": "namePost",
    "email": "mail1@post.cl",
    "password": "passPost1",
    "phones": [
        {
            "number": "11121678",
            "cityCode": "9",
            "countryCode": "45"
        }
    ]
    }
   ```
4. Para probar los Test (groovy) OLD.
   ```sh
   ./gradlew test
   ```


<!-- CONTACT -->
## Contacto

carina flores coloane
