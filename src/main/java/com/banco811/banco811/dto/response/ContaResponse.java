package com.banco811.banco811.dto.response;

import com.banco811.banco811.enums.TipoConta;
import com.banco811.banco811.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Builder
public class ContaResponse {
    private Integer id;

    private Integer agencia;

    private Integer numero;

    private BigDecimal saldo;

    private TipoConta tipoConta;

    private Usuario usuario;

}
