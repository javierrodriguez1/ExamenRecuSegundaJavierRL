package com.example.alvaaro.examenrecusegundajavierrl;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alvaaro on 01/03/2018.
 */

public class Adaptador extends BaseAdapter{
        Context contexto;
        ArrayList<Contacto> lista;

    public Adaptador(Context contexto, ArrayList<Contacto> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

        @Override
        public int getCount() {
        return lista.size();
    }

        @Override
        public Contacto getItem(int i) {
        return lista.get(i);
    }

        @Override
        public long getItemId(int i) {
        return i;
    }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

        View vista=view;
        LayoutInflater inflate = LayoutInflater.from(contexto);
        vista=inflate.inflate(R.layout.item, null);

        ImageView imagen = vista.findViewById(R.id.ivContacto);
        TextView tvNombre = vista.findViewById(R.id.tvNombre);
        TextView tvNumero= vista.findViewById(R.id.tvNumero);

        tvNombre.setText(lista.get(i).getNombre());
        tvNumero.setText(lista.get(i).getNumero());

        return vista;
    }
}
