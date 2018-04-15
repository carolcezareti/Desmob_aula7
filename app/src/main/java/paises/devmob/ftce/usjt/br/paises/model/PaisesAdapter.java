package paises.devmob.ftce.usjt.br.paises.model;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import paises.devmob.ftce.usjt.br.paises.R;
import paises.devmob.ftce.usjt.br.paises.controller.ListarPaisesActivity;

/**
 * Created by carol on 26/03/2018.
 */

public class PaisesAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Paises> paises;

    public PaisesAdapter(Context context, ArrayList<Paises> paises) {
        this.context = context;
        this.paises = paises;
    }

    @Override
    public int getCount() {
        return paises.size();
    }

    @Override
    public Object getItem(int position) {
        return paises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_paises, parent, false);

            ImageView imagem = (ImageView) view.findViewById(R.id.imagem_fila);
            TextView id = (TextView) view.findViewById(R.id.id_paises);
            TextView nome = (TextView) view.findViewById(R.id.nome_paises);
            TextView bandeira = (TextView) view.findViewById(R.id.bandeira_paises);
            TextView regiao = (TextView) view.findViewById(R.id.regiao_paises);
            TextView capital = (TextView) view.findViewById(R.id.capital_paises);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.setId(id);
            viewHolder.setNome(nome);
            viewHolder.setBandeira(bandeira);
            viewHolder.setRegiao(regiao);
            viewHolder.setCapital(capital);
            viewHolder.setImagem(imagem);
            view.setTag(viewHolder);
        }

        Paises paises = paises.get(position);

        ViewHolder viewHolder = (ViewHolder) view.getTag();

        viewHolder.getImagem().setImageDrawable(Util.getDrawableDinamic(context, paises.getFila().getFigura()));

        viewHolder.getId().setText(String.format("id: %d", viewHolder.getId()));
        viewHolder.getNome().setText(paises.getNome());

        return view;
    }
}
