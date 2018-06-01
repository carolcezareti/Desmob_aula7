package paises.devmob.ftce.usjt.br.paises.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import paises.devmob.ftce.usjt.br.paises.R;

/**
 * Created by carol on 01/06/2018.
 */

public class HelloWorldFragments {
    public HelloWorldFragments() {
        // Required empty public constructor
    }
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello_world, container, false);
    }
}
