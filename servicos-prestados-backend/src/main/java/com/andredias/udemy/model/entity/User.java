package com.andredias.udemy.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "{campo.senha.obrigatorio}")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "{campo.senha.obrigatorio}")
    @Column
    private String password;

}
