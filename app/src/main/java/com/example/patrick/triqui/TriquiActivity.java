package com.example.patrick.triqui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class TriquiActivity extends AppCompatActivity {

    private int contador = 0;
    private Triqui triqui;
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button boton4;
    private Button boton5;
    private Button boton6;
    private Button boton7;
    private Button boton8;
    private Button boton9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triqui);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        boton1 = (Button) findViewById(R.id.boton_1);
        boton2 = (Button) findViewById(R.id.boton_2);
        boton3 = (Button) findViewById(R.id.boton_3);
        boton4 = (Button) findViewById(R.id.boton_4);
        boton5 = (Button) findViewById(R.id.boton_5);
        boton6 = (Button) findViewById(R.id.boton_6);
        boton7 = (Button) findViewById(R.id.boton_7);
        boton8 = (Button) findViewById(R.id.boton_8);
        boton9 = (Button) findViewById(R.id.boton_9);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarJuego();
            }
        });


        triqui = new Triqui();
    }

    private void reiniciarJuego() {
        boton1.setText("");
        boton2.setText("");
        boton3.setText("");
        boton4.setText("");
        boton5.setText("");
        boton6.setText("");
        boton7.setText("");
        boton8.setText("");
        boton9.setText("");
        triqui = new Triqui();
    }


    public void laviejaListener(View view) {
        Button botonPresionado = (Button) view;

        if (triqui.esActivo() == true) {
            jugar(botonPresionado);
        }
    }

    private void jugar(Button botonPresionado) {
        if (botonPresionado.getText().toString().equals("")) {
            contador++;
            String resultado;

            int i = -1;
            int j = -1;
            int marca;

            switch (botonPresionado.getId()) {
                case R.id.boton_1:
                    i = 0;
                    j = 0;
                    break;
                case R.id.boton_2:
                    i = 0;
                    j = 1;
                    break;
                case R.id.boton_3:
                    i = 0;
                    j = 2;
                    break;
                case R.id.boton_4:
                    i = 1;
                    j = 0;
                    break;
                case R.id.boton_5:
                    i = 1;
                    j = 1;
                    break;
                case R.id.boton_6:
                    i = 1;
                    j = 2;
                    break;
                case R.id.boton_7:
                    i = 2;
                    j = 0;
                    break;
                case R.id.boton_8:
                    i = 2;
                    j = 1;
                    break;
                case R.id.boton_9:
                    i = 2;
                    j = 2;
                    break;
            }


            if (contador % 2 == 0) {
                resultado = "turno x";
                botonPresionado.setText("O");
                marca = 1;

            } else {
                resultado = "turno O";
                botonPresionado.setText("X");
                marca = 2;
            }
            triqui.marcar(marca, i, j);

            if (triqui.hayganador() != 0) {
                Snackbar.make(botonPresionado, "Hay ganador!", Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(botonPresionado, resultado, Snackbar.LENGTH_SHORT).show();
            }

        }
    }
}
