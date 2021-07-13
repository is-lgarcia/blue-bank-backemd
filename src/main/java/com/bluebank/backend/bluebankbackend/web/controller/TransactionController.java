package com.bluebank.backend.bluebankbackend.web.controller;

import com.bluebank.backend.bluebankbackend.domain.dto.TransactionDto;
import com.bluebank.backend.bluebankbackend.domain.dto.TransactionResponse;
import com.bluebank.backend.bluebankbackend.domain.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Api(value = "Transaction", tags = "Transaction")
@RequestMapping("/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @ApiOperation(value = "Realizar una transacción de una cuenta en especifico dependiendo si es abono o retiro.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Se realizo la transacción con éxito"),
            @ApiResponse(code = 406, message = "No se realizo la transacción")
    })
    @PostMapping()
    public ResponseEntity<TransactionResponse> saveTrasaction(@RequestBody TransactionDto transactionDto){
        TransactionResponse response = transactionService.save(transactionDto);
        if (response.getStatus().equals("OK")){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @ApiOperation(value = "Obtener las transacciones correspondientes a la cuenta bancaria")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Se han enviando las transacciones correctamente"),
            @ApiResponse(code = 406, message = "No existen transacciones para la cuenta consultada")
    })
    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<TransactionDto>> getAllTransactionByAccount(@PathVariable("accountId") Long accountId){
        return new ResponseEntity<>(transactionService.findAllByAccountId(accountId), HttpStatus.OK);
    }

}
