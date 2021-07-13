-- |----------------------------| --
-- |   CREACION BASE DE DATOS   | --
-- |----------------------------| --

CREATE DATABASE IF NOT EXISTS db_blue_bank;

USE db_blue_bank;

-- |------------------------| --
-- |   CREACION DE TABLAS   | --
-- |------------------------| --

DROP TABLE IF EXISTS clientes;

CREATE TABLE clientes (
    cliente_id          int             NOT NULL    AUTO_INCREMENT,
    nombre              varchar(50)     NOT NULL,
    apellido            varchar(50)     NOT NULL,
    correo_electronico  varchar(80)     NOT NULL,
    telefono            varchar(10)     NOT NULL,
    fecha_nacimiento    date            NOT NULL,
    PRIMARY KEY (cliente_id),
    UNIQUE KEY correo_electronico (correo_electronico)
);

DROP TABLE IF EXISTS usuarios;

CREATE TABLE usuarios(
    usuario_id          int             NOT NULL    AUTO_INCREMENT,
    cliente_id          int             NOT NULL,
    usuario             varchar(20)     NOT NULL,
    contrasena          varchar(60)     NOT NULL,
    estatus             tinyint         NOT NULL,
    rol                 varchar(10)     NOT NULL,
    fecha_modificacion  datetime        NOT NULL,
    PRIMARY KEY (usuario_id),
    UNIQUE KEY usuario (usuario)
);

DROP TABLE IF EXISTS cuentas_bancarias;

CREATE TABLE cuentas_bancarias(
    cuenta_id           int             NOT NULL    AUTO_INCREMENT,
    cliente_id          int             NOT NULL,
    fecha_creacion      datetime        NOT NULL,
    alias               varchar(60)     NOT NULL,
    saldo               decimal(21,4)   NOT NULL,
    fecha_modificacion  datetime        NOT NULL,
    PRIMARY KEY (cuenta_id)
);

DROP TABLE IF EXISTS transacciones;

CREATE TABLE transacciones (
    transaccion_id      int             NOT NULL    AUTO_INCREMENT,
    cuenta_id           int             NOT NULL,
    tipo_transaccion    varchar(20)     NOT NULL,
    importe             decimal(21,4)   NOT NULL,
    fecha_realizado     datetime        NOT NULL,
    PRIMARY KEY (transaccion_id)
);

-- |--------------------------------------| --
-- |   CREACION DE RELACION ENTRE TABLAS  | --
-- |--------------------------------------| --

ALTER TABLE usuarios
ADD CONSTRAINT FK_usuarios_clientes
FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id);

ALTER TABLE cuentas_bancarias
ADD CONSTRAINT FK_cuentas_bancarias_clientes
FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id);

ALTER TABLE transacciones
ADD CONSTRAINT FK_transacciones_cuentas_bancarias
FOREIGN KEY (cuenta_id) REFERENCES cuentas_bancarias(cuenta_id);
