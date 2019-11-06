package com.ruben.pruebatresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private EditText etNombre1;
    private EditText etNombre2;
    private Button bJugar;
    private RadioButton rbO1;
    private RadioButton rbX1;
    private RadioButton rbO2;
    private RadioButton rbX2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_vista);
        etNombre1 = (EditText) findViewById(R.id.etNombre1);
        etNombre2 = (EditText) findViewById(R.id.etNombre2);
        bJugar = (Button) findViewById(R.id.bJugar);
        rbO1 = (RadioButton) findViewById(R.id.rbO1);
        rbX1 = (RadioButton) findViewById(R.id.rbX1);
        rbO2 = (RadioButton) findViewById(R.id.rbO2);
        rbX2 = (RadioButton) findViewById(R.id.rbX2);
    }

    /* metodos  para cambiar el radioButton si los dos jugadores elijen el mismo tipo. */
    public void verifChekedO(View view){
        if (rbO1.isChecked() == rbO2.isChecked() && (rbO1.isChecked()|| rbO2.isChecked())){
            rbX1.setChecked(true);
        }

    }

    public void verifChekedX(View view)
    {
        if (rbX1.isChecked() == rbX2.isChecked() && (rbX1.isChecked()|| rbX2.isChecked())){
            rbO1.setChecked(true);
        }
    }


    //metodo que inicia la actividad del juego.
    public void iniciar(View view) {
        if (etNombre1.getText().toString().isEmpty()&& etNombre2.getText().toString().isEmpty()) {
            Toast t = Toast.makeText(this, "Se tiene que colocar nombre a los dos jugadores", Toast.LENGTH_LONG);
            t.show();

        }else{
            Intent intent = new Intent(this,Juego.class);
            String nombre1 = etNombre1.getText().toString();
            String nombre2 = etNombre2.getText().toString();

            intent.putExtra("jugador1",nombre1);
            intent.putExtra("jugador2",nombre2);
            startActivity(intent);

        }



    }
}
