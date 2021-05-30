package logica;

public class CuerpoCeleste {
    Coordenada coordenada;
    //Imagen imagen

    public String mostrarCoordenada() {
        return coordenada.toString();
    }
}



class Planeta extends CuerpoCeleste{

    private String nombre;
    private int tipo_planeta;

    public Planeta(Coordenada coordenada, String nombre, int tipo_planeta) {

        super.coordenada = coordenada;
        this.nombre = nombre;
        this.tipo_planeta = tipo_planeta;
        //this.temperatura = temperatura;
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
    }
    public String toString() {
        return mostrarCoordenada() +"Asteroide";
    }

} //fin Asteroide


class Vacio extends CuerpoCeleste{

    public Vacio (Coordenada coordenada) {
        super.coordenada = coordenada;
    }
    public String toString() {
        return mostrarCoordenada() + "Vacío";
    }

} //fin Asteroide
