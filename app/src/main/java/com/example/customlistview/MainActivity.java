package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] idImagen = {
                R.drawable.img,
                R.drawable.img_1,
                R.drawable.img_2,
                R.drawable.img_3,
                R.drawable.img_4,
                R.drawable.img_5,
        };

        String[] nombre = {
                "Juan Camilo",
                "Jean Paul",
                "Craig",
                "Mike",
                "Ivana",
                "Michelle Molina"
        };

        String[] ultimoMensaje ={
                "Hey", "What´s Up","Nos vemos hoy?","Qué haces?","Wie heist du?","Gotta go"
        };

        String[] horaUltimoMensaje ={
                "10:30", "20:50","00:01","03:44","10:45","13:56"
        };
        String[] numeroTelefono ={
                "2222", "33344","89764","8765243","908765","12989"
        };

        String[] pais ={
                "Colombia", "USA","Colombia","Perú","Alemania","Suiza"
        };

        String[] mensajes ={
                "Hola Juan Camilo como estas?, espero que bien, saludos!",
                "Hey Jean Pail Suludos",
                "Hey Craig Que tal?",
                "Hola Mike, saludos!",
                "Hola Ivana, Sludos!",
                "Michelle Te extraño mucho."
        };



        ListAdapter listAdapter = new ListAdapter(MainActivity.this, nombre,ultimoMensaje,horaUltimoMensaje,numeroTelefono,pais,idImagen);
        lista = (ListView) findViewById(R.id.listaView);
        lista.setAdapter(listAdapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {

                Intent intent = new Intent(MainActivity.this, ViewProfile.class);
                intent.putExtra("nombres", nombre[posicion]);
                intent.putExtra("imagen", idImagen[posicion]);
                intent.putExtra("mensaje", mensajes[posicion]);
                startActivity(intent);

            }
        });

    }

    public void NewWindow(View view){
        Intent intent = new Intent(this, ViewProfile.class);
        intent.putExtra("lista", (Serializable) lista);
        startActivity(intent);
    }
}