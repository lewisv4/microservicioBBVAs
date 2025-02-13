package com.test.bbva.repository;



import com.test.bbva.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    Cliente findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
}