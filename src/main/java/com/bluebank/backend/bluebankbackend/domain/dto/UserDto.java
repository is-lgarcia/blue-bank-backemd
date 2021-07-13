package com.bluebank.backend.bluebankbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long userId;
    private Long clientId;
    private String user;
    private String password;
    private String rol;
    private ClientDto client;
}
