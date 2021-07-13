package com.bluebank.backend.bluebankbackend.domain.repository;

import com.bluebank.backend.bluebankbackend.domain.dto.BankAccountDto;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepository {
    Optional<BankAccountDto> findByBankAccountId(Long bankAccountId);
    List<BankAccountDto> findAllByClientId(Long clientId);
    BankAccountDto save(BankAccountDto bankAccountDto);
}
