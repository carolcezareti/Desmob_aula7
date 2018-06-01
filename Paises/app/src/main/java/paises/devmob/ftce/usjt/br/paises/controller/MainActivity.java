package paises.devmob.ftce.usjt.br.paises.controller;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import paises.devmob.ftce.usjt.br.paises.R;
import paises.devmob.ftce.usjt.br.paises.model.Paises;
import paises.devmob.ftce.usjt.br.paises.model.PaisesNetwork;

public class MainActivity extends Activity {
    public static final String PAIS = "paises.devmob.ftce.usjt.br.paises";
    private EditText txtFila;
    Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFila = (EditText)findViewById(R.id.buscar_fila);
        contexto = this;
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new TabsAdapter(fm));
        if (savedInstanceState == null){
            FragmentTransaction ft = fm.beginTransaction();
            HelloWorldFragments hwf = new HelloWorldFragments();
            ft.add(R.id.layoutFrag, hwf, "HelloWorldFragmentTag");
            ft.commit();
        }
    }

    public FragmentManager getSupportFragmentManager() {
        return supportFragmentManager;
    }

    final ActionBar actionBar = getSupportActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab().setText("Frag1").setTabListener(new MyTabListener(viewPager, 0)));
        actionBar.addTab(actionBar.newTab().setText("Frag2").setTabListener(new MyTabListener(viewPager, 1)));
        actionBar.addTab(actionBar.newTab().setText("Frag3").setTabListener(new MyTabListener(viewPager, 2)));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float
        positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            Toast.makeText(MainActivity.this, "chamou",
                    Toast.LENGTH_SHORT).show();
            actionBar.setSelectedNavigationItem(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });


    private class DownloadJsonChamados extends AsyncTask<String, Void, ArrayList<Paises>> {

        @Override
        protected ArrayList<Paises> doInBackground(String... strings) {
            ArrayList<Paises> paises = new ArrayList<>();
            try {
                paises = PaisesNetwork.buscarPaises(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return paises;
        }
    }
    protected void onPostExecute(ArrayList<Paises> paises){
        Intent intent = new Intent(contexto, ListarPaisesActivity.class);
        intent.putExtra(PAIS, paises);
        startActivity(intent);
    }
}

