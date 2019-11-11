package com.ruben.pruebatresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Juego extends AppCompatActivity {

    private Jugador jugador1;
    private Jugador jugador2;
    private Boolean selector = true;
    private Button boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,botonReJugar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_vista);
        boton1 = findViewById(R.id.bJuego1);
        boton2 = findViewById(R.id.bJuego2);
        boton3 = findViewById(R.id.bJuego3);
        crearJugadores();

    }

    public void SeleccionarBoton(View view){
        Button boton = (Button) view;
       if (selector){
           boton.setText(jugador1.getTipo().toString());
           selector = false;
       } else{
           boton.setText(jugador2.getTipo().toString());
           selector = true;
       }
    }


    private void comprobarVictoria(){

    }

     private void crearJugadores()
    {
        Intent intent = getIntent();
        Boolean tipo = intent.getBooleanExtra("tipoJugador",true);
        String nombre1 = intent.getStringExtra("nombre1");
        String nombre2 = intent.getStringExtra("nombre2");

        if (tipo) {
            jugador1 = new Jugador(nombre1, TipoJugador.O);
            jugador2 = new Jugador(nombre2, TipoJugador.X);
        }else{
            jugador1 = new Jugador(nombre1, TipoJugador.X);
            jugador2 = new Jugador(nombre2, TipoJugador.O);
        }
    }


}
