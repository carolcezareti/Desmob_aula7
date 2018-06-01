package paises.devmob.ftce.usjt.br.paises.viewpager;

import android.app.ActionBar;
import android.app.FragmentTransaction;



/**
 * Created by carol on 01/06/2018.
 */

public class MyTabsListener implements ActionBar.TabListener{
    private ViewPager viewPager;
    private int index;
    public MyTabsListener (ViewPager vp, int index){
        this.viewPager = vp;
        this.index = index;
    }
    @Override
    public void onTabSelected(ActionBar.Tab tab,
                              FragmentTransaction ft) {
        viewPager.setCurrentItem(index);
    }
    @Override
    public void onTabUnselected(ActionBar.Tab tab,
                                FragmentTransaction ft) {
    }
    @Override
    public void onTabReselected(ActionBar.Tab tab,
                                FragmentTransaction ft) {
    }

}
