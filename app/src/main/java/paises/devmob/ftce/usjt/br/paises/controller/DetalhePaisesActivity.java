package paises.devmob.ftce.usjt.br.paises.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import paises.devmob.ftce.usjt.br.paises.R;
import paises.devmob.ftce.usjt.br.paises.model.Paises;
import paises.devmob.ftce.usjt.br.paises.model.Util;

/**
 * Created by carol on 26/03/2018.
 */

public abstract class DetalhePaisesActivity extends Context {
    private int contentView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_detalhes_paises);
        Intent intent = getIntent();
        Paises paises = (Paises) intent.getSerializableExtra(ListarPaisesActivity.PAIS);
        ImageView foto = (ImageView) foto.findViewById();
        Drawable drawable = Util.getDrawableDinamic(this, paises.getFila().getFigura());
        foto.setImageDrawable(drawable);
        TextView fila = (TextView) fila.findViewById();
        fila.setText(paises.getFila().getNome());
        TextView id = (TextView) id.findViewById();
        id.setText(""+paises.getId());
        TextView nome = (TextView) nome.findViewById();
        nome.setText(""+paises.getNome());
        TextView bandeira = (TextView) bandeira.findViewById();
        bandeira.setText(String.format("%tD",paises.getBandeira()));
        TextView regiao = (TextView) regiao.findViewById();
        regiao.setText(""+paises.getRegiao());
        TextView capital = (TextView) capital.findViewById();
        capital.setText(""+paises.getCapital());
    }

    public Intent getIntent() {
        return intent;
    }

    public void setContentView(int contentView) {
        this.contentView = contentView;
    }
}