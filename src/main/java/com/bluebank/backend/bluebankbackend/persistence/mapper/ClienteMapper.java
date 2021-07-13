package com.bluebank.backend.bluebankbackend.persistence.mapper;

import com.bluebank.backend.bluebankbackend.domain.dto.ClientDto;
import com.bluebank.backend.bluebankbackend.persistence.entity.ClienteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {BankAccountMapper.class})
public interface ClienteMapper {

    @Mappings({
             @Mapping(source = "clienteId", target = "clientId"),
             @Mapping(source = "nombre", target = "name"),
             @Mapping(source = "apellido", target = "lastname"),
             @Mapping(source = "correoElectronico", target = "email"),
             @Mapping(source = "telefono", target = "phoneNumber"),
             @Mapping(source = "fechaNacimiento", target = "birthday"),
             @Mapping(source = "cuentasBancarias", target = "bankAccounts")
    })
    ClientDto toClientDto(ClienteEntity clienteEntity);

    @InheritInverseConfiguration
    ClienteEntity toClienteEntity(ClientDto clientDto);
}
