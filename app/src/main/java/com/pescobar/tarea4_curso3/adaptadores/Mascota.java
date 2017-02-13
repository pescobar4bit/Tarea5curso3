package com.pescobar.tarea4_curso3.adaptadores;

/**
 * Created by PabloCesar on 10/02/2017.
 */

public class Mascota {
    private String nombreMascota;
    private int fotoMascota;
    private int LikesMascota;

    public Mascota(String nombreMascota, int fotoMascota, int likesMascota) {
        this.nombreMascota = nombreMascota;
        this.fotoMascota = fotoMascota;
        this.LikesMascota = likesMascota;
    }

    public Mascota(int fotoMascota, int likesMascota) {
        this.fotoMascota = fotoMascota;
        this.LikesMascota = likesMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public int getLikesMascota() {
        return LikesMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public void setLikesMascota(int likesMascota) {
        LikesMascota = likesMascota;
    }
}

