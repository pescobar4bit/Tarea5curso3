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
 * Created by PabloCesar on 10/02/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>
{

    ArrayList<Mascota> mascotas;
    Activity activity;
    Integer contLikes=0;
    Integer contLikesActuales=0;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        //Método constructor, construye la lista de mascotas.
        this.mascotas= mascotas;
        this.activity= activity;

    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Da vida al layaout cardView (Inflador)
        // Inflar el layaout y lo pasará al Viewholder para que el obtenga cada elemento
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);

        return new MascotaViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        //Pasa la lista de mascotas a cada elemento, setea valores
        //Asocia cada elemento de la lista a cada view
        final Mascota mascota= mascotas.get(position);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFotoMascota());
        mascotaViewHolder.txtNombreMascota.setText(mascota.getNombreMascota());
        mascotaViewHolder.txtLikesMascota.setText(String.valueOf(mascota.getLikesMascota()));

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contLikesActuales=mascota.getLikesMascota();
                contLikes=contLikesActuales + 1;
                mascota.setLikesMascota(contLikes);
                mascotaViewHolder.txtLikesMascota.setText(String.valueOf(mascota.getLikesMascota()));
                //Toast.makeText(activity, "Diste like a " + mascota.getNombreMascota() + "ahora tiene " + contLikes +
                //         " Likes",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascota;
        private TextView txtNombreMascota;
        private TextView txtLikesMascota;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.imgFoto);
            txtNombreMascota = (TextView) itemView.findViewById(R.id.txtNombreMascota);
            txtLikesMascota = (TextView) itemView.findViewById(R.id.txtLikesMascota);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnHuesoBlanco);
        }
    }
}
