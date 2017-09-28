package br.com.a11vs11.app.model;

import java.io.Serializable;

/**
 * Created by Leandro Jara on 25/09/2017.
 */

public class Plataforma implements Serializable {

    private int id;
    private String nome;

    public Plataforma() {
    }

    public Plataforma(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
