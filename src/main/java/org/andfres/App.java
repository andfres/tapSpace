package org.andfres;

import org.andfres.interfazGrafica.Ventana;
import org.andfres.logica.Universo;

public class App {


    public static void main(String[] args) {

        Universo.crear_galaxia();
        Ventana ventana = new Ventana();
        System.out.println("holaaa");

    }
}
