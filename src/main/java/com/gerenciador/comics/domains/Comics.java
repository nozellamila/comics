package com.gerenciador.comics.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Comics implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comic_id")
    private Integer id;
    private String titulo;
    private Float preco;
    private String isbn;
    private String descricao;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "COMIC_USUARIO",
            joinColumns = @JoinColumn(name = "comic_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Comics() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comics)) return false;
        Comics comics = (Comics) o;
        return Objects.equals(getId(), comics.getId()) && Objects.equals(getTitulo(), comics.getTitulo()) && Objects.equals(getPreco(), comics.getPreco()) && Objects.equals(getIsbn(), comics.getIsbn()) && Objects.equals(getDescricao(), comics.getDescricao()) && Objects.equals(getUsuarios(), comics.getUsuarios());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitulo(), getPreco(), getIsbn(), getDescricao(), getUsuarios());
    }
}
