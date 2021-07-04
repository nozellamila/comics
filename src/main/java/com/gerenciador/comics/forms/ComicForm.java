package com.gerenciador.comics.forms;

import javax.validation.constraints.NotNull;

public class ComicForm {

    @NotNull(message = "Id do comic deve ser informado")
    private Integer comicId;
    @NotNull(message = "Id do usuário deve ser informado")
    private Integer usuarioId;

    public Integer getComicId() {
        return comicId;
    }

    public void setComicId(Integer comicId) {
        this.comicId = comicId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
