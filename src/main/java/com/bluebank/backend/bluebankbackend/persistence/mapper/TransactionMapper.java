package com.bluebank.backend.bluebankbackend.persistence.mapper;

import com.bluebank.backend.bluebankbackend.domain.dto.TransactionDto;
import com.bluebank.backend.bluebankbackend.persistence.entity.TransaccionEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BankAccountMapper.class})
public interface TransactionMapper {

    @Mappings({
            @Mapping(source = "transaccionId", target = "transactionId"),
            @Mapping(source = "cuentaId", target = "accountId"),
            @Mapping(source = "tipoTransaccion", target = "transactionType"),
            @Mapping(source = "importe", target = "amount"),
            @Mapping(source = "fechaRealizado", target = "dateMade")
    })
    TransactionDto toTransaciontDto(TransaccionEntity transaccionEntity);
    List<TransactionDto> toTransactionsDtos(List<TransaccionEntity> transaccionEntities);

    @InheritInverseConfiguration
    TransaccionEntity toTransaccionEntity(TransactionDto transactionDto);
}
