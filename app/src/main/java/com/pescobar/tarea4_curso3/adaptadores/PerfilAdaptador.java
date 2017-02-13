package com.pescobar.tarea4_curso3.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.pescobar.tarea4_curso3.R;

import java.util.ArrayList;

/**
 * Created by PabloCesar on 11/02/2017.
 */

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.MascotaViewHolder>
{
    ArrayList<Mascota> mascotas;
    Activity activity;

    public PerfilAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        //Método constructor, construye la lista de mascotas.
        this.mascotas= mascotas;
        this.activity= activity;

    }


    @Override
    public PerfilAdaptador.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Da vida al layaout cardView (Inflador)
        // Inflar el layaout y lo pasará al Viewholder para que el obtenga cada elemento
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil,parent,false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilAdaptador.MascotaViewHolder holder, int position) {
//Pasa la lista de mascotas a cada elemento, setea valores
        //Asocia cada elemento de la lista a cada view
        final Mascota mascota= mascotas.get(position);
        holder.imgMascota.setImageResource(mascota.getFotoMascota());
        holder.txtLikesMascota.setText(String.valueOf(mascota.getLikesMascota()));

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascota;
        private TextView txtLikesMascota;
        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.imgFotoPerfil);
            txtLikesMascota = (TextView) itemView.findViewById(R.id.txtLikesMascotaPerfil);
        }
    }
}
