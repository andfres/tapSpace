package org.andfres.logica;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

public class CuerposCelestesGenerador {

    public static final int NUMxLado = 10;
    public static final int NUMCUERPOS = NUMxLado * NUMxLado;

    private static int[] posiblidades_planetas = {70,30, 20,20 }; //1 roca , 2 fuego , 3 agua, 4 bosque
    private final static int[] posiblidades_CuerposCelestes = {40, 20, 20}; //normal, basura, vacío

    //public static CuerpoCeleste [] cuerpoCelestes = new CuerpoCeleste [NUMCUERPOS];

    //static ArrayList<Coordenada> coordenadas = new ArrayList<Coordenada>();


    static ArrayList<Coordenada> coordenadas = new CoordenadasGenerador().crearCoordenadas();


//    static void crearCoordenadas(){
//        for (int x = 1; x < NUMxLado + 1; x++) {
//
//            for (int y = 1; y < NUMxLado + 1; y++) {
//                System.out.print(x + "/" + y + " " );
//                coordenadas.add( new Coordenada(x, y) );
//
//            }
//            System.out.println("");
//        }
//        System.out.println("Corrdendas generadas");
//    }


    private static CuerpoCeleste generar_CuerpoCeleste (Coordenada cordenada){
        int num = Aleatorizador.aletorizar(posiblidades_CuerposCelestes);
        CuerpoCeleste cuerpo = new Vacio(cordenada);
        CuerpoCeleste nuevoCuerpo;
        switch (num){
            case 0: //Planeta
                nuevoCuerpo = new Planeta(cordenada,
                        Aleatorizador.generar_nombre_aleatorio(),
                        Aleatorizador.aletorizar(posiblidades_planetas));

                return nuevoCuerpo;

            case 1: //Asteroide
                nuevoCuerpo = new Asteroide(cordenada);
                return nuevoCuerpo;

            case 2: //Vacío
                nuevoCuerpo = new Vacio(cordenada);
                return nuevoCuerpo;

        }

        return cuerpo;
    }




    public static CuerpoCeleste [] crear_SS( ){


        System.out.println(coordenadas.toString());

        CuerpoCeleste [] cuerpoCelestes = new CuerpoCeleste [NUMCUERPOS];

        for (int x = 0; x < NUMCUERPOS; x++) {
            //System.out.println("creado cuerpo celeleste num " + x);
            CuerpoCeleste nuevoCuerpo = generar_CuerpoCeleste(coordenadas.get(x));
            cuerpoCelestes[x] = nuevoCuerpo;
        }

        System.out.println("Cuerpos celestes instanciados");
        return cuerpoCelestes;

    }; // fin crear universo
    
}
