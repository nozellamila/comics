package com.gerenciador.comics.resources;

import com.gerenciador.comics.forms.UsuarioForm;
import com.gerenciador.comics.services.UsuarioService;
import com.gerenciador.comics.services.exceptions.ServiceException;
import com.gerenciador.comics.views.UsuarioComicsView;
import com.gerenciador.comics.views.UsuarioView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    @PostMapping
    public ResponseEntity<UsuarioView> postUsuario(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder builder) throws ServiceException {
        return usuarioService.postUsuario(usuarioForm, builder);
    }

}
