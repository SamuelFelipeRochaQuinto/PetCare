package com.petcare.PetCare.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;

}
