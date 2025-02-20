package com.test.bbva.service;


import com.test.bbva.dto.ClienteDTO;
import com.test.bbva.model.Cliente;
import com.test.bbva.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    // Obtener cliente
    public ClienteDTO obtenerCliente(String tipoDocumento, String numeroDocumento, boolean withAddress) {
        Optional<Cliente> clienteOpt = repository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
        return clienteOpt.map(cliente -> mapToDTO(cliente, withAddress)).orElse(null);
    }

    // Crear cliente (POST)
    public Cliente crearCliente(ClienteDTO dto, String tipoDocumento, String numeroDocumento) {
        Cliente cliente = new Cliente();
        cliente.setTipoDocumento(tipoDocumento);
        cliente.setNumeroDocumento(numeroDocumento);
        return mapToEntity(dto, cliente);
    }

    // Actualizar cliente (PUT)
    public Cliente actualizarCliente(String tipoDocumento, String numeroDocumento, ClienteDTO dto) {
        Optional<Cliente> clienteOpt = repository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            return mapToEntity(dto, cliente);
        }
        return null;
    }

    // Métodos auxiliares
    private Cliente mapToEntity(ClienteDTO dto, Cliente cliente) {
        cliente.setPrimerNombre(dto.getPrimerNombre());
        cliente.setSegundoNombre(dto.getSegundoNombre());
        cliente.setPrimerApellido(dto.getPrimerApellido());
        cliente.setSegundoApellido(dto.getSegundoApellido());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());
        cliente.setCiudadResidencia(dto.getCiudadResidencia());
        cliente.setCorreo(dto.getCorreo());
        return repository.save(cliente);
    }

    private ClienteDTO mapToDTO(Cliente cliente, boolean withAddress) {
        ClienteDTO dto = new ClienteDTO();
        dto.setPrimerNombre(cliente.getPrimerNombre());
        dto.setSegundoNombre(cliente.getSegundoNombre());
        dto.setPrimerApellido(cliente.getPrimerApellido());
        dto.setSegundoApellido(cliente.getSegundoApellido());
        dto.setTelefono(cliente.getTelefono());
        dto.setCiudadResidencia(cliente.getCiudadResidencia());
        dto.setCorreo(cliente.getCorreo());
        if (withAddress) {
            dto.setDireccion(cliente.getDireccion());
        }
        return dto;
    }

    // Método para eliminar cliente
    public boolean eliminarCliente(String tipoDocumento, String numeroDocumento) {
        Optional<Cliente> clienteOpt = repository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
        if (clienteOpt.isPresent()) {
            repository.delete(clienteOpt.get());
            return true;
        }
        return false;
    }
}
