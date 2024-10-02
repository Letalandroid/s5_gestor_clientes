package com.lta.s5_50;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Digitador extends AppCompatActivity {

    TextView lblPerfil;
    EditText txtNombre;
    EditText txtApellido;
    Spinner spnEstadoC;
    Button btnNext;
    RadioButton radioButton1;
    RadioButton radioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digitador);

        lblPerfil = findViewById(R.id.lblPeffil);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        spnEstadoC = findViewById(R.id.spnEstadoC);
        btnNext = findViewById(R.id.btnSkip);

        lblPerfil.setText(String.format("Perfil: %s - Tipo: %s",
                getIntent().getStringExtra("username"),
                getIntent().getStringExtra("tipo")));

        btnNext.setOnClickListener(v -> {
            try {
                mostrarData();
            } catch (Exception e) {
                Log.i("ep_1", e.toString());
            }
        });
    }

    private void mostrarData() {
        Intent it = new Intent(this, ResumenCliente.class);
        it.putExtra("nombre", txtNombre.getText().toString());
        it.putExtra("apellido", txtApellido.getText().toString());
        it.putExtra("genero", getGen());
        it.putExtra("estado_civil", spnEstadoC.getSelectedItem().toString());
        startActivity(it);
    }

    private String getGen() {
        if (radioButton1.isChecked()) {
            return radioButton1.getText().toString();
        } else if (radioButton2.isChecked()) {
            return radioButton2.getText().toString();
        }

        return "No seleccionado";
    }
}