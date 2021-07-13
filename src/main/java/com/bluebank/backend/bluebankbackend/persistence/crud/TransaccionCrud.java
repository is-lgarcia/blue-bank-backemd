package com.bluebank.backend.bluebankbackend.persistence.crud;

import com.bluebank.backend.bluebankbackend.persistence.entity.TransaccionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransaccionCrud extends CrudRepository<TransaccionEntity, Long> {
    List<TransaccionEntity> findAllByCuentaId(Long cuentaId);
}
