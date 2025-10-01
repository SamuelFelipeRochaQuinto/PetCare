package com.petcare.PetCare.Repository;

import com.petcare.PetCare.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
