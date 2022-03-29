package com.banco811.banco811.services.impl;

import com.banco811.banco811.dto.request.ContaRequest;
import com.banco811.banco811.dto.response.ContaResponse;
import com.banco811.banco811.exceptions.UserNotFoundException;
import com.banco811.banco811.model.Conta;
import com.banco811.banco811.model.Usuario;
import com.banco811.banco811.repositories.ContaRepository;
import com.banco811.banco811.repositories.UsuarioRepository;
import com.banco811.banco811.services.ContaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;
import java.util.Random;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ContaRepository contaRepository;

    @Override
    public ContaResponse create(ContaRequest contaRequest) {
        Usuario usuario = usuarioRepository.findById(contaRequest.getUsuarioId())
                .orElseThrow(UserNotFoundException::new);
        Integer agencia;
        Integer numero;
        do {
            agencia = generateRandom(5);
            numero = generateRandom(4);
        }while(verifyIfAgencyOrAccountExists(agencia, numero));

        Conta conta = contaRequest.toModel();
        conta.setUsuario(usuario);
        conta.setAgencia(agencia);
        conta.setNumero(numero);

        Conta contaSalva = contaRepository.save(conta);
        return contaSalva.toResponse();
    }

    private boolean verifyIfAgencyOrAccountExists(Integer agencia, Integer numero){
        Boolean existeContaENumero = false;
        Optional<Conta> contaPorAgencia = contaRepository.findByAgencia(agencia);
        Optional<Conta> contaPorNumero = contaRepository.findByNumero(numero);
        if(!ObjectUtils.isEmpty(contaPorAgencia) && !ObjectUtils.isEmpty(contaPorNumero)){
            existeContaENumero = true;
        }
        return existeContaENumero;
    }

    private Integer generateRandom(Integer pot){
        Random random = new Random();
        Double doub = Math.pow(10, pot);
        return random.nextInt(doub.intValue() - 1);
    }

//    @Override
//    public ContaResponse create(ContaRequest contaRequest) {
//        Usuario usuario = usuarioRepository.findById(contaRequest.getUsuarioId())
//                .orElseThrow(UserNotFoundException::new);
//        Integer agencia = 12345;
//        Integer numero = 1234;
//
//        Conta conta = contaRequest.toModel();
//        conta.setUsuario(usuario);
//        conta.setAgencia(agencia);
//        conta.setNumero(numero);
//
//        Conta contaSalva = contaRepository.save(conta);
//        return contaSalva.toResponse();
//    }
}
