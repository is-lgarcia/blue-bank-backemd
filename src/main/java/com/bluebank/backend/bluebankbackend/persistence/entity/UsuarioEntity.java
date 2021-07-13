package com.bluebank.backend.bluebankbackend.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "usuario", length = 20, nullable = false, unique = true)
    private String usuario;

    @Column(name = "contrasena", length = 20, nullable = false)
    private String contrasena;

    @Column(name = "estatus", nullable = false)
    private Boolean estatus;

    @Column(name = "rol", length = 10, nullable = false)
    private String rol;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @OneToOne
    @JoinColumn(name = "cliente_id", insertable = false, updatable = false)
    private ClienteEntity cliente;

    public void setEstatus(Boolean estatus) {
        estatus = true;
        this.estatus = estatus;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        fechaModificacion = LocalDateTime.now();
        this.fechaModificacion = fechaModificacion;
    }
}
