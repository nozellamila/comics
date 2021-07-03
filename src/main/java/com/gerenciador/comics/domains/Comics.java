package com.gerenciador.comics.domains;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Comics implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;
    private Float preco;
    
}
