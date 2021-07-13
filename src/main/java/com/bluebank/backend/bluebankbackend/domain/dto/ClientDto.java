package com.bluebank.backend.bluebankbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {
    private Long clientId;
    private String name;
    private String lastname;
    private String email;
    private String phoneNumber;
    private LocalDate birthday;
    private List<BankAccountDto> bankAccounts;
}
