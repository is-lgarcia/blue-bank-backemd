package com.bluebank.backend.bluebankbackend.persistence;

import com.bluebank.backend.bluebankbackend.domain.dto.UserDto;
import com.bluebank.backend.bluebankbackend.domain.repository.UserRepository;
import com.bluebank.backend.bluebankbackend.persistence.crud.UsuarioCrud;
import com.bluebank.backend.bluebankbackend.persistence.entity.UsuarioEntity;
import com.bluebank.backend.bluebankbackend.persistence.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UsuarioRepository implements UserRepository {

    private final UsuarioCrud usuarioCrud;
    private final UserMapper mapper;

    @Override
    public Optional<UserDto> findByUser(String user) {
        return usuarioCrud.findUsuarioEntityByUsuarioAndEstatus(user, true)
                .map(mapper::toUserDto);
    }

    @Override
    public Optional<UserDto> findByClientId(Long clientId) {
        return usuarioCrud.findByClienteIdAndEstatus(clientId, true)
                .map(mapper::toUserDto);
    }

    @Override
    public UserDto save(UserDto user) {
        UsuarioEntity usuario = usuarioCrud.save(mapper.toUsuarioEntity(user));
        return mapper.toUserDto(usuario);
    }
}
