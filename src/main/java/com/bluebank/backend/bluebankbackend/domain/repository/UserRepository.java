package com.bluebank.backend.bluebankbackend.domain.repository;

import com.bluebank.backend.bluebankbackend.domain.dto.UserDto;

import java.util.Optional;

public interface UserRepository {
    Optional<UserDto> findByUser(String user);
    Optional<UserDto> findByClientId(Long clientId);
    UserDto save(UserDto user);
}
