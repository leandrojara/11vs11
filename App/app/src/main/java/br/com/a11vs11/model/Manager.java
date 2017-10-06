package br.com.a11vs11.model;

import android.database.Cursor;

import java.io.Serializable;

/**
 * Created by Leandro Jara on 25/09/2017.
 */

public class Manager implements Serializable {

    private int id;
    private String nome;
    private String telefone;
    private String email;
    private Clube clube;

    public Manager() {
    }

    public Manager(Cursor cursor) {
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            switch (cursor.getColumnName(i)) {
                case "id":
                    setId(cursor.getInt(i));
                    break;
                case "nome":
                    setNome(cursor.getString(i));
                    break;
                case "telefone":
                    setTelefone(cursor.getString(i));
                    break;
                case "email":
                    setEmail(cursor.getString(i));
                    break;
                case "nomeClube":
                    if (this.getClube() == null) {
                        setClube(new Clube());
                    }
                    getClube().setNome(cursor.getString(i));
                    break;
                case "drawableClube":
                    if (this.getClube() == null) {
                        setClube(new Clube());
                    }
                    getClube().setDrawable(cursor.getInt(i));
                    break;
                case "nomePlataforma":
                    if (this.getClube() == null) {
                        setClube(new Clube());
                    }
                    if (this.getClube().getPlataforma() == null) {
                        this.getClube().setPlataforma(new Plataforma());
                    }
                    this.getClube().getPlataforma().setNome(cursor.getString(i));
                    break;
            }
        }
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }
}
