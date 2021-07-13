package com.bluebank.backend.bluebankbackend.persistence;

import com.bluebank.backend.bluebankbackend.domain.dto.TransactionDto;
import com.bluebank.backend.bluebankbackend.domain.repository.TransactionRepository;
import com.bluebank.backend.bluebankbackend.persistence.crud.TransaccionCrud;
import com.bluebank.backend.bluebankbackend.persistence.entity.TransaccionEntity;
import com.bluebank.backend.bluebankbackend.persistence.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class TransaccionRepository implements TransactionRepository {

    private final TransaccionCrud transaccionCrud;
    private final TransactionMapper mapper;

    @Override
    public List<TransactionDto> findAllByAccountId(Long accountId) {
        return mapper.toTransactionsDtos(transaccionCrud.findAllByCuentaId(accountId));
    }

    @Override
    public TransactionDto save(TransactionDto transaction) {
        TransaccionEntity transaccionEntity = transaccionCrud.save(mapper.toTransaccionEntity(transaction));
        return mapper.toTransaciontDto(transaccionEntity);
    }
}
