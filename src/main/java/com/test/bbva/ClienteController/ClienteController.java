package com.test.bbva.ClienteController;


import com.test.bbva.model.Cliente;
import com.test.bbva.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // GET: Obtener información de un cliente
    @GetMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<Cliente> getCliente(
            @PathVariable String tipoDocumento,
            @PathVariable String numeroDocumento,
            @RequestParam(required = false) boolean withAddress) {

        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
            return ResponseEntity.badRequest().build();
        }

        Cliente cliente = clienteService.getCliente(tipoDocumento, numeroDocumento);

        if (cliente != null) {
            if (!withAddress) {
                cliente.setDireccion(null);
            }
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST: Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        if (cliente.getTipoDocumento() == null || cliente.getNumeroDocumento() == null) {
            return ResponseEntity.badRequest().build();
        }

        Cliente nuevoCliente = clienteService.createCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    // PUT: Actualizar la información de un cliente
    @PutMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<Cliente> updateCliente(
            @PathVariable String tipoDocumento,
            @PathVariable String numeroDocumento,
            @RequestBody Cliente cliente) {

        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
            return ResponseEntity.badRequest().build();
        }

        Cliente clienteActualizado = clienteService.updateCliente(tipoDocumento, numeroDocumento, cliente);

        if (clienteActualizado != null) {
            return ResponseEntity.ok(clienteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: Eliminar un cliente
    @DeleteMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<Void> deleteCliente(
            @PathVariable String tipoDocumento,
            @PathVariable String numeroDocumento) {

        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
            return ResponseEntity.badRequest().build();
        }

        boolean eliminado = clienteService.deleteCliente(tipoDocumento, numeroDocumento);

        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}