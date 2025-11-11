package com.popezada.cadastro_usuario.business;

import com.popezada.cadastro_usuario.infrastructure.entitys.Usuario;
import com.popezada.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void SalvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPoEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }
}
