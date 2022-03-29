package com.banco811.banco811.exceptions;

import java.util.function.Supplier;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super("Usuário não encontrado.");
    }
}
