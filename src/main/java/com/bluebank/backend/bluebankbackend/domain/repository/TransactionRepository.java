package com.bluebank.backend.bluebankbackend.domain.repository;

import com.bluebank.backend.bluebankbackend.domain.dto.TransactionDto;

import java.util.List;

public interface TransactionRepository {
    List<TransactionDto> findAllByAccountId(Long accountId);
    TransactionDto save(TransactionDto transaction);
}
