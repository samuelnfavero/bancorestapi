package com.banco811.banco811.model;

import com.banco811.banco811.dto.request.UsuarioRequest;
import com.banco811.banco811.dto.response.UsuarioResponse;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")

    private String senha;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime dataCrtiacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "usuario")
    private List<Conta> conta;

    public Usuario(UsuarioRequest usuarioRequest){
        nome = usuarioRequest.getNome();
        cpf = usuarioRequest.getCpf();
        senha = usuarioRequest.getSenha();
    }
    public UsuarioResponse toResponse() {
        return UsuarioResponse.builder()
                .id(id)
                .cpf(cpf)
                .nome(nome)
                .build();
    }
}
