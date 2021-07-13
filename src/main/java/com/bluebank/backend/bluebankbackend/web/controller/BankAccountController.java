package com.bluebank.backend.bluebankbackend.web.controller;

import com.bluebank.backend.bluebankbackend.domain.dto.BankAccountDto;
import com.bluebank.backend.bluebankbackend.domain.service.BankAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Api(value = "Bank Account", tags = "Bank Account")
@RestController
@RequestMapping("/v1/bankAccounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @ApiOperation(value = "Obtener cuenta bancaria por medio de su id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cuenta bancaria enviado"),
            @ApiResponse(code = 404, message = "No se econtro cuenta bancaria")
    })
    @GetMapping("/{bankAccountId}")
    public ResponseEntity<BankAccountDto> getBankcAccountById(@PathVariable("bankAccountId") Long bankAccountId){
        return bankAccountService.findByBankAccountId(bankAccountId)
                .map( bankAccountDto -> {
                    log.info("Se ha obtenido la cuenta bancaria con id: " + bankAccountId);
                    return new ResponseEntity<>(bankAccountDto, HttpStatus.OK);
                }).orElseGet(() -> {
                    log.warn("No se ha encontrado la cuenta bancaria con id:  ");
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }

    @ApiOperation(value = "Obtener cuenta bancaria por medio del cliente id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cuenta bancaria enviado"),
            @ApiResponse(code = 404, message = "No se econtro cuenta bancaria")
    })
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<BankAccountDto>> getBankAccountsByClientId(@PathVariable("clientId") Long clientId){
        List<BankAccountDto> bankAccounts = bankAccountService.findAllByClientId(clientId);
        if (bankAccounts.isEmpty()){
            log.warn("No se encontraron cuentas bancarias para el cliente id: " + clientId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("Se han obtenido las cuentas bancarias del cliente id: " + clientId);
        return new ResponseEntity<>(bankAccounts, HttpStatus.OK);
    }

    @ApiOperation(value = "Crear una nueva cuenta bancaria")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Se ha creado la cuenta bancaria"),
    })
    @PostMapping
    public ResponseEntity<BankAccountDto> saveBankAccount(@RequestBody BankAccountDto bankAccount){
        log.info("Se ha creado una nueva cuenta bancaria para el cliente con id: " + bankAccount.getClientId());
        return new ResponseEntity<>(bankAccountService.save(bankAccount), HttpStatus.CREATED);
    }


}
