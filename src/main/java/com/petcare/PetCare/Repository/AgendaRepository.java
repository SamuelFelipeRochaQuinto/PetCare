package com.petcare.PetCare.Repository;

import com.petcare.PetCare.Model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
