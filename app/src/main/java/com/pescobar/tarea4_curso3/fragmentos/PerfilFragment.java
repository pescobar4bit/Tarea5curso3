package com.pescobar.tarea4_curso3.fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pescobar.tarea4_curso3.R;
import com.pescobar.tarea4_curso3.adaptadores.Mascota;
import com.pescobar.tarea4_curso3.adaptadores.MascotaAdaptador;
import com.pescobar.tarea4_curso3.adaptadores.PerfilAdaptador;

import java.util.ArrayList;

/**
 * Created by PabloCesar on 10/02/2017.
 */

public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragmentperfilmascota,container,false);

        listaMascotas= (RecyclerView) v.findViewById(R.id.rvFotos);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        // llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm= new GridLayoutManager(getActivity(),3);
        listaMascotas.setLayoutManager(glm);
        InicializarListaContactos();
        InicializarAdaptador();

        return v;
    }

    public void InicializarAdaptador(){
        PerfilAdaptador adaptador= new PerfilAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void InicializarListaContactos(){
        mascotas= new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.perro5,5));
        mascotas.add(new Mascota(R.drawable.perro5,0));
        mascotas.add(new Mascota(R.drawable.perro5,3));
        mascotas.add(new Mascota(R.drawable.perro5,10));
        mascotas.add(new Mascota(R.drawable.perro5,2));
        mascotas.add(new Mascota(R.drawable.perro5,3));
        mascotas.add(new Mascota(R.drawable.perro5,1));
        mascotas.add(new Mascota(R.drawable.perro5,7));
        mascotas.add(new Mascota(R.drawable.perro5,0));
    }

}
