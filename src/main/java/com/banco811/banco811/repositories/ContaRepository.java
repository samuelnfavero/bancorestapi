package com.banco811.banco811.repositories;

import com.banco811.banco811.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    Optional<Conta> findByAgencia(Integer agencia);

    Optional<Conta> findByNumero(Integer numero);
}
