package com.ruben.pruebatresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

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




}
