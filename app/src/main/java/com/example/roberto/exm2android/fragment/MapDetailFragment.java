package com.example.roberto.exm2android.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roberto.exm2android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapDetailFragment extends Fragment {
    public TextView txtNombre;
    public TextView txtCiudad;
    public TextView txtPais;


    public MapDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map_detail, container, false);


        txtNombre = v.findViewById(R.id.txtNombre);
        txtCiudad = v.findViewById(R.id.txtCiudad);
        txtPais= v.findViewById(R.id.txtPais);
        return v;
    }

    public void setSelectedLocation(){

    }


}
