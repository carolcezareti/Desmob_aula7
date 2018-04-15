package paises.devmob.ftce.usjt.br.paises.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import paises.devmob.ftce.usjt.br.paises.R;
import paises.devmob.ftce.usjt.br.paises.model.Paises;
import paises.devmob.ftce.usjt.br.paises.model.PaisesAdapter;

/**
 * Created by carol on 26/03/2018.
 */


public class ListarPaisesActivity extends Activity {
    public static final String PAIS = "paises.devmob.ftce.usjt.br.paises";
    ArrayList<Paises> paises;
    ListView listView;
    Activity contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_paises);
        Intent intent = getIntent();
        paises = (ArrayList<Paises>)intent.getSerializableExtra(MainActivity.PAIS);
        listView = (ListView) findViewById(R.id.lista_paises);
        PaisesAdapter adapter = new PaisesAdapter(this, paises);
        listView.setAdapter(adapter);
        contexto = this;

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Paises paises = paises.get(position);
                        Intent intent1 = new Intent(contexto , DetalhePaisesActivity.class);
                        intent1.putExtra(PAIS, String.valueOf(paises));
                        startActivity(intent1);
                    }
                }
        );
    }
}
