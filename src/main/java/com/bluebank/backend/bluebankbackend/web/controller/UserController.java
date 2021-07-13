package com.bluebank.backend.bluebankbackend.web.controller;

import com.bluebank.backend.bluebankbackend.domain.service.UserServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

    private final UserServices userServices;

    //TODO IMPLEMENTAR LOS METODOS PARA CREAR USUARIO, Y AUTENTICARSE

}
