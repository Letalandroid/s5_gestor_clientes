package com.lta.s5_50;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ResumenCliente extends AppCompatActivity {

    EditText txtResumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_cliente);

        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        String estado_civil = getIntent().getStringExtra("estado_civil");
        String genero = getIntent().getStringExtra("genero");
        String cod = nombre.substring(0, 2) + nombre.substring(0, 1) + "2024";
        txtResumen = findViewById(R.id.txtResumen);

        txtResumen.setText(String.format("Código: %s\n" +
                                        "Nombre: %s\n" +
                                        "Apellidos: %s\n" +
                                        "Estado Civil: %s\n" +
                                        "Genero: %s",
        cod, nombre, apellido, estado_civil, genero));
    }
}