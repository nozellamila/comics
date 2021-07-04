package com.gerenciador.comics.services;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.gerenciador.comics.client.ComicsClient;
import com.gerenciador.comics.domains.Comics;
import com.gerenciador.comics.domains.Usuario;
import com.gerenciador.comics.forms.ComicForm;
import com.gerenciador.comics.forms.UsuarioForm;
import com.gerenciador.comics.repositories.ComicsRepository;
import com.gerenciador.comics.repositories.UsuarioRepository;
import com.gerenciador.comics.resources.response.ComicResponse;
import com.gerenciador.comics.services.exceptions.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Service
public class ComicsService {
    private static final String PUBLIC_KEY = "e5adaa85ec57f307a002d9e921ec8fa1";
    private static final String PRIVATE_KEY = "0eac320423a5f262b6179246c28a15da0a975c1f";

    @Autowired
    private ComicsClient client;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ComicsRepository comicsRepository;

    public ComicResponse findComicById(String comicId) {
        Long timeStamp = new Date().getTime();

        return client.getById(comicId, timeStamp, PUBLIC_KEY, buildHash(timeStamp));
    }
    public ResponseEntity<ComicResponse> postComicForUser(ComicForm comicForm, UriComponentsBuilder builder) throws ServiceException {
        Comics comic;
        Optional<Usuario> usuario = usuarioRepository.findById(comicForm.getUsuarioId());

        if (!usuario.isPresent())
            throw new ServiceException(HttpStatus.NOT_FOUND, "Usuário não encontrado");


        ComicResponse comicResponse = findComicById(comicForm.getComicId().toString());

        comic = toComic(comicResponse);

        comic.setUsuarios(Arrays.asList(usuario.get()));

        comicsRepository.save(comic);

        usuario.get().setComics(Arrays.asList(comic));

        URI uri = builder.path("/comics/{id}").buildAndExpand(comic.getId()).toUri();
        return ResponseEntity.created(uri).body(comicResponse);
    }

    private String buildHash(Long timeStamp) {

        return DigestUtils.md5Hex(timeStamp + PRIVATE_KEY + PUBLIC_KEY);
    }

    private Comics toComic(ComicResponse comicResponse){
        Comics comics = new Comics();
        comics.setComicId(comicResponse.getData().getResults().get(0).getId());
        comics.setTitulo(comicResponse.getData().getResults().get(0).getTitle());
        comics.setPreco(comicResponse.getData().getResults().get(0).getPrices().get(0).getPrice());
        comics.setIsbn(comicResponse.getData().getResults().get(0).getIsbn());
        comics.setDescricao(comicResponse.getData().getResults().get(0).getDescription());
        return comics;
    }

}
