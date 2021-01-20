package com.andredias.udemy.exceptions;

public class UsuarioCadastradoException extends RuntimeException{

    public UsuarioCadastradoException(String username){
        super("Usuário já cadastrado para o username " + username);
    }
}
