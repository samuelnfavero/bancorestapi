package com.banco811.banco811.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoConta {
    POUPANCA("Poupanca"),
    CONTA("Conta");

    private final String tipo;

}
