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

URL: POST http://localhost:8090/api/clientes/C/98765432
Body (JSON):
{
  "primerNombre": "Pedro",
  "segundoNombre": "Luis",
  "primerApellido": "González",
  "segundoApellido": "Ruiz",
  "telefono": "3205556789",
  "direccion": "Carrera 90 #15-20",
  "ciudadResidencia": "Bogotá",
  "correo": "pedro@example.com"
}


Actualizar un Cliente

PUT http://localhost:8090/api/clientes/C/98765432

{
  "primerNombre": "Pedro",
  "segundoNombre": "Luis",
  "primerApellido": "Gómez",
  "segundoApellido": "Ruiz",
  "telefono": "3009998888",
  "direccion": "Carrera 100 #20-30",
  "ciudadResidencia": "Cali",
  "correo": "pedro.gomez@example.com"
}



Eliminar un Cliente

curl -X DELETE "http://localhost:8080/api/clientes/C/123456789"

Consultar un Cliente

http://localhost:8090/api/clientes/C/12345678

Base de Datos H2

Para acceder a la consola H2, ingresa en:

http://localhost:8090/h2-console
JDBC URL: jdbc:h2:mem:bbva_db
User Name: sa
Password: 

Configuración de la Base de Datos

JDBC URL: jdbc:h2:mem:testdb

Usuario: sa

Contraseña: (dejar en blanco)


Ejecutar el jar

java -jar target/tu-app-0.0.1-SNAPSHOT.jar

Ubicacion del jar 
bbva\target

