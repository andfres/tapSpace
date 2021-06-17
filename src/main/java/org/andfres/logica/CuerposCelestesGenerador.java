package org.andfres.logica;

import java.util.ArrayList;

public class CuerposCelestesGenerador {

    public static final int NUMxLado = 10;
    public static final int NUMCUERPOS = NUMxLado * NUMxLado;

    private static int[] posiblidades_planetas = {70,30, 20,20 }; //1 roca , 2 fuego , 3 agua, 4 bosque
    private final static int[] posiblidades_CuerposCelestes = {40, 20, 20}; //planeta, asteroide, vacío

    static ArrayList<Coordenada> coordenadas = new CoordenadasGenerador().crearCoordenadas();


    private static CuerpoCeleste generar_CuerpoCeleste (SistemaSolar sistemaSolar , Coordenada cordenada){
        int num = Aleatorizador.aletorizar(posiblidades_CuerposCelestes);


        CuerpoCeleste nuevoCuerpo;
        switch (num){
            case 0: //Planeta
                nuevoCuerpo = new CuerpoCelestePlaneta(
                        sistemaSolar,
                        cordenada,
                        Aleatorizador.generar_nombre_aleatorio(),
                        Aleatorizador.aletorizar(posiblidades_planetas),
                        null //ninguna imagen
                );

                return nuevoCuerpo;

            case 1: //Asteroide
                nuevoCuerpo = new CuerpoCelesteAsteroide(sistemaSolar,  cordenada);
                return nuevoCuerpo;

            case 2: //Vacío
                nuevoCuerpo = new CuerpoCelesteVacio(sistemaSolar,  cordenada);
                return nuevoCuerpo;

        }

        CuerpoCeleste cuerpo = new CuerpoCelesteVacio(sistemaSolar, cordenada);
        return cuerpo;
    }




    public static CuerpoCeleste [] crear_CCs(SistemaSolar sistemaSolar){

        //System.out.println(coordenadas.toString());

        CuerpoCeleste [] cuerpoCelestes = new CuerpoCeleste [NUMCUERPOS];

        for (int x = 0; x < NUMCUERPOS; x++) {
            //System.out.println("creado cuerpo celeleste num " + x);
            CuerpoCeleste nuevoCuerpo = generar_CuerpoCeleste(sistemaSolar ,   coordenadas.get(x));
            cuerpoCelestes[x] = nuevoCuerpo;
        }

        System.out.println("Cuerpos celestes instanciados");
        return cuerpoCelestes;

    }; // fin crear universo
    
}
