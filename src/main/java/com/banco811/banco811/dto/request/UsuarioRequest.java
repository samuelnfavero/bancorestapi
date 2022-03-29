package com.banco811.banco811.dto.request;

import com.banco811.banco811.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {

    private String cpf;
    private String nome;
    private String senha;

//    public Usuario toModel(){
//        return Usuario.builder()
//                .cpf(cpf)
//                .nome(nome)
//                .senha(senha)
//                .build();
//    }
}
