package com.petcare.PetCare.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "animal_id")
    private Animal animal;

}
