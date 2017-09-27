package br.com.a11vs11.app.model;

import java.io.Serializable;

/**
 * Created by TDR on 25/09/2017.
 */

public class Clube implements Serializable {

    private int id;
    private String nome;
    private Plataforma plataforma;
    private int drawable;

    public Clube() {
    }

    public Clube(String nome) {
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

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
