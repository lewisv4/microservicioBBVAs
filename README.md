Servicio REST para Gestión de Clientes

Este servicio REST permite gestionar clientes mediante operaciones CRUD.

Requisitos

Java 17

Maven 4.x

Instalación y Ejecución

Clona el repositorio:

git clone https://github.com/lewisv4/microservicioBBVAs.git
cd microservicioBBVAs

Construye el proyecto:

mvn clean package

Inicia la aplicación:

java -jar target/demo-0.0.1-SNAPSHOT.jar

Endpoints Disponibles

Crear un Cliente

curl -X POST "http://localhost:8080/api/clientes" \
     -H "Content-Type: application/json" \
     -d '{
        "tipoDocumento": "C",
        "numeroDocumento": "123456789",
        "primerNombre": "Juan",
        "segundoNombre": "Carlos",
        "primerApellido": "Perez",
        "segundoApellido": "Gomez",
        "telefono": "3001234567",
        "direccion": "Calle 123",
        "ciudadResidencia": "Bogota",
        "correoElectronico": "juan.perez@example.com"
     }'

Actualizar un Cliente

curl -X PUT "http://localhost:8080/api/clientes/C/123456789" \
     -H "Content-Type: application/json" \
     -d '{
        "primerNombre": "Juan",
        "segundoNombre": "Carlos",
        "primerApellido": "Perez",
        "segundoApellido": "Gomez",
        "telefono": "3001234567",
        "direccion": "Calle 456",
        "ciudadResidencia": "Medellin",
        "correoElectronico": "juan.perez@example.com"
     }'

Eliminar un Cliente

curl -X DELETE "http://localhost:8080/api/clientes/C/123456789"

Consultar un Cliente

curl -X GET "http://localhost:8080/api/clientes/C/123456789?withAddress=true"

Base de Datos H2

Para acceder a la consola H2, ingresa en:

http://localhost:8090/h2-console

Configuración de la Base de Datos

JDBC URL: jdbc:h2:mem:testdb

Usuario: sa

Contraseña: (dejar en blanco)
