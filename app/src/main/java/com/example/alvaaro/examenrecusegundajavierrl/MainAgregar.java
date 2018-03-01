package com.example.alvaaro.examenrecusegundajavierrl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by alvaaro on 01/03/2018.
 */

public class MainAgregar extends AppCompatActivity{

    ArrayList<Contacto> contactos;
    EditText etNombre, etNumero;
    Button btnGuardar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        etNombre = findViewById(R.id.etNombre);
        etNumero = findViewById(R.id.etTelefono);

        contactos = (ArrayList)getIntent().getExtras().getParcelableArrayList("ListaContactos");
        btnGuardar = findViewById(R.id.btnGuardar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contacto c = new Contacto(etNombre.toString(),etNumero.toString());
                contactos.add(c);

                Toast.makeText(MainAgregar.this, "Contacto añadido", Toast.LENGTH_SHORT).show();

                Intent paso = new Intent(getApplicationContext(), MainActivity.class);
                paso.putExtra("ListaContactos",contactos);
                startActivity(paso);
            }
        });
    }

}
