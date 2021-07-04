package com.gerenciador.comics.resources;

import com.gerenciador.comics.forms.ComicForm;
import com.gerenciador.comics.forms.UsuarioForm;
import com.gerenciador.comics.resources.response.ComicResponse;
import com.gerenciador.comics.services.ComicsService;
import com.gerenciador.comics.services.exceptions.ServiceException;
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

    @PostMapping
    public ResponseEntity<ComicResponse> postComicForUser(@RequestBody @Valid ComicForm comicForm, UriComponentsBuilder builder) throws ServiceException {
        return comicService.postComicForUser(comicForm, builder);
    }
}
