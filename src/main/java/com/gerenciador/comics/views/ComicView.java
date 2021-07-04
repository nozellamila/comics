package com.gerenciador.comics.views;

import com.gerenciador.comics.domains.Comics;

import javax.persistence.Column;

public class ComicView {
    private Integer id;
    private Integer comicId;
    private String titulo;
    private Float preco;
    private String isbn;
    private String descricao;
    private Integer usuarioId;

    public ComicView(){}

    public ComicView(Comics comics, Integer usuarioId){
        this.id = comics.getId();
        this.comicId = comics.getComicId();
        this.titulo = comics.getTitulo();
        this.preco = comics.getPreco();
        this.isbn = comics.getIsbn();
        this.descricao = comics.getDescricao();
        this.usuarioId = usuarioId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComicId() {
        return comicId;
    }

    public void setComicId(Integer comicId) {
        this.comicId = comicId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
