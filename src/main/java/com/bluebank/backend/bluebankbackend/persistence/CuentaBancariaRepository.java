package com.bluebank.backend.bluebankbackend.persistence;

import com.bluebank.backend.bluebankbackend.domain.dto.BankAccountDto;
import com.bluebank.backend.bluebankbackend.domain.repository.BankAccountRepository;
import com.bluebank.backend.bluebankbackend.persistence.crud.CuentaBancariaCrud;
import com.bluebank.backend.bluebankbackend.persistence.entity.CuentaBancariaEntity;
import com.bluebank.backend.bluebankbackend.persistence.mapper.BankAccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CuentaBancariaRepository implements BankAccountRepository {

    private final CuentaBancariaCrud cuentaBancariaCrud;
    private final BankAccountMapper mapper;

    @Override
    public Optional<BankAccountDto> findByBankAccountId(Long bankAccountId) {
        return cuentaBancariaCrud.findById(bankAccountId)
                .map(mapper::toBankAccountDto);
    }

    @Override
    public List<BankAccountDto> findAllByClientId(Long clientId) {
        return mapper.toBankAccounts(cuentaBancariaCrud.findCuentaBancariaEntityByClienteId(clientId));
    }

    @Override
    public BankAccountDto save(BankAccountDto bankAccountDto) {
        CuentaBancariaEntity cuenta = cuentaBancariaCrud.save(mapper.toCuentaBancariaEntity(bankAccountDto));
        return mapper.toBankAccountDto(cuenta);
    }
}
