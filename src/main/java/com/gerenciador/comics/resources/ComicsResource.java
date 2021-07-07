package com.gerenciador.comics.resources;

import com.gerenciador.comics.forms.ComicForm;
import com.gerenciador.comics.forms.UsuarioForm;
import com.gerenciador.comics.resources.response.ComicResponse;
import com.gerenciador.comics.services.ComicsService;
import com.gerenciador.comics.services.exceptions.ServiceException;
import com.gerenciador.comics.views.ComicView;
import com.gerenciador.comics.views.UsuarioComicsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/comics")
public class ComicsResource {

    @Autowired
    private ComicsService comicService;

    @Transactional
    @PostMapping
    public ResponseEntity<ComicView> postComicForUser(@RequestBody @Valid ComicForm comicForm,
                                                      UriComponentsBuilder builder) throws ServiceException {
        return comicService.postComicForUser(comicForm, builder);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioComicsView> getComicsDoUsuario(@PathVariable Integer usuarioId) throws ServiceException {
        return comicService.getComicsDoUsuario(usuarioId);
    }
}
