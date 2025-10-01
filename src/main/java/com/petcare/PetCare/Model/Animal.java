package com.petcare.PetCare.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "animais")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String raca;
    private Date dataNascimento;
    private Float peso;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}
