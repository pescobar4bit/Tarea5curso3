package com.pescobar.tarea4_curso3.fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pescobar.tarea4_curso3.R;
import com.pescobar.tarea4_curso3.adaptadores.Mascota;
import com.pescobar.tarea4_curso3.adaptadores.MascotaAdaptador;

import java.util.ArrayList;

/**
 * Created by PabloCesar on 10/02/2017.
 */

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState)
        //Asignar clase de java a este layaout
        View v= inflater.inflate(R.layout.fragmentrecyclerview,container,false);

        listaMascotas= (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        // GridLayoutManager glm= new GridLayoutManager(this,2);
        listaMascotas.setLayoutManager(llm);
        InicializarListaContactos();
        InicializarAdaptador();

        return v;
    }

    public void InicializarAdaptador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void InicializarListaContactos(){
        mascotas= new ArrayList<>();
        mascotas.add(new Mascota("Vegas",R.drawable.perro1,0));
        mascotas.add(new Mascota("Rocky",R.drawable.perro2,0));
        mascotas.add(new Mascota("Arturo",R.drawable.perro3,0));
        mascotas.add(new Mascota("Gofy",R.drawable.perro4,5));
        mascotas.add(new Mascota("Marshall",R.drawable.perro5,0));
        mascotas.add(new Mascota("Rufo",R.drawable.perro6,0));
        mascotas.add(new Mascota("Madrid",R.drawable.perro7,10));
        mascotas.add(new Mascota("Lupa",R.drawable.perro8,0));
    }

}
