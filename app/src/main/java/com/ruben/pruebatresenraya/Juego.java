package com.ruben.pruebatresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Juego extends AppCompatActivity {

    private Jugador jugador1;
    private Jugador jugador2;
    private Boolean turno = true;
    private Button boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, botonReJugar;
    private TextView tv_ganador, tv_nombre;
    private int contador = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_vista);
        boton1 = findViewById(R.id.bJuego1);
        boton2 = findViewById(R.id.bJuego2);
        boton3 = findViewById(R.id.bJuego3);
        boton4 = findViewById(R.id.bJuego4);
        boton5 = findViewById(R.id.bJuego5);
        boton6 = findViewById(R.id.bJuego6);
        boton7 = findViewById(R.id.bJuego7);
        boton8 = findViewById(R.id.bJuego8);
        boton9 = findViewById(R.id.bJuego9);
        tv_ganador = findViewById(R.id.tv_ganador);
        tv_nombre = findViewById(R.id.tv_nombre);
        botonReJugar = findViewById(R.id.bRejugar);
        botonReJugar.setVisibility(View.INVISIBLE);
        crearJugadores();
        tv_nombre.setVisibility(View.INVISIBLE);
        tv_ganador.setVisibility(View.INVISIBLE);

    }

    public void SeleccionarBoton(View view) {
        try {

            contador += 1;
            Button boton = (Button) view;


            if (turno) {

                boton.setText(jugador1.getTipo().toString());
                boton.setClickable(false);
                boton.setTag(1);
                ganar(boton);
                turno = false;
            } else if (!turno) {
                boton.setText(jugador2.getTipo().toString());
                boton.setClickable(false);
                boton.setTag(2);
                ganar(boton);
                turno = true;
            }

        } catch (Exception ex) {
            Toast toast1 = Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG);
            toast1.show();
        }


    }


    private boolean comprobarVictoria() {
        boolean condicion = (boton1.getTag() == boton2.getTag() && boton2.getTag() == boton3.getTag()) || (boton4.getTag() == boton5.getTag() && boton5.getTag() == boton6.getTag()) || (boton7.getTag() == boton8.getTag() && boton8.getTag() == boton9.getTag()) || (boton1.getTag() == boton4.getTag() && boton4.getTag() == boton7.getTag()) || (boton2.getTag() == boton5.getTag() && boton8.getTag() == boton8.getTag()) || (boton3.getTag() == boton6.getTag() && boton6.getTag() == boton9.getTag()) || (boton1.getTag() == boton5.getTag() && boton5.getTag() == boton9.getTag()) || (boton3.getTag() == boton5.getTag() && boton5.getTag() == boton7.getTag());
        boolean salida = false;
        if (condicion) {
            salida = true;
        }
        return salida;
    }

    private boolean comprobarVictoria2() {
        boolean haGanado = false;

        if (boton1.getTag() == boton2.getTag() && boton2.getTag() == boton3.getTag()) { //fila1
            haGanado = true;
        } else if (boton4.getTag() == boton5.getTag() && boton5.getTag() == boton6.getTag()) { //fila2
            haGanado = true;
        } else if (boton7.getTag() == boton8.getTag() && boton8.getTag() == boton9.getTag()) { //fila3
            haGanado = true;
        } else if (boton1.getTag() == boton4.getTag() && boton4.getTag() == boton7.getTag()) { //columna1
            haGanado = true;
        } else if (boton2.getTag() == boton5.getTag() && boton5.getTag() == boton8.getTag()) { //columna2
            haGanado = true;
        } else if (boton3.getTag() == boton6.getTag() && boton6.getTag() == boton9.getTag()) { //columna3
            haGanado = true;
        } else if (boton1.getTag() == boton5.getTag() && boton5.getTag() == boton9.getTag()) { //diagonal1
            haGanado = true;
        } else if (boton3.getTag() == boton5.getTag() && boton5.getTag() == boton7.getTag()) { //diagonal2
            haGanado = true;
        }

        return haGanado;
    }


    private void crearJugadores() {
        Intent intent = getIntent();
        Boolean tipo = intent.getBooleanExtra("tipoJugador", true);
        String nombre1 = intent.getStringExtra("jugador1");
        String nombre2 = intent.getStringExtra("jugador2");

        if (tipo) {
            jugador1 = new Jugador(nombre1, TipoJugador.O);
            jugador2 = new Jugador(nombre2, TipoJugador.X);
        } else {
            jugador1 = new Jugador(nombre1, TipoJugador.X);
            jugador2 = new Jugador(nombre2, TipoJugador.O);
        }
    }

    private void ganar(Button boton) {
        String ganador;

        if (comprobarVictoria() && turno) { //victoria jugador1
            ganador = "Victoria: " + jugador1.getNombre() + " || Derrota: " + jugador2.getNombre();
            finalPartida(ganador, jugador1.getNombre().toString(), comprobarVictoria());
        } else if (comprobarVictoria() && !turno) { //victoria jugador2
            ganador = "Victoria: " + jugador2.getNombre() + " || Derrota: " + jugador1.getNombre();
            finalPartida(ganador, jugador2.getNombre().toString(), comprobarVictoria());
        } else if (contador == 9 && !comprobarVictoria()) { //empate
            ganador = jugador1.getNombre() + " | EMPATE | " + jugador2.getNombre();
            String nombre = "EMPATE";
            finalPartida(ganador, nombre, comprobarVictoria());
        }

    }

    public void rejugar(View view){

    }

    private void finalPartida(String ganador, String nombre, boolean haGanado) {
        try {

            if (haGanado == true) {
                tv_nombre.setText(nombre);
                tv_nombre.setVisibility(View.VISIBLE);
                tv_ganador.setVisibility(View.VISIBLE);
                botonReJugar.setVisibility(View.VISIBLE);
                boton1.setClickable(false);
                boton2.setClickable(false);
                boton3.setClickable(false);
                boton4.setClickable(false);
                boton5.setClickable(false);
                boton6.setClickable(false);
                boton7.setClickable(false);
                boton8.setClickable(false);
                boton9.setClickable(false);


            } else {
                tv_ganador.setText(nombre);
                tv_ganador.setVisibility(View.VISIBLE);
                botonReJugar.setVisibility(View.VISIBLE);
                boton1.setClickable(false);
                boton2.setClickable(false);
                boton3.setClickable(false);
                boton4.setClickable(false);
                boton5.setClickable(false);
                boton6.setClickable(false);
                boton7.setClickable(false);
                boton8.setClickable(false);
                boton9.setClickable(false);


            }
        } catch (Exception ex) {
            Toast toast = Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }


    }
}
