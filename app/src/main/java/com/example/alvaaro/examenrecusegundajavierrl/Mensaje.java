package com.example.alvaaro.examenrecusegundajavierrl;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by alvaaro on 01/03/2018.
 */

public class Mensaje extends AppCompatActivity
{
    String aux,aux1;
    TextView tvNombre,tvNumero;
    EditText etMensaje;
    ImageButton ibEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        aux = getIntent().getExtras().getString("nombre");
        aux1 = getIntent().getExtras().getString("numero");
        tvNombre = findViewById(R.id.tvNom);
        tvNombre.setText(aux);
        tvNumero = findViewById(R.id.tvTelefono);
        tvNumero.setText(aux1);
        ibEnviar = findViewById(R.id.ibMensaje);
        etMensaje = findViewById(R.id.etMensaje);
    }

    public void enviarMensaje(View v){
        try{
            int permisoEnvioSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

            if(permisoEnvioSMS != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(), "No tienes permisos para mandar sms", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},225);
            }else{

            }
        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage(tvNumero.toString() ,null, etMensaje.getText().toString(), null, null);
        Toast.makeText(getApplicationContext(), "Mensaje enviado", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Mensaje no enviado, verifique persmisos o datos" + e.getMessage().toString(),Toast.LENGTH_LONG ).show();
        }
    }
}
