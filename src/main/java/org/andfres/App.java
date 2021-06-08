package org.andfres;

import org.andfres.interfazGrafica.Ventana;
import org.andfres.logica.Universo;
import org.andfres.logica.BaseDatos;

public class App {


    public static void main(String[] args) {

        Universo.crear_galaxia();
        Ventana ventana = new Ventana();


        BaseDatos ssdb = new BaseDatos();

        ssdb.borrarTablas();
        ssdb.crearTablas();



    }
}
