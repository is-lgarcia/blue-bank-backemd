package com.bluebank.backend.bluebankbackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountDto {
    private Long accountId;
    private Long clientId;
    private String alias;
    private BigDecimal balance;
    @JsonIgnore private LocalDateTime creationDate;
    @JsonIgnore private LocalDateTime modificationDate;
}
