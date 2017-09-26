package br.com.a11vs11.app.model;

import android.database.Cursor;

/**
 * Created by TDR on 25/09/2017.
 */

public class Manager {

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
                        setClube(new Clube(cursor.getString(i)));
                    }
                    break;
                case "nomePlataforma":
                    if (this.getClube() == null) {
                        setClube(new Clube());
                    }
                    if (this.getClube().getPlataforma() == null) {
                        this.getClube().setPlataforma(new Plataforma(cursor.getString(i)));
                    } else {
                        this.getClube().getPlataforma().setNome(cursor.getString(i));
                    }
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
