package com.gerenciador.comics.views;

import java.util.ArrayList;
import java.util.List;

public class UsuarioComicsView {
    private Integer usuarioId;
    private List<ComicsUserView> comicList = new ArrayList<>();

    public UsuarioComicsView(){}

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ComicsUserView> getComicList() {
        return comicList;
    }

    public void setComicList(List<ComicsUserView> comicList) {
        this.comicList = comicList;
    }
}

