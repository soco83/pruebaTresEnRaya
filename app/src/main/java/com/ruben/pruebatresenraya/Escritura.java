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


public class Escritura {

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



    public void leerAlamacenamientoExterno() {

        try
        {
            fichero = new File(dirAlmacExt + "/ejemplo_curso_Mentor", "prueba_sd.txt");
            BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(fichero)));

            // resultado.append("- Abrimos fichero '"+ dirAlmacExt + "/ejemplo_curso_Mentor/fichero_externo.txt' para lectura de memoria externa");
            String texto = fin.readLine();
            // resultado.append("\n\n- Leemos el contenido del fichero:\n");
            //resultado.append(texto);
            fin.close();
            //  resultado.append("\n\n- Cerramos fichero");
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero de memoria externa");
            //resultado.append("Error al leer fichero de memoria externa");
        }
    } //END leerAlamacenamientoExterno

    public void escribirAlmacenamientoExterno() {

        //Si la memoria externa est� disponible y se puede escribir
        if (hayAlmacenamientoExt && almacenamientoExtEscritura)
        {
            try
            {
                // Creamos un directorio de prueba
                File directorio = new File (dirAlmacExt + "/ejemplo_curso_Mentor");
                directorio.mkdirs();
                //resultado.append("- Creamos el directorio " + dirAlmacExt + "/ejemplo_curso_Mentor");
                // Abrimos in fichero en el ra�z de la tarjeta SD
                File fichero = new File(directorio, "prueba_sd.txt");
                OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(fichero));
                //resultado.append("\n\n- Abrimos fichero '" + dirAlmacExt + "/ejemplo_curso_Mentor/fichero_externo.txt' para escritura en memoria externa");
                fout.write("Caminante no hay camino se hace camino al andar...");
                //resultado.append("\n\n- Escribimos los datos");
                fout.close();
                //resultado.append("\n\n- Cerramos fichero");
            }
            catch (Exception ex)
            {
                Log.e("Ficheros", "Error al escribir fichero en memoria externa");
                //resultado.append("Error al escribir fichero en memoria externa");
            }
        }  //resultado.append("No hay almacenamiento externo disponible o no se puede escribir en �l.");

    } //END escribirAlmacenamientoExterno


    public ArrayList<String> leerMemoriaInterna() {

        partidas.clear();



        try
        {
            //BufferedReader filein = new BufferedReader(new InputStreamReader(openFileInput()));

            //String texto = filein.readLine();
            //resultado.append("- Abrimos archivo 'fichero_interno.txt'");
            //resultado.append("\n\n- Leemos el contenido del fichero:\n");
            //resultado.append(texto);
            //filein.close();
            //resultado.append("'\n\n- Cerramos el archivo");
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero de memoria interna");
            // resultado.append("Error al leer fichero en memoria interna");
        }

        return partidas;

    } //END leerMemoriaInterna



    public void escribirMemoriaInterna(Context ctx, String partida) {

        try
        {
            OutputStreamWriter osw = new OutputStreamWriter(ctx.openFileOutput("ficheroInterno.txt", Context.MODE_PRIVATE));
            osw.write(partida);
            osw.close();
            //resultado.append("- Abrimos fichero 'fichero_interno.txt' para escribir datos en memoria interna");

            //resultado.append("\n\n- Cerramos fichero");
        } catch (Exception ex) {
            Log.e("Fichero", "Error al escribir fichero en memoria interna");
            //resultado.append("Error al escribir fichero en memoria interna");
        }

    }// END escribirMemoriaInterna



} //END CLASS  Escritura
