package com.test.bbva.dto;

import lombok.Data;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Data
public class ClienteDTO {

    @NotBlank(message = "El primer nombre es obligatorio")
    private String primerNombre;

    private String segundoNombre;

    @NotBlank(message = "El primer apellido es obligatorio")
    private String primerApellido;

    private String segundoApellido;

    private String telefono;

    private String direccion;

    @NotBlank(message = "La ciudad de residencia es obligatoria")
    private String ciudadResidencia;

    @Email(message = "El correo debe ser válido")
    private String correo;
}

