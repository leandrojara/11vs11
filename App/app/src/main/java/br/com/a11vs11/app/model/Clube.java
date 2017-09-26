package br.com.a11vs11.app.model;

/**
 * Created by TDR on 25/09/2017.
 */

public class Clube {

    private int id;
    private String nome;
    private Plataforma plataforma;

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
}
