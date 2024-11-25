package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioEntityMapper mapper;

    private final UsuarioRepository usuarioRepository;

    public RepositorioDeUsuarioJpa(UsuarioRepository usuarioRepository, UsuarioEntityMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrar(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        usuarioRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        //return usuarioRepository.findAll();
        return null;
    }

}
