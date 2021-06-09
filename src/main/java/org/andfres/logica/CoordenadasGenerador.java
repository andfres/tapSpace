package org.andfres.logica;

import java.util.ArrayList;

public class CoordenadasGenerador {


    ArrayList<Coordenada> coordenadas = new ArrayList<Coordenada>();



     ArrayList<Coordenada> crearCoordenadas(){
        for (int x = 1; x < CuerposCelestesGenerador.NUMxLado + 1; x++) {

            for (int y = 1; y < CuerposCelestesGenerador.NUMxLado + 1; y++) {
                System.out.print(x + "/" + y + " " );
                coordenadas.add( new Coordenada(x, y) );

            }
            System.out.println("");
        }
        System.out.println("Corrdendas generadas");
        return coordenadas;
    }




}
