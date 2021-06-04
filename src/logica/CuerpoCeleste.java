package logica;

public class CuerpoCeleste {
    //Parámetros
    Coordenada coordenada;
    public String nombre_imagen;
    public String mostrarCoordenada() {
        return coordenada.toString();
    }
    public String mostrarCoordenada2() {
        return "<h1>Coordenada: " + coordenada.toString() + "</h1>";
    }
    //Método para mostrar info detallada

    public String toString_detallado(){
        return "método sobreescrito";
    }

}

/*********************************************************************/
/*********************************************************************/

class Planeta extends CuerpoCeleste{

    //Parámetros
    private String nombre;
    private int tipo_planeta;
    private String [] []  array_nombres_fotos = {
         {"planeta_03.jpg" , "planeta_04.jpg", "planeta_16.jpg", "planeta_18.jpg" },
         {"planeta_02.jpg" , "planeta_07.jpg", "planeta_08.jpg", "planeta_14.jpg" },
         {"planeta_01.jpg" , "planeta_05.jpg", "planeta_12.jpg", "planeta_13.jpg" },
         {"planeta_10.jpg" , "planeta_11.jpg" }};

    private String [] tipo_planeta_string = {"Roca" , "Agua" , "bosque", "Fuego"};

    //Constructor
    public Planeta(Coordenada coordenada, String nombre, int tipo_planeta) {

        super.coordenada = coordenada;
        this.nombre = nombre;
        this.tipo_planeta = tipo_planeta;

        super.nombre_imagen = elegirFoto();

    }

    // Método para aleatorizar imagen
    public String elegirFoto(){

        int size = array_nombres_fotos[tipo_planeta].length;
        int num = Aleatorizador.int_aleatorio(0,size);
        System.out.println("tamaño array" +size);

        //System.out.println("eligiendo planteta:" + num);

        return array_nombres_fotos[tipo_planeta][num];
    }

    @Override
    public String toString() {
        return mostrarCoordenada() +
                "Planeta{" +
                "name='" + nombre + '\'' +
                ", tipo='" + tipo_planeta + '\'' +
                '}';
    }



    public String toString_detallado() {

        String s = String.format("""
            <html>
                %s
                <p>Planeta <span style="font-size: 20"> %s </span>  </p>
                <p>Bioma de tipo <span style="font-size: 20"> %s </span>  </p>
            </html>
            
            """,mostrarCoordenada2(), nombre,  tipo_planeta_string[tipo_planeta]  );

        return s;
    }



} //fin Planeta

/*********************************************************************/
/*********************************************************************/

class Asteroide extends CuerpoCeleste{

    public Asteroide(Coordenada coordenada) {
        super.coordenada = coordenada;
        super.nombre_imagen = "asteroide.jpg";
    }
    public String toString() {
        return mostrarCoordenada() +"Asteroide";
    }


    public String toString_detallado() {
        String s = String.format("""
            <html>
                %s
                <p style="font-size: 16"> Un simple asteroide. </p>
            </html>
            """,mostrarCoordenada2() );
        return s;
    }


} //fin Asteroide

/*********************************************************************/
/*********************************************************************/

class Vacio extends CuerpoCeleste{

    public Vacio (Coordenada coordenada) {
        super.coordenada = coordenada;
        super.nombre_imagen = "void.jpg";
    }
    public String toString() {
        return mostrarCoordenada() + "Vacío";
    }


    public String toString_detallado() {
        String s = String.format("""
            <html>
                %s
                <p style="font-size: 16"> Sólo el vacío.</p>
            </html>
            """,mostrarCoordenada2() );
        return s;
    }

} //fin Asteroide
