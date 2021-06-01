package logica;

public class CuerpoCeleste {
    Coordenada coordenada;
    public String nombre_imagen;
    public String mostrarCoordenada() {
        return coordenada.toString();
    }
}



class Planeta extends CuerpoCeleste{

    private String nombre;
    private int tipo_planeta;

//    private String [] tipo_planeta_string = {"planetas_roca" , "planetas_agua" , "planetas_bosque", "planetas_fuego"};
//
//    private String [] planetas_roca = {"planeta_3.jpg" , "planeta_4.jpg", "planeta_9.jpg", "planeta_16.jpg" };
//    private String [] planetas_agua = {"planeta_2.jpg" , "planeta_7.jpg", "planeta_8.jpg", "planeta_14.jpg" };
//    private String [] planetas_bosque = {"planeta_1.jpg" , "planeta_5.jpg", "planeta_12.jpg", "planeta_13.jpg" };
//    private String [] planetas_fuego = {"planeta_10.jpg" , "planeta_11.jpg" };


    private String [] [] tipo_planeta_string = {

         {"planeta_03.jpg" , "planeta_04.jpg", "planeta_16.jpg", "planeta_16.jpg" },
         {"planeta_02.jpg" , "planeta_07.jpg", "planeta_08.jpg", "planeta_14.jpg" },
         {"planeta_01.jpg" , "planeta_05.jpg", "planeta_12.jpg", "planeta_13.jpg" },
         {"planeta_10.jpg" , "planeta_11.jpg" }};

    public Planeta(Coordenada coordenada, String nombre, int tipo_planeta) {

        super.coordenada = coordenada;
        this.nombre = nombre;
        this.tipo_planeta = tipo_planeta;
        super.nombre_imagen = tipo_planeta_string[tipo_planeta][0];
    }

    // crear un metodo para aleatorizar imagen
    public int elegirFoto(int tipo_planeta){

        int size = tipo_planeta_string[tipo_planeta].length;

        return 0;
    }

        @Override
    public String toString() {
        return mostrarCoordenada() +
                "Planeta{" +
                "name='" + nombre + '\'' +
                ", tipo='" + tipo_planeta + '\'' +
                '}';
    }





} //fin Planeta



class Asteroide extends CuerpoCeleste{

    public Asteroide(Coordenada coordenada) {
        super.coordenada = coordenada;
        super.nombre_imagen = "asteroide.jpg";
    }
    public String toString() {
        return mostrarCoordenada() +"Asteroide";
    }

} //fin Asteroide


class Vacio extends CuerpoCeleste{

    public Vacio (Coordenada coordenada) {
        super.coordenada = coordenada;
        super.nombre_imagen = "void.jpg";
    }
    public String toString() {
        return mostrarCoordenada() + "Vacío";
    }

} //fin Asteroide
