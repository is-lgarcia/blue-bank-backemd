package com.bluebank.backend.bluebankbackend.persistence.crud;

import com.bluebank.backend.bluebankbackend.persistence.entity.CuentaBancariaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CuentaBancariaCrud extends CrudRepository<CuentaBancariaEntity, Long> {
    List<CuentaBancariaEntity> findCuentaBancariaEntityByClienteId(Long clienteId);
}
