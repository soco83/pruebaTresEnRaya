package com.ruben.pruebatresenraya;

public class Jugador {

    private String nombre;
    private TipoJugador tipo;

    public  Jugador(String nombre, TipoJugador tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoJugador getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(TipoJugador tipo) {
        this.tipo = tipo;
    }

}
