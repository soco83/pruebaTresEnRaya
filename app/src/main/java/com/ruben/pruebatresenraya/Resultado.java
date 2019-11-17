package com.ruben.pruebatresenraya;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Resultado extends AppCompatActivity {

    private TextView tv_resultado;
    private ArrayList<String> lista = new ArrayList<String>();
    private String[] listaPreparada;
    private ListView lv;
    private Ficheros leer = new Ficheros();
    public static Boolean modoLectura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_vista);

        tv_resultado = findViewById(R.id.tv_resultado);
        rellenarLista();

        ListAdapter adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);

        lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(adaptador);


    }

    private void rellenarLista(){
        if (modoLectura){
            lista = leer.leerMemoriaInterna(this);

        }else{
            if (leer.compruebaAlmacenamientoExt()){
                lista = leer.leerAlamacenamientoExterno();
            }

        }
    }
}
