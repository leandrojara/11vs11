package br.com.a11vs11.model;

import android.database.Cursor;

import java.io.Serializable;

/**
 * Created by Leandro Jara on 25/09/2017.
 */

public class FAQ implements Serializable {

    private int id;
    private String pergunta;
    private String resposta;

    public FAQ() {
    }

    public FAQ(Cursor cursor) {
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            switch (cursor.getColumnName(i)) {
                case "id":
                    setId(cursor.getInt(i));
                    break;
                case "pergunta":
                    setPergunta(cursor.getString(i));
                    break;
                case "resposta":
                    setResposta(cursor.getString(i));
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

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
