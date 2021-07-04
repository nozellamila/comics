package com.gerenciador.comics.resources;

import com.gerenciador.comics.forms.UsuarioForm;
import com.gerenciador.comics.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<UsuarioForm> postUsuario(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder builder){
        return usuarioService.postUsuario(usuarioForm, builder);
    }
}
