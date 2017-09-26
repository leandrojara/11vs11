package br.com.a11vs11.app.model;

/**
 * Created by TDR on 25/09/2017.
 */

public class FAQ {

    private int id;
    private String pergunta;
    private String resposta;

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
