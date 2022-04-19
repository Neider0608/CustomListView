package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class ViewProfile extends AppCompatActivity {

    TextView etNombres, etMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_profile);
        etNombres = this.findViewById(R.id.nombrePersona);
        etNombres.setText(getIntent().getExtras().getString("nombres"));

        ImageView fotoPerfil = this.findViewById(R.id.imagenPerfil);
        fotoPerfil.setImageResource(getIntent().getExtras().getInt("imagen"));


        etMensaje = this.findViewById(R.id.mensajeSaludo);
        etMensaje.setText(getIntent().getExtras().getString("mensaje"));
    }


}