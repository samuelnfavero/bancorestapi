package com.banco811.banco811.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class UsuarioResponse {

    private Integer id;
    private String cpf;
    private String nome;
}
