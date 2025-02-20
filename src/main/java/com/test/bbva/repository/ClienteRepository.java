package com.test.bbva.repository;




import com.test.bbva.model.Cliente;
import org.springframework.data.jpa     .repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
}
