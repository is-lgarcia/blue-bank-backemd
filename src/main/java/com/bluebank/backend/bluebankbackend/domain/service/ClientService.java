package com.bluebank.backend.bluebankbackend.domain.service;

import com.bluebank.backend.bluebankbackend.domain.dto.ClientDto;
import com.bluebank.backend.bluebankbackend.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public Optional<ClientDto> getByClientId(Long clientId){
        return clientRepository.getByClientId(clientId);
    }

    public Optional<ClientDto> getByEmail(String email){
        return clientRepository.getByEmail(email);
    }

    public ClientDto save(ClientDto client){
        return clientRepository.save(client);
    }

}
