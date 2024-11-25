package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usacases.CriarUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;

    public UsuarioController(CriarUsuario criarUsuario){
        this.criarUsuario = criarUsuario;
    }


    @PostMapping
    public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        Usuario salvo = criarUsuario.cadastrarUsuario(new Usuario(usuarioDTO.cpf(), usuarioDTO.nome(), usuarioDTO.nascimento(), usuarioDTO.email()));
        return new UsuarioDTO(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());
    }
}
