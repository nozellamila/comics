package com.gerenciador.comics.services;

import com.gerenciador.comics.domains.Usuario;
import com.gerenciador.comics.forms.UsuarioForm;
import com.gerenciador.comics.repositories.UsuarioRepository;
import com.gerenciador.comics.services.exceptions.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<UsuarioForm> postUsuario(UsuarioForm usuarioForm, UriComponentsBuilder builder) throws ServiceException {
        Usuario usuario;

        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(usuarioForm.getEmail());
        if(optionalUsuario.isPresent())
            throw new ServiceException(HttpStatus.CONFLICT, "Usuário já cadastrado com o e-mail: " + optionalUsuario.get().getEmail());
        optionalUsuario = null;

        optionalUsuario = usuarioRepository.findByCpf(usuarioForm.getCpf());
        if(optionalUsuario.isPresent())
            throw new ServiceException(HttpStatus.CONFLICT, "Usuário já cadastrado com o CPF: " + optionalUsuario.get().getCpf());

        ModelMapper modelMapper = new ModelMapper();
        usuario = modelMapper.map(usuarioForm, Usuario.class);

        usuarioRepository.save(usuario);

        URI uri = builder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioForm(usuario));
    }
}
