package com.bluebank.backend.bluebankbackend.persistence;

import com.bluebank.backend.bluebankbackend.domain.dto.ClientDto;
import com.bluebank.backend.bluebankbackend.domain.repository.ClientRepository;
import com.bluebank.backend.bluebankbackend.persistence.crud.ClienteCrud;
import com.bluebank.backend.bluebankbackend.persistence.entity.ClienteEntity;
import com.bluebank.backend.bluebankbackend.persistence.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ClienteRepository implements ClientRepository {

    private final ClienteCrud clienteCrud;
    private final ClienteMapper mapper;

    @Override
    public Optional<ClientDto> getByClientId(Long clientId) {
        return clienteCrud.findClienteEntityByClienteId(clientId).map(mapper::toClientDto);
    }

    @Override
    public Optional<ClientDto> getByEmail(String email) {
        return clienteCrud.findClienteEntityByCorreoElectronico(email).map(mapper::toClientDto);
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        ClienteEntity clienteEntity = mapper.toClienteEntity(clientDto);
        return mapper.toClientDto(clienteCrud.save(clienteEntity));
    }
}
