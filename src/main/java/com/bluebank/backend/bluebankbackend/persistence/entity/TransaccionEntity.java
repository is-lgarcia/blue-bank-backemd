package com.bluebank.backend.bluebankbackend.persistence.entity;

import com.bluebank.backend.bluebankbackend.domain.dto.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "transacciones")
public class TransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaccion_id")
    private Long transaccionId;

    @Column(name = "cuenta_id")
    private Long cuentaId;

    @Column(name = "tipo_transaccion")
    @Enumerated(EnumType.STRING)
    private TransactionType tipoTransaccion;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "fecha_realizado")
    private LocalDateTime fechaRealizado;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", updatable = false, insertable = false)
    private CuentaBancariaEntity cuentaBancaria;

    public Long getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(Long transaccionId) {
        this.transaccionId = transaccionId;
    }

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public TransactionType getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TransactionType tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public LocalDateTime getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(LocalDateTime fechaRealizado) {
        fechaRealizado = LocalDateTime.now();
        this.fechaRealizado = fechaRealizado;
    }
}
