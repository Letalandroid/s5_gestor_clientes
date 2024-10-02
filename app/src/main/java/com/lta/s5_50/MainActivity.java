package com.lta.s5_50;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import Clases.User;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> usuarios = new ArrayList<>();
    EditText txtUsername;
    EditText txtPassword;
    Button btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.txtusername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLog = findViewById(R.id.btnLogin);

        usuarios.add(new User("DIGIT", "123", "DIGITADOR"));
        usuarios.add(new User("VENDE", "abc", "VENDEDOR"));

        btnLog.setOnClickListener(v -> {
            loguin();
        });
    }

    private void loguin() {
        if (txtUsername.getText().toString().equals(usuarios.get(0).getUsername()) &&
            txtPassword.getText().toString().equals(usuarios.get(0).getPassword())) {

            Intent it = new Intent(this, Digitador.class);
            it.putExtra("username", usuarios.get(0).getUsername());
            it.putExtra("tipo", usuarios.get(0).getTipo());
            startActivity(it);

        } else if (txtUsername.getText().toString().equals(usuarios.get(1).getUsername()) &&
                    txtPassword.getText().toString().equals(usuarios.get(1).getPassword())) {

            Intent it = new Intent(this, Ventas.class);
            it.putExtra("username", usuarios.get(1).getUsername());
            it.putExtra("tipo", usuarios.get(1).getTipo());
            startActivity(it);

        } else {
            Toast.makeText(this, "Usuario o contraseña no válido/s",Toast.LENGTH_LONG).show();
        }
    }
}