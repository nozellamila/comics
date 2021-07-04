package com.gerenciador.comics.services;

import com.gerenciador.comics.client.ComicsClient;
import com.gerenciador.comics.domains.Comics;
import com.gerenciador.comics.domains.Usuario;
import com.gerenciador.comics.forms.ComicForm;
import com.gerenciador.comics.repositories.ComicsRepository;
import com.gerenciador.comics.repositories.UsuarioRepository;
import com.gerenciador.comics.resources.response.ComicResponse;
import com.gerenciador.comics.services.exceptions.ServiceException;
import com.gerenciador.comics.views.ComicView;
import com.gerenciador.comics.views.ComicsUserView;
import com.gerenciador.comics.views.UsuarioComicsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

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

    public ResponseEntity<ComicResponse> findComicById(String comicId) {
        Long timeStamp = new Date().getTime();

        return client.getById(comicId, timeStamp, PUBLIC_KEY, buildHash(timeStamp));
    }

    public ResponseEntity<ComicView> postComicForUser(ComicForm comicForm, UriComponentsBuilder builder) throws ServiceException {
        Comics comic;
        Optional<Usuario> usuario = usuarioRepository.findById(comicForm.getUsuarioId());

        ResponseEntity<ComicResponse> comicResponseResponseEntity;

        if (!usuario.isPresent())
            throw new ServiceException(HttpStatus.NOT_FOUND, "Usuário não encontrado");

        try {
            comicResponseResponseEntity = findComicById(comicForm.getComicId().toString());
        }catch (Exception e){
            throw new ServiceException(HttpStatus.NOT_FOUND, "Comic da Marvel não encontrado");
        }

        Optional<Comics> optionalComics = comicsRepository.findByComicId(comicForm.getComicId());

        if (optionalComics.isPresent()){
            comic = optionalComics.get();
            List<Usuario> usuarios = comic.getUsuarios();
            usuarios.add(usuario.get());
            comic.setUsuarios(usuarios);

            List<Comics> comics = usuario.get().getComics();
            comics.add(comic);
            usuario.get().setComics(comics);
        }else {
            comic = toComic(comicResponseResponseEntity.getBody());
            comic.setUsuarios(Arrays.asList(usuario.get()));

            comicsRepository.save(comic);

            List<Comics> comics = usuario.get().getComics();
            comics.add(comic);
            usuario.get().setComics(comics);
        }

        URI uri = builder.path("/comics/{id}").buildAndExpand(comic.getId()).toUri();
        return ResponseEntity.created(uri).body(new ComicView(comic, comicForm.getUsuarioId()));
    }

    public ResponseEntity<UsuarioComicsView> getComicsDoUsuario(Integer usuarioId) throws ServiceException {
        //Pegar os comics cadastrados
        //Dia de desconto, se o isbn for vazio, nao tem desconto
        //Desconto ativo: se for o dia de desconto fica ativo
        //Se o desconto estiver ativo, o preço deve ser 10% menor. Se o preço for 0, nao deve dar 10%
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioId);
        UsuarioComicsView usuarioComicsView = new UsuarioComicsView();
        List<ComicsUserView> comicsUserViewList = new ArrayList<>();

        if(!optionalUsuario.isPresent())
            throw new ServiceException(HttpStatus.NOT_FOUND, "Usuário não encontrado");

        Usuario usuario = optionalUsuario.get();

        if(usuario.getComics().isEmpty())
            usuarioComicsView.setComicList(comicsUserViewList);
        else {
            DayOfWeek diaDaSemana = LocalDate.now().getDayOfWeek();

            usuario.getComics().forEach(comics -> {
                ComicsUserView comicsUserView;
                comicsUserView = preencheComicsUserView(comics);

                String isbn = comics.getIsbn();
                String ultimoDigito;
                DayOfWeek diaDeDesconto;

                if (!isbn.isEmpty()){
                    ultimoDigito = isbn.substring(12);
                    diaDeDesconto = getDiaDeDesconto(ultimoDigito);

                    if (diaDeDesconto == diaDaSemana){
                        comicsUserView.setDescontoAtivo(true);
                        Float precoComDesconto = calculaDesconto(comicsUserView.getPreco());
                        comicsUserView.setPreco(precoComDesconto);
                    }
                }
                comicsUserViewList.add(comicsUserView);
            });
        }

        usuarioComicsView.setUsuarioId(usuarioId);
        usuarioComicsView.setComicList(comicsUserViewList);

        return new ResponseEntity<UsuarioComicsView>(usuarioComicsView, HttpStatus.OK);
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

    private ComicsUserView preencheComicsUserView(Comics comics){
        ComicsUserView comicsUserView = new ComicsUserView();

        comicsUserView.setComicId(comics.getComicId());
        comicsUserView.setTitulo(comics.getTitulo());
        comicsUserView.setPreco(comics.getPreco());
        comicsUserView.setIsbn(comics.getIsbn());
        comicsUserView.setDescricao(comics.getDescricao());
        comicsUserView.setDescontoAtivo(false);

        return comicsUserView;
    }
    private DayOfWeek getDiaDeDesconto(String ultimoDigito){
        if(ultimoDigito.equals("0") || ultimoDigito.equals("1"))
            return DayOfWeek.MONDAY;
        else if(ultimoDigito.equals("2") || ultimoDigito.equals("3"))
            return DayOfWeek.TUESDAY;
        else if(ultimoDigito.equals("4") || ultimoDigito.equals("5"))
            return DayOfWeek.WEDNESDAY;
        else if(ultimoDigito.equals("6") || ultimoDigito.equals("7"))
            return DayOfWeek.THURSDAY;
        else if(ultimoDigito.equals("8") || ultimoDigito.equals("9"))
            return DayOfWeek.FRIDAY;
        else return null;
    }

    private Float calculaDesconto(Float preco){
        if(preco == 0)
            return preco;
        else
            return preco = preco - (0.10f*preco);
    }
}
