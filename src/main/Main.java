package main;

import logica.Universo;
import intefazGrafica.Ventana;

public class Main {


    public static void main(String[] args) {

        Universo.crear_galaxia();
        Ventana ventana = new Ventana();

    }
}
