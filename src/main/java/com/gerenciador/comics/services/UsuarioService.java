package com.gerenciador.comics.services;

import com.gerenciador.comics.domains.Usuario;
import com.gerenciador.comics.forms.UsuarioForm;
import com.gerenciador.comics.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<UsuarioForm> postUsuario(UsuarioForm usuarioForm, UriComponentsBuilder builder) {
        Usuario usuario;
        ModelMapper modelMapper = new ModelMapper();
        usuario = modelMapper.map(usuarioForm, Usuario.class);

        usuarioRepository.save(usuario);

        URI uri = builder.path("/users/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioForm(usuario));
    }
}
