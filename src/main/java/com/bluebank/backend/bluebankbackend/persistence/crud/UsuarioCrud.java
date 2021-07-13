package com.bluebank.backend.bluebankbackend.persistence.crud;

import com.bluebank.backend.bluebankbackend.persistence.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioCrud extends CrudRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findUsuarioEntityByUsuarioAndEstatus(String usuario, Boolean estatus);
    Optional<UsuarioEntity> findByClienteIdAndEstatus(Long clientId, Boolean estatus);
}
