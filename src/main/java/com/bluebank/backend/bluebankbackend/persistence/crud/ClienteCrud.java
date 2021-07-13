package com.bluebank.backend.bluebankbackend.persistence.crud;

import com.bluebank.backend.bluebankbackend.persistence.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteCrud extends CrudRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findClienteEntityByCorreoElectronico(String correo);
    Optional<ClienteEntity> findClienteEntityByClienteId(Long clientId);
}
