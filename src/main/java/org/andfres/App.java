package org.andfres;

import org.andfres.interfazGrafica.VMenu;
import org.andfres.interfazGrafica.Ventana;
import org.andfres.logica.CuerposCelestesGenerador;
import org.andfres.database.BaseDatos;
import org.andfres.logica.SistemaSolar;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class App {

    public static BaseDatos ssdb;
    public static Ventana ventana;

    public static void main(String[] args) {

        ssdb = new BaseDatos();
        //Ventana ventana = new Ventana();
        ventana = new Ventana();

    }
}
