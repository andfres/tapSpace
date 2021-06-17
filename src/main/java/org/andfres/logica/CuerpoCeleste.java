package org.andfres.logica;

import java.util.Comparator;

public class CuerpoCeleste {
    //Parámetros
    int numeroCC;
    Coordenada coordenada;
    String nombre_imagen;
    SistemaSolar sistemaSolar;


    CuerpoCeleste(SistemaSolar sistemaSolar, Coordenada coordenada){
        this.sistemaSolar = sistemaSolar;
        this.coordenada = coordenada;

    }


    public String mostrarCoordenada() {
        return coordenada.toString() +
               "SSid: " + sistemaSolar.getId() + " ";
    }
    public String mostrarCoordenada2() {

        return "<h2>Coordenada: " + coordenada.toString() + " (N: " + numeroCC + ")</h2>";
    }
    //Método para mostrar info detallada

    public String toString_detallado(){
        return "método sobreescrito";
    }



}

