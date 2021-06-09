package org.andfres;

import org.andfres.interfazGrafica.Ventana;
import org.andfres.logica.CuerposCelestesGenerador;
import org.andfres.logica.BaseDatos;

public class App {


    public static void main(String[] args) {

        CuerposCelestesGenerador.crear_SS();
        Ventana ventana = new Ventana();


        BaseDatos ssdb = new BaseDatos();

        ssdb.borrarTablas();
        ssdb.crearTablas();



    }
}
