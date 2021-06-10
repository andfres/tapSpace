package org.andfres;

import org.andfres.interfazGrafica.Ventana;
import org.andfres.logica.CuerposCelestesGenerador;
import org.andfres.database.BaseDatos;
import org.andfres.logica.SistemaSolar;

public class App {

    public static BaseDatos ssdb;

    public static void main(String[] args) {

        ssdb = new BaseDatos();
        Ventana ventana = new Ventana();

        //ssdb.borrarTablas();
        //ssdb.crearTablas();

    }





}
