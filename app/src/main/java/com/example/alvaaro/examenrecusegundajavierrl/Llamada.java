package com.example.alvaaro.examenrecusegundajavierrl;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Intent.ACTION_CALL;


/**
 * Created by alvaaro on 01/03/2018.
 */

public class Llamada extends AppCompatActivity {

    private static final int MAKE_CALL_PERMISSION_REQUEST_CODE = 1;
    String aux, aux1;
    TextView tvNombre, tvNumero;
    ImageButton ibLlamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamar);

        ibLlamar = findViewById(R.id.ibLlamar);
        aux = getIntent().getExtras().getString("nombre");
        aux1 = getIntent().getExtras().getString("numero");
        tvNombre.setText(aux);
        tvNumero.setText(aux1);

        ibLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numeroTelefono = tvNumero.getText().toString();

                if (TextUtils.isEmpty(numeroTelefono)) {
                    if (comprobarPermiso(Manifest.permission.CALL_PHONE)) {
                        String dial = "tel:" + numeroTelefono;
                        if (ActivityCompat.checkSelfPermission(Llamada.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        startActivity(new Intent(ACTION_CALL, Uri.parse(dial)));
                    } else {
                        Toast.makeText(Llamada.this, "Permiso de llamada denegado", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //
                }
            }
        });
        if (comprobarPermiso(Manifest.permission.CALL_PHONE)) {
            ibLlamar.setEnabled(true);
        } else {
            ibLlamar.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, MAKE_CALL_PERMISSION_REQUEST_CODE);
        }
    }

    private boolean comprobarPermiso(String permission) {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case MAKE_CALL_PERMISSION_REQUEST_CODE :
                if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    ibLlamar.setEnabled(true);
                }
                return;
        }
    }
}
