package com.lta.s5_50;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ventas extends AppCompatActivity {

    Button btnReturn;
    TextView lblProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);

        btnReturn = findViewById(R.id.btnReturn);
        lblProfile = findViewById(R.id.lblPeffil2);

        lblProfile.setText(String.format("Perfil: %s - Tipo: %s",
                getIntent().getStringExtra("username"),
                getIntent().getStringExtra("tipo")));

        btnReturn.setOnClickListener(v -> {
            finish();
        });
    }
}