package com.bluebank.backend.bluebankbackend.domain.service;

import com.bluebank.backend.bluebankbackend.domain.dto.BankAccountDto;
import com.bluebank.backend.bluebankbackend.domain.dto.TransactionDto;
import com.bluebank.backend.bluebankbackend.domain.dto.TransactionResponse;
import com.bluebank.backend.bluebankbackend.domain.dto.TransactionType;
import com.bluebank.backend.bluebankbackend.domain.repository.BankAccountRepository;
import com.bluebank.backend.bluebankbackend.domain.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final BankAccountRepository bankAccountRepository;

    public List<TransactionDto> findAllByAccountId(Long accountId) {
        return transactionRepository.findAllByAccountId(accountId);
    }

    public TransactionResponse save(TransactionDto transaction) {
        Optional<BankAccountDto> bankAccountDto = bankAccountRepository.findByBankAccountId(transaction.getAccountId());

        return bankAccountDto.map(account -> {
            if (transaction.getTransactionType().equals(TransactionType.ABONO)) {
                BigDecimal newBalance = account.getBalance().add(transaction.getAmount());
                account.setBalance(newBalance);
                bankAccountRepository.save(account);
                log.info("Se ha realizado un abono a la cuenta con id: " + account.getAccountId());
                transactionRepository.save(transaction);
                return TransactionResponse.builder()
                        .accountId(transaction.getAccountId())
                        .message("SE HA REALIZADO EL ABONO A LA CUENTA CON ID: " + transaction.getAccountId())
                        .status("OK")
                        .build();

            } else if (transaction.getTransactionType().equals(TransactionType.RETIRO)) {
                BigDecimal balanceActual = account.getBalance();
                if (balanceActual.compareTo(transaction.getAmount()) < 0) {
                    log.warn("No se ha relizado la transacción monto a retirar es mayor al saldo");
                    return TransactionResponse.builder()
                            .accountId(transaction.getAccountId())
                            .message("NO SE HA REALIZADO EL RETIRO  SALDO INSUFICIENTE")
                            .status("RECHAZADO")
                            .build();
                } else {
                    BigDecimal newBalance = account.getBalance().subtract(transaction.getAmount());
                    account.setBalance(newBalance);
                    bankAccountRepository.save(account);
                    transactionRepository.save(transaction);
                    log.info("Se ha realizado un retiro a la cuenta con id: " + account.getAccountId());
                    return TransactionResponse.builder()
                            .accountId(transaction.getAccountId())
                            .message("SE HA REALIZADO EL RETIRO A LA CUENTA CON ID: " + transaction.getAccountId())
                            .status("OK")
                            .build();
                }
            } else {
                return TransactionResponse.builder()
                        .accountId(transaction.getAccountId())
                        .message("EL TIPO DE TRANSACCION NO EXISTE")
                        .status("ERROR")
                        .build();
            }
        }).orElseGet(() ->{
            log.warn("no existe la cuenta a que la desea realizar la transacción");
            return  TransactionResponse.builder()
                    .accountId(transaction.getAccountId())
                    .message("NO EXISTE LA CUENTA A LA QUE SE DESEA REALIZAR LA TRANSACCIÓN")
                    .status("ERROR")
                    .build();
        });
    }
}
