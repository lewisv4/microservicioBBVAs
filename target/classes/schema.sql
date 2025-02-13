CREATE TABLE cliente (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         tipo_documento VARCHAR(255),
                         numero_documento VARCHAR(255),
                         primer_nombre VARCHAR(255),
                         segundo_nombre VARCHAR(255),
                         primer_apellido VARCHAR(255),
                         segundo_apellido VARCHAR(255),
                         telefono VARCHAR(255),
                         direccion VARCHAR(255),
                         ciudad_residencia VARCHAR(255),
                         correo_electronico VARCHAR(255)
);