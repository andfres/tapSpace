package logica;

import java.util.ArrayList;

public class Universo {

    static final int NUMxLado = 5;
    static final int NUMCUERPOS = NUMxLado * NUMxLado;

    private static int[] posiblidades_planetas = {55,30,30}; //normal , congelado, calentito
    private final static int[] posiblidades_CuerposCelestes = {40, 20, 20}; //normal, basura, vacío

    public static CuerpoCeleste [] galaxia = new CuerpoCeleste [NUMCUERPOS];

    static ArrayList<Coordenada> coordenadas = new ArrayList<Coordenada>();


    static void crearCoordenadas(){
        for (int x = 0; x <= NUMxLado; x++) {

            for (int y = 0; y <= NUMxLado; y++) {
                System.out.print(x + "/" + y + " " );
                coordenadas.add( new Coordenada(x, y) );

            }
        }
    }


    private static CuerpoCeleste generar_CuerpoCeleste (Coordenada cordenada){
        int num = Funcionalidades.aletorizar(posiblidades_CuerposCelestes);
        CuerpoCeleste cuerpo = new Vacio(cordenada);
        CuerpoCeleste nuevoCuerpo;
        switch (num){
            case 0: //Planeta
                nuevoCuerpo = new Planeta(cordenada, Funcionalidades.generar_nombre_aleatorio() , Funcionalidades.aletorizar(posiblidades_planetas));
                return nuevoCuerpo;

            case 1: //Asteroide
                nuevoCuerpo = new Asteroide(cordenada);
                return nuevoCuerpo;

            case 2: //Vacío
                nuevoCuerpo = new Vacio(cordenada);
                return nuevoCuerpo;
        }
        // esto nunca se debería retornar, intentar mejorarlo
        return cuerpo;
    }




    public static void crear_galaxia(){

        crearCoordenadas();
        System.out.println(coordenadas.toString());

        for (int x = 0; x < galaxia.length; x++) {
            System.out.println("creado cuerpo celeleste num " + x);
            CuerpoCeleste nuevoCuerpo = generar_CuerpoCeleste(coordenadas.get(x));
            galaxia[x] = nuevoCuerpo;
        }

        System.out.println("Cuerpos celestes instanciados");
        inspeccionar_galaxia();

    }; // fin crear universo



    public static void inspeccionar_galaxia(){

        for (int x = 1; x < galaxia.length; x++) {
            System.out.println(galaxia[x].toString());

        }

    }//fin inspeccionar
}
