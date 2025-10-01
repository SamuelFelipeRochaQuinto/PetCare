package com.petcare.PetCare.Repository;

import com.petcare.PetCare.Model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento,Long> {
}
