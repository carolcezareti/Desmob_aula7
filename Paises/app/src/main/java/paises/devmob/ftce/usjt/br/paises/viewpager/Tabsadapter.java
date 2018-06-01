package paises.devmob.ftce.usjt.br.paises.viewpager;

import android.app.Fragment;
import android.app.FragmentManager;

import paises.devmob.ftce.usjt.br.paises.model.FragmentPagerAdapter;

/**
 * Created by carol on 01/06/2018.
 */

public class TabsAdapter extends FragmentPagerAdapter {
    //construtor da super classe requer um
//fragment manager
    public TabsAdapter (FragmentManager fm){
        super (fm);
    }
    //responde quantos itens há na coleção
//teremos 3
    @Override
    public int getCount() {
        return 3;
    }
    //devolve item de acordo com sua posição
//note a simplicidade desse método (por enquanto)
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new Fragment1();
        }
        else if (position == 1){
            return new Fragment2();
        }
        else
            return new Fragment3();
    }

    private class Fragment1 extends Fragment {
    }

    private class Fragment2 extends Fragment {
    }

    private class Fragment3 extends Fragment {
    }
}
