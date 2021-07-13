package com.bluebank.backend.bluebankbackend.domain.service;

import com.bluebank.backend.bluebankbackend.domain.dto.UserDto;
import com.bluebank.backend.bluebankbackend.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServices {

    private final UserRepository userRepository;

    public Optional<UserDto> getByUser(String user){
        return userRepository.findByUser(user);
    }

    public Optional<UserDto> getByClientId(Long clientId){
        return userRepository.findByClientId(clientId);
    }

    public UserDto save(UserDto user){
        return userRepository.save(user);
    }

}
