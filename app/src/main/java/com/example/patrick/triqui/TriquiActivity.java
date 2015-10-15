package com.example.patrick.triqui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class TriquiActivity extends AppCompatActivity {

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triqui);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    public void laviejaListener(View view) {
        Button botonPresionado = (Button) view;

        if (botonPresionado.getText().toString().equals("")) {
            contador++;
            String resultado;
            if (contador % 2 == 0) {
                resultado = "turno x";
                botonPresionado.setText("O");


            } else {
                resultado = "turno O";
                botonPresionado.setText("X");
            }

            Snackbar.make(view, resultado, Snackbar.LENGTH_SHORT).show();
        }

    }
}
