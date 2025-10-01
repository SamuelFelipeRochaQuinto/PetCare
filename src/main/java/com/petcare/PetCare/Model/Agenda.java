package com.petcare.PetCare.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "agendas")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataInicio;
    private Date dataFim;
    private int frequenciaHoras;
    private Date proximoHorario;
    private boolean ativo;

}
