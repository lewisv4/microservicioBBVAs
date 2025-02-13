package com.test.bbva.service;


import com.test.bbva.model.Cliente;
import com.test.bbva.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener un cliente por tipo y número de documento
    public Cliente getCliente(String tipoDocumento, String numeroDocumento) {
        return clienteRepository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
    }

    // Crear un nuevo cliente
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public Cliente updateCliente(String tipoDocumento, String numeroDocumento, Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
        if (clienteExistente != null) {
            // Actualiza los campos del cliente existente con los nuevos datos
            clienteExistente.setPrimerNombre(cliente.getPrimerNombre());
            clienteExistente.setSegundoNombre(cliente.getSegundoNombre());
            clienteExistente.setPrimerApellido(cliente.getPrimerApellido());
            clienteExistente.setSegundoApellido(cliente.getSegundoApellido());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setCiudadResidencia(cliente.getCiudadResidencia());
            clienteExistente.setCorreoElectronico(cliente.getCorreoElectronico());

            return clienteRepository.save(clienteExistente);
        }
        return null; // Si no se encuentra el cliente, retorna null
    }

    // Eliminar un cliente
    public boolean deleteCliente(String tipoDocumento, String numeroDocumento) {
        Cliente clienteExistente = clienteRepository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
        if (clienteExistente != null) {
            clienteRepository.delete(clienteExistente);
            return true; // Cliente eliminado
        }
        return false; // Cliente no encontrado
    }
}