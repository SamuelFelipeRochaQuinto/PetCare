package com.petcare.PetCare.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "medicamentos")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dosagem;
    private String viaAdministracao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

}
