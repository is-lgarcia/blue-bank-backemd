package com.bluebank.backend.bluebankbackend.persistence.mapper;

import com.bluebank.backend.bluebankbackend.domain.dto.BankAccountDto;
import com.bluebank.backend.bluebankbackend.persistence.entity.CuentaBancariaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    @Mappings({
            @Mapping(source = "cuentaId", target = "accountId"),
            @Mapping(source = "clienteId", target = "clientId"),
            @Mapping(source = "alias", target = "alias"),
            @Mapping(source = "saldo", target = "balance"),
            @Mapping(source = "fechaCreacion", target = "creationDate"),
            @Mapping(source = "fechaModificacion", target = "modificationDate")
    })
    BankAccountDto toBankAccountDto(CuentaBancariaEntity cuentaBancariaEntity);
    List<BankAccountDto> toBankAccounts(List<CuentaBancariaEntity> cuentasBancariaEntities);

    @InheritInverseConfiguration
    CuentaBancariaEntity toCuentaBancariaEntity(BankAccountDto bankAccountDto);
}
