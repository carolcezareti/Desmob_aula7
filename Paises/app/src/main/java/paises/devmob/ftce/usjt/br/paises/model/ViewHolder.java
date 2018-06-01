package paises.devmob.ftce.usjt.br.paises.model;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by carol on 26/03/2018.
 */

public class ViewHolder {
    private TextView id, nome, bandeira, regiao, capital;
    private ImageView imagem;

    public TextView getId() {
        return id;
    }

    public void setId(TextView id) {
        this.id = id;
    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getBandeira() {
        return bandeira;
    }

    public void setBandeira(TextView bandeira) {
        this.bandeira = bandeira;
    }

    public TextView getRegiao() {
        return regiao;
    }

    public void setRegiao(TextView regiao) {
        this.regiao = regiao;
    }

    public TextView getCapital() {
        return capital;
    }

    public void setCapital(TextView capital) {
        this.capital = capital;
    }

    public ImageView getImagem() {
        return imagem;
    }

    public void setImagem(ImageView imagem) {
        this.imagem = imagem;
    }
}
