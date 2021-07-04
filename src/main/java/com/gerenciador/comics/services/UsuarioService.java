package com.gerenciador.comics.services;

import com.gerenciador.comics.domains.Usuario;
import com.gerenciador.comics.forms.UsuarioForm;
import com.gerenciador.comics.repositories.UsuarioRepository;
import com.gerenciador.comics.services.exceptions.ServiceException;
import com.gerenciador.comics.views.UsuarioComicsView;
import com.gerenciador.comics.views.UsuarioView;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<UsuarioView> postUsuario(UsuarioForm usuarioForm, UriComponentsBuilder builder) throws ServiceException {
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
        return ResponseEntity.created(uri).body(new UsuarioView(usuario));
    }


}
