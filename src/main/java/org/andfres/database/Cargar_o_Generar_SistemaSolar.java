package org.andfres.database;

import org.andfres.App;
import org.andfres.logica.SistemaSolar;

public class Cargar_o_Generar_SistemaSolar {


    public static SistemaSolar cargarPrimerPlaneta() {
        //Coordenadas iniciales habra que cargarlas en un futuro
        int x = -20;
        int y = 100;

        BaseDatos ssdb = App.ssdb;

        SistemaSolar ss = ssdb.load(x, y);

        if (ss == null) {
            System.out.println("No hay SS en  (" + x + "," + y + "), creando uno");

            ss = new SistemaSolar(x, y, "Alpha Centauri");
            ssdb.save(ss);

        } else {
            System.out.println("Cargando SS: " + ss.toString());

        }

        return ss;
    }




}