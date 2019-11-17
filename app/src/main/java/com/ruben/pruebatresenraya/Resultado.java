package com.ruben.pruebatresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Resultado extends AppCompatActivity {

    private TextView tv_resultado;
    private ArrayList<String> lista = new ArrayList<String>();
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_vista);

        tv_resultado = findViewById(R.id.tv_resultado);



    }
}
