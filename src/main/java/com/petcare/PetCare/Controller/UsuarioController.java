package com.petcare.PetCare.Controller;

import com.petcare.PetCare.DTO.AnimalDTO;
import com.petcare.PetCare.DTO.UsuarioDTO;
import com.petcare.PetCare.Model.Usuario;
import com.petcare.PetCare.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.converterDtoParaEntidade(usuarioDTO);
        Usuario salvo = usuarioService.cadastrar(usuario);
        UsuarioDTO resposta = new UsuarioDTO(
                salvo.getNome(),
                salvo.getEmail(),
                salvo.getSenha()
        );

        return ResponseEntity.ok(resposta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(
            @PathVariable Long id,
            @RequestBody UsuarioDTO usuarioDTO) {

        Usuario usuarioAtualizado = usuarioService.converterDtoParaEntidade(usuarioDTO);
        Usuario atualizado = usuarioService.Atualizar(id, usuarioAtualizado);

        UsuarioDTO resposta = new UsuarioDTO(
                atualizado.getNome(),
                atualizado.getEmail(),
                atualizado.getSenha()

        );

        return ResponseEntity.ok(resposta);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> lista = usuarioService.listarUsuario()
                .stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getSenha()

                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }
}


