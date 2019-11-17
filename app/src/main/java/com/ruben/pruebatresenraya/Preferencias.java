package com.ruben.pruebatresenraya;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;



public class Preferencias extends PreferenceActivity  {

    private ListPreference listaGuardar;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);


    }


}
