package com.bluebank.backend.bluebankbackend.domain.service;

import com.bluebank.backend.bluebankbackend.domain.dto.BankAccountDto;
import com.bluebank.backend.bluebankbackend.domain.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public Optional<BankAccountDto> findByBankAccountId(Long bankAccountId){
        return bankAccountRepository.findByBankAccountId(bankAccountId);
    }
    public List<BankAccountDto> findAllByClientId(Long clientId){
        return bankAccountRepository.findAllByClientId(clientId);
    }
    public BankAccountDto save(BankAccountDto bankAccount){
        bankAccount.setCreationDate(LocalDateTime.now());
        bankAccount.setModificationDate(LocalDateTime.now());
        return bankAccountRepository.save(bankAccount);
    }
}
