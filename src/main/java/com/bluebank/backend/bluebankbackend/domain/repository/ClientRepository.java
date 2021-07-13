package com.bluebank.backend.bluebankbackend.domain.repository;

import com.bluebank.backend.bluebankbackend.domain.dto.ClientDto;

import java.util.Optional;

public interface ClientRepository {
    Optional<ClientDto> getByClientId(Long clientId);
    Optional<ClientDto> getByEmail(String email);
    ClientDto save(ClientDto clientDto);
}
