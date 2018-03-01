package com.example.alvaaro.examenrecusegundajavierrl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos.add(new Contacto("Javier","918824773"));
        contactos.add(new Contacto("Manolo","912548542"));
        contactos.add(new Contacto("Adriano","912542563"));
        contactos.add(new Contacto("Sergio","985214587"));
        contactos.add(new Contacto("Victor","914224512"));
        try{
            contactos = (ArrayList)getIntent().getExtras().getParcelableArrayList("ListaContactos");
        }catch(Exception e){}

        btn1 = findViewById(R.id.btnAgregar);
        btn2 = findViewById(R.id.btnListar);
    }

    public void Agregar(View v){
        Intent paso = new Intent(getApplicationContext(), MainAgenda.class);
        paso.putExtra("ListaContactos",contactos);
        startActivity(paso);
    }

    public void Listar(View v){
        Intent paso = new Intent(getApplicationContext(), MainAgenda.class);
        paso.putExtra("ListaContactos",contactos);
        startActivity(paso);
    }
}
