package com.gerenciador.comics.views;

public class ComicsUserView {
    private Integer comicId;
    private String titulo;
    private Float preco;
    private String isbn;
    private String descricao;
    private boolean descontoAtivo;

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

    public boolean isDescontoAtivo() {
        return descontoAtivo;
    }

    public void setDescontoAtivo(boolean descontoAtivo) {
        this.descontoAtivo = descontoAtivo;
    }
}
