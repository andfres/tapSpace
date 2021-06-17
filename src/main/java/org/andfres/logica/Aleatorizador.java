package org.andfres.logica;


public class Aleatorizador {

    private static final String CONSONANTES = "bcdfghjklmpkrstvwyxyz";
    private static final String VOCALES = "aeiou" ;
    private static final String [] SILABAS = {"ch", "tg" , "ks" ,  "th" , "gl" , "nk", "gn"  };


    public static int int_aleatorio(int min , int max){

        return (int)(Math. random()*(max-min)+min);
    }
    public static int int_aleatorio(){
        return (int)(Math. random()*(100));
    }
    public static int int_aleatorio(String string){
        return (int)(Math. random()*(string.length()));
    }

    public static String generar_nombre_aleatorio (){
        StringBuilder nombre = new StringBuilder();
        char letra;
        int longitud_nombre = int_aleatorio(4,7);

        for (int i = 0; i < longitud_nombre; i++) {

            //Si es par -> consonante
            if (i%2==0){

                //Probabilidad de que sea una silaba extraña, doble o con tilde
                if (int_aleatorio() > 15){
                    letra = CONSONANTES.charAt(int_aleatorio(CONSONANTES));
                    nombre.append(letra);
                }else {
                    nombre.append(SILABAS[int_aleatorio(0, SILABAS.length)]);
                }

            }else {
                letra = VOCALES.charAt(int_aleatorio(VOCALES));
                nombre.append(letra);
            }
        }

        //Porcentaje puede acabar en número
        if (int_aleatorio() < 10 ){
            nombre.append("-").append(int_aleatorio());
        }

        //Primera letra en mayúsculas
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
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
}//fin funcionalidades

