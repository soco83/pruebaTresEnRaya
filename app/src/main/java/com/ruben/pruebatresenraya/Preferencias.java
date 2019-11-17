package com.ruben.pruebatresenraya;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;



public class Preferencias extends PreferenceActivity  {

    private ListPreference listaGuardar;
    private ListPreference listaIdioma;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);


    }
}
