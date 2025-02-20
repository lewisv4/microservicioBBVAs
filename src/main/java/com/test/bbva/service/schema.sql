CREATE TABLE clientes (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          tipo_documento VARCHAR(2) NOT NULL,
                          numero_documento VARCHAR(20) NOT NULL UNIQUE,
                          primer_nombre VARCHAR(50),
                          segundo_nombre VARCHAR(50),
                          primer_apellido VARCHAR(50),
                          segundo_apellido VARCHAR(50),
                          telefono VARCHAR(20),
                          direccion VARCHAR(100),
                          ciudad_residencia VARCHAR(50),
                          correo VARCHAR(100)
);
