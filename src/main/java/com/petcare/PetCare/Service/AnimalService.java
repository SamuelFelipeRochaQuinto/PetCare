package com.petcare.PetCare.Service;



import com.petcare.PetCare.DTO.AnimalDTO;
import com.petcare.PetCare.Model.Animal;
import com.petcare.PetCare.Model.Usuario;
import com.petcare.PetCare.Repository.AnimalRepository;
import com.petcare.PetCare.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AnimalService {
    @Autowired
    private final AnimalRepository animalRepository;

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public AnimalService(AnimalRepository animalRepository, UsuarioRepository usuarioRepository) {
        this.animalRepository = animalRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Animal cadastrar(Animal animal) {
        return animalRepository.save(animal);
    }

    @Transactional
    public Animal atualizar(Long id, Animal animalAtualizado) {
        var existente = animalRepository.findById(id);

        if (existente.isEmpty()) throw new RuntimeException("Animal não encontrado");
        Animal animal = existente.get();
        animal.setRaca(animalAtualizado.getRaca());
        animal.setPeso(animalAtualizado.getPeso());
        animal.setNome(animalAtualizado.getNome());

        return animalRepository.save(animal);
    }

    @Transactional
    public void excluir(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new RuntimeException("Animal não encontrado com ID: " + id);
        }
        animalRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Animal> listarAnimais() {
        return animalRepository.findAll();
    }

    public Animal converterDtoParaEntidade(AnimalDTO dto) {
        Animal animal = new Animal();
        animal.setNome(dto.getNome());
        animal.setRaca(dto.getRaca());
        animal.setPeso(dto.getPeso());
        animal.setDataNascimento(dto.getDataNascimento());
        return animal;
    }

    public Animal cadastrarParaUsuario(Animal animal, Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        animal.setUsuario(usuario);
        return animalRepository.save(animal);
    }

}
