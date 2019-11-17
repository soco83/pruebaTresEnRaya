package com.ruben.pruebatresenraya;


import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class Ficheros {

    private boolean hayAlmacenamientoExt = false;
    private boolean almacenamientoExtEscritura = false;
    private String resultado;
    private String dirAlmacExt;
    private boolean respuesta;
    private ArrayList<String> partidas = new ArrayList<>();
    private File fichero;
    private FileOutputStream fos;



    public boolean compruebaAlmacenamientoExt(){

        // Obtenemos el estado del almacenamiento externo del tel�fono
        String estado = Environment.getExternalStorageState();

        // La tarjeta está activa y se puede escribir en ella
        if (Environment.MEDIA_MOUNTED.equals(estado)) {
            hayAlmacenamientoExt  = true;
            almacenamientoExtEscritura = true;
            respuesta = true;
        } else
            // S�lo se puede leer el almacenamiento externo
            if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(estado)) {
                hayAlmacenamientoExt = true;
                almacenamientoExtEscritura = false;
                respuesta = false;
            } else {
                // No se puede leer el almacenamiento externo
                hayAlmacenamientoExt = false;
                almacenamientoExtEscritura = false;
                respuesta = false;

            }
        if (hayAlmacenamientoExt) {
            // Mostramos el directorio donde est� el almacenamiento externo
            File dir = android.os.Environment.getExternalStorageDirectory();
            dirAlmacExt=dir.getAbsolutePath();


        }

        return respuesta;

    } //END compruebaAlmacenamientoExt



    public ArrayList<String> leerAlamacenamientoExterno() {

        partidas.clear();

        try {

            fichero = new File(dirAlmacExt + "/resultadosTresEnRaya", "ficheroExterno.txt");
            BufferedReader filein = new BufferedReader(new InputStreamReader(new FileInputStream(fichero)));
            String registro = filein.readLine();

            while (registro != null){

                partidas.add(registro);
                registro = filein.readLine();

            }

            filein.close();

        } catch (Exception ex) {

            Log.e("Ficheros", "Error al leer fichero de memoria externa");

        }

        return partidas;

    } //END leerAlamacenamientoExterno



    public void escribirAlmacenamientoExterno(String registro) {

        boolean hayFicheroExterno = compruebaAlmacenamientoExt();

        //Comprobar que hay memoria externa y que se puede escribir.
        if (hayFicheroExterno) {

                try {

                File directorio = new File (dirAlmacExt + "/resultadosTresEnRaya");
                directorio.mkdirs();
                File fichero = new File(directorio, "ficheroExterno.txt");
                OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(fichero));
                fout.write(registro);
                fout.close();

            } catch (Exception ex) {

                Log.e("Ficheros", "Error al escribir fichero en memoria externa");

            }

        }

    } //END escribirAlmacenamientoExterno


    public ArrayList<String> leerMemoriaInterna(Context ctx) {

        partidas.clear();

        try
        {
            BufferedReader filein = new BufferedReader(new InputStreamReader(ctx.openFileInput("ficheroInterno.txt")));
            String registro = filein.readLine();

            while (registro != null){

                partidas.add(registro);
                registro = filein.readLine();

            }

            filein.close();

        } catch (Exception ex) {

            Log.e("Ficheros", "Error al leer fichero de memoria interna");
        }

        return partidas;

    } //END leerMemoriaInterna



    public void escribirMemoriaInterna(Context ctx, String partida) {

        try {

            OutputStreamWriter osw = new OutputStreamWriter(ctx.openFileOutput("ficheroInterno.txt", Context.MODE_APPEND));
            osw.write(partida);
            osw.close();

        } catch (Exception ex) {

            Log.e("Fichero", "Error al escribir fichero en memoria interna");

        }

    }// END escribirMemoriaInterna



} //END CLASS  Ficheros
