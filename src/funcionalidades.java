public class funcionalidades {

    static final String letras = "bcdfghjklmpkrstvwyxyz";
    static final String vocales = "aeiou" ;
    static final String [] silabas = {"ch", "tg" , "ks" ,  "th" , "gl" , "nk", "gn"  };

    static String [] nombres = new String[100];

    public static int int_aleatorio(int min , int max){
        return (int)(Math. random()*(max-min)+min);
    }

    public static int int_aleatorio(){
        return (int)(Math. random()*(100));
    }

    public static int int_aleatorio(String string){
        return (int)(Math. random()*(string.length()));
    }

    public static float float_aleatorio(){
        return  (float) Math.random();
    }

    public static String generar_nombre_aleatorio (){
        String nombre = "";
        char letra;
        int longitud_nombre = int_aleatorio(4,7);

        for (int i = 0; i < longitud_nombre; i++) {

            //Si es par -> consonante
            if (i%2==0){

                //Probabilidad de que sea una silaba extraña, doble o con tilde
                if (int_aleatorio() > 15){
                    letra = letras.charAt(int_aleatorio(letras));
                    nombre += letra;
                }else {
                    nombre += silabas[int_aleatorio(0, silabas.length)];
                }

            }else {
                letra = vocales.charAt(int_aleatorio(vocales));
                nombre += letra;
            }
        }

        //Porcentaje puede acabar en número
        if (int_aleatorio() < 10 ){
            nombre += "-" + int_aleatorio() ;
        }

        //Primera letra en mayúsculas
        String cap = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
        return cap;
    }




    //Elige un indice de un array aleatorio en función de los porcentajes pasados por parámetro
    public static int aletorizar (int[] porcentajes){
        int total = 0;

        for (int porcentaje: porcentajes) {
            total += porcentaje;
        }

        int aleatorio = int_aleatorio(0, total);

        for (int i = 0 ; i < porcentajes.length ; i++) {
            if (aleatorio <= porcentajes[i]){
                //System.out.println(porcentajes[i]);
                return i;
            }
            else
            {
                aleatorio -= porcentajes[i];
            }

        }
        return -1;
    }//fin aletorizar

    //public static int generar_tamano_planeta (){};


    //********************************************************************

    private static int[] posiblidades_planetas = {55,30,30}; //normal , congelado, calentito
    private final static int[] posiblidades_CuerposCelestes = {40, 20, 20}; //normal, basura, vacío
    public static CuerpoCeleste [][] galaxia = new CuerpoCeleste [20][20];


    private static CuerpoCeleste generar_CuerpoCeleste (int x, int y){
        int num = aletorizar(posiblidades_CuerposCelestes);
        CuerpoCeleste cuerpo = new Vacio(x, y);
        CuerpoCeleste nuevoCuerpo;
        switch (num){
            case 0: //Planeta
                nuevoCuerpo = new Planeta(x, y, generar_nombre_aleatorio() , aletorizar(posiblidades_planetas));
                return nuevoCuerpo;

            case 1: //Asteroide
                nuevoCuerpo = new Asteroide(x, y);
                return nuevoCuerpo;

            case 2: //Vacío
                nuevoCuerpo = new Vacio(x, y);
                return nuevoCuerpo;

        }
        // esto nunca se debería retornar, intentar mejorarlo
        return cuerpo;
    }



     public static void crear_universo(){

        for (int x = 0; x < galaxia.length; x++) {
            //System.out.println("");

            for (int y = 0; y < galaxia[x].length; y++) {
                //System.out.print(x + "/" + y + " ");

                CuerpoCeleste nuevoCuerpo = generar_CuerpoCeleste(x,y);
                galaxia[x][y] = nuevoCuerpo;

                }
            }
        System.out.println("Cuerpos celestes instanciados");
        inspeccionar_universo();

    }; // fin crear universo

    public static void inspeccionar_universo(){

        for (int x = 1; x < galaxia.length; x++) {


            for (int y = 1; y < galaxia[x].length; y++) {
                System.out.print(x + "/" + y + " ");
                System.out.println(galaxia[x][y].toString());
            }
        }


    }//fin inspeccionar



}//fin funcionalidades

