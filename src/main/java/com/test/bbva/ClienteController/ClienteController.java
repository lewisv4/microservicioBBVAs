package com.test.bbva.ClienteController;




import com.test.bbva.dto.ClienteDTO;
import com.test.bbva.model.Cliente;
import com.test.bbva.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // Obtener cliente
    @GetMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<?> getCliente(
            @PathVariable String tipoDocumento,
            @PathVariable String numeroDocumento,
            @RequestParam(required = false, defaultValue = "false") boolean withAddress) {

        ClienteDTO cliente = service.obtenerCliente(tipoDocumento, numeroDocumento, withAddress);
        return (cliente != null) ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    // Crear cliente (POST)
    @PostMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<Cliente> createCliente(
            @PathVariable String tipoDocumento,
            @PathVariable String numeroDocumento,
            @Valid @RequestBody ClienteDTO dto) {

        Cliente nuevoCliente = service.crearCliente(dto, tipoDocumento, numeroDocumento);
        return ResponseEntity.ok(nuevoCliente);
    }

    // Actualizar cliente (PUT)
    @PutMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<?> updateCliente(
            @PathVariable String tipoDocumento,
            @PathVariable String numeroDocumento,
            @Valid @RequestBody ClienteDTO dto) {

        Cliente clienteActualizado = service.actualizarCliente(tipoDocumento, numeroDocumento, dto);
        return (clienteActualizado != null) ? ResponseEntity.ok(clienteActualizado) : ResponseEntity.notFound().build();
    }

    // Eliminar cliente (DELETE)
    @DeleteMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<?> deleteCliente(
            @PathVariable String tipoDocumento,
            @PathVariable String numeroDocumento) {

        boolean eliminado = service.eliminarCliente(tipoDocumento, numeroDocumento);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

