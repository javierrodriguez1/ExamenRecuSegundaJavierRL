package com.example.alvaaro.examenrecusegundajavierrl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alvaaro on 01/03/2018.
 */

public class MainAgenda extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    TextView tvNombre, tvNumero;
    ImageButton ibBorrar,ibLlamar,ibMensaje;
    ListView lvContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        tvNombre = findViewById(R.id.tvNombre);
        tvNumero = findViewById(R.id.tvNumero);
        ibBorrar = findViewById(R.id.ibBorrar);
        ibLlamar = findViewById(R.id.ibMensaje);
        ibMensaje = findViewById(R.id.ibMensaje);
        lvContactos = findViewById(R.id.lvContactos);

        contactos = (ArrayList)getIntent().getExtras().getParcelableArrayList("ListaContactos");

        Adaptador adapter = new Adaptador(getApplicationContext(),contactos);
        lvContactos.setAdapter(adapter);

        ibLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paso = new Intent(getApplicationContext(),Llamada.class);
                paso.putExtra("nombre",tvNombre.toString());
                paso.putExtra("numero",tvNumero.toString());
                startActivity(paso);
            }
        });

        ibMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paso = new Intent(getApplicationContext(),Mensaje.class);
                paso.putExtra("nombre",tvNombre.toString());
                paso.putExtra("numero",tvNumero.toString());
                startActivity(paso);
            }
        });
    }
}
