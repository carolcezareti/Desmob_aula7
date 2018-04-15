package paises.devmob.ftce.usjt.br.paises.model;

/**
 * Created by carol on 26/03/2018.
 */

public class Paises {
    private int id;
    private String nome, bandeira, regiao, capital;
    private Fila fila;


    public Paises(int id, String nome, String bandeira, String regiao, String capital, Fila fila) {
        this.id = id;
        this.nome = nome;
        this.bandeira = bandeira;
        this.regiao = regiao;
        this.capital = capital;
        this.fila = fila;
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

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public void add() {
    }
}
