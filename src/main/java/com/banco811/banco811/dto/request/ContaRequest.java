package com.banco811.banco811.dto.request;

import com.banco811.banco811.enums.TipoConta;
import com.banco811.banco811.model.Conta;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ContaRequest {

    private Integer usuarioId;

    private BigDecimal saldo;

    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    public Conta toModel() {
        return Conta.builder()
                .id(usuarioId)
                .saldo(saldo)
                .tipoConta(tipoConta)
                .build();
    }
}
