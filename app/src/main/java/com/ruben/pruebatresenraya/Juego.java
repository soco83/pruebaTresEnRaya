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
        boton4 = findViewById(R.id.bJuego4);
        boton5 = findViewById(R.id.bJuego5);
        boton6 = findViewById(R.id.bJuego6);
        boton7 = findViewById(R.id.bJuego7);
        boton8 = findViewById(R.id.bJuego8);
        boton9 = findViewById(R.id.bJuego9);
        botonReJugar = findViewById(R.id.bRejugar);
        botonReJugar.setVisibility(View.INVISIBLE);
        crearJugadores();

    }

    public void SeleccionarBoton(View view){
        Button boton = (Button) view;
       if (selector){
           boton.setText(jugador1.getTipo().toString());
           boton.setClickable(false);
           selector = false;
       } else if (!selector && boton.getText() == ""){
           boton.setText(jugador2.getTipo().toString());
           boton.setClickable(false);
           selector = true;
       }
    }


    private boolean comprobarVictoria(Button boton){
         boolean condicion =  boton1.getTag() == boton2.getTag() && boton2.getTag() == boton3.getTag() || boton4.getTag() == boton5.getTag() && boton5.getTag() == boton6.getTag() || boton7.getTag() == boton8.getTag() && boton8.getTag() == boton9.getTag() || boton1.getTag() == boton4.getTag() && boton4.getTag() == boton7.getTag() || boton2.getTag() == boton5.getTag() && boton5.getTag() == boton8.getTag() || boton3.getTag() == boton6.getTag() && boton6.getTag() == boton9.getTag() || boton1.getTag() == boton5.getTag() && boton5.getTag() == boton9.getTag() || boton3.getTag() == boton5.getTag() && boton5.getTag() == boton7.getTag();
         boolean salida = false;
        if (condicion)
        {

        }

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
