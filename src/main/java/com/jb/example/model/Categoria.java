package com.jb.example.model;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @EmbeddedId
    private CategoriaId id;

    public Categoria() {
    }

    public Categoria(String nome) {

        this.id = new CategoriaId(nome, "TIPO");
    }

    public CategoriaId getId() {
        return id;
    }

    public void setId(CategoriaId id) {
        this.id = id;
    }

    public String getNome() {
        return this.id.getNome();
    }

}
