package com.sam.email_3e;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_listadapter extends BaseAdapter {
    Context Contexto;
    String[] Nombres, Horas, Descripciones;

    boolean[] Leido;
    int[] imageID;
    LayoutInflater inflater;

    public activity_listadapter(Context contexto, String[] nombres, String[] horas, int[] imageID, String[] descripciones, boolean[] leido){
        this.Contexto = contexto;
        this.Nombres = nombres;
        this.Horas = horas;
        this.imageID = imageID;
        this.Descripciones = descripciones;
        this.Leido = leido;
        inflater = LayoutInflater.from(contexto);
    }

    @Override
    public int getCount(){
        return Nombres.length;
    }

    @Override
    public Object getItem(int i){
        return null;
    }

    @Override
    public long getItemId(int i){
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup){
        view = inflater.inflate(R.layout.activity_listadapter, null);
        ImageView fotoEmail = view.findViewById(R.id.foto);
        TextView nombreEmisor = view.findViewById(R.id.nombre);
        TextView horaEmail = view.findViewById(R.id.horaEmail);
        fotoEmail.setImageResource(imageID[i]);

        horaEmail.setText(Horas[i]);
        nombreEmisor.setText(Nombres[i]);

        if (Leido[i]){
            nombreEmisor.setTypeface(null, Typeface.NORMAL);
            horaEmail.setTypeface(null, Typeface.NORMAL);

        } else {
            nombreEmisor.setTypeface(null, Typeface.BOLD);
            horaEmail.setTypeface(null, Typeface.BOLD);

        }

        return view;
    }
    private String resentParser(Boolean resent){
        return resent ? "Email reenviado" : "Este email no ha sido reenviado";
    }
}