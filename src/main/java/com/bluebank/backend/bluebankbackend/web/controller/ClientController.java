package com.bluebank.backend.bluebankbackend.web.controller;

import com.bluebank.backend.bluebankbackend.domain.dto.ClientDto;
import com.bluebank.backend.bluebankbackend.domain.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Api(value = "Client", tags = "Client")
@RestController
@RequestMapping("/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @ApiOperation(value = "Obtener información del cliente por medio de su id, con sus respectivas cuentas bancarias")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Información del cliente enviado"),
            @ApiResponse(code = 404, message = "No se encontró información del cliente")
    })
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDto> getClientByClientId(@PathVariable("clientId") Long clientId){
        return clientService.getByClientId(clientId)
                .map( client -> {
                    log.info("Se ha obtenido el cliente con id:" + clientId);
                    return new ResponseEntity<>(client, HttpStatus.OK);
                }).orElseGet( () ->{
                    log.warn("No se ha encontrado el cliente con id: " + clientId);
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }

    @ApiOperation(value = "Obtener información del cliente por medio de su correo con sus respectivas cuentas bancarias")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Información del cliente enviado"),
            @ApiResponse(code = 404, message = "No se encontró información del cliente")
    })
    @GetMapping()
    public ResponseEntity<ClientDto> getClientByEmail(@RequestParam("email") String email){
        return clientService.getByEmail(email)
                .map( client -> {
                    log.info("Se ha obtenido el cliente con el email: " + email);
                    return new ResponseEntity<>(client, HttpStatus.OK);
                }).orElseGet( () ->{
                    log.warn("No se ha encontrado el cliente con el email: " + email);
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }

    @ApiOperation(value = "Registrar un nuevo cliente")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Información del cliente se ha guardo correctamente"),
    })
    @PostMapping()
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto clientDto){
        log.info("Se ha guardo el cliente " + clientDto.getName() + " " + clientDto.getLastname());
        return new ResponseEntity<>(clientService.save(clientDto), HttpStatus.CREATED);
    }
}
