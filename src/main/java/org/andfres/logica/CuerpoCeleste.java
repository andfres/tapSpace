package org.andfres.logica;

public class CuerpoCeleste {
    //Parámetros
    int numeroCC;
    Coordenada coordenada;
    public String nombre_imagen;
    public String mostrarCoordenada() {
        return coordenada.toString();
    }
    public String mostrarCoordenada2() {
        return "<h2>Coordenada: " + coordenada.toString() + " (N: " + numeroCC + ")</h2>";
    }
    //Método para mostrar info detallada

    public String toString_detallado(){
        return "método sobreescrito";
    }



}

