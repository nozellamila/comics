package com.gerenciador.comics.resources;

import com.gerenciador.comics.resources.response.ComicResponse;
import com.gerenciador.comics.services.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/comics")
public class ComicsResource {

    @Autowired
    private ComicsService service;

    @ResponseStatus(OK)
    @GetMapping("/{comicId}")
    public ComicResponse findById(@PathVariable String comicId) {
        return service.findById(comicId);
    }
}
