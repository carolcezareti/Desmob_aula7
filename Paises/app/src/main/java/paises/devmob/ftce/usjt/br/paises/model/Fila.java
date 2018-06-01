package paises.devmob.ftce.usjt.br.paises.model;

/**
 * Created by carol on 26/03/2018.
 */

public class Fila {
    private int id;
    private String nome, figura;

    public Fila(int id, String nome, String figura) {
        this.id = id;
        this.nome = nome;
        this.figura = figura;

    }

    public Fila() {
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

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    @Override
    public String toString() {
        return "Fila{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", figura='" + figura + '\'' +
                '}';
    }
}
