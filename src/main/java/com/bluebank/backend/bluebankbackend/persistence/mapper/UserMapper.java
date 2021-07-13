package com.bluebank.backend.bluebankbackend.persistence.mapper;

import com.bluebank.backend.bluebankbackend.domain.dto.UserDto;
import com.bluebank.backend.bluebankbackend.persistence.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "usuarioId", target = "userId"),
            @Mapping(source = "clienteId", target = "clientId"),
            @Mapping(source = "usuario", target = "user"),
            @Mapping(source = "contrasena", target = "password"),
            @Mapping(source = "rol", target = "rol")
    })
    UserDto toUserDto(UsuarioEntity usuarioEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "cliente", ignore = true),
            @Mapping(target = "estatus", ignore = true),
            @Mapping(target = "fechaModificacion", ignore = true),
    })
    UsuarioEntity toUsuarioEntity(UserDto userDto);
}
