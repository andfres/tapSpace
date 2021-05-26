public class CuerpoCeleste {
    protected int coorX;
    protected int coorY;
    //Imagen imagen

    public String toString() {
        return coorX +"/"+ coorY;
    }

}

class Planeta extends CuerpoCeleste{
    //private int[] coordenadas;
    private String nombre;
    private int tipo_planeta;


    public Planeta(int coorX, int coorY, String nombre, int tipo_planeta) {
        //this.coordenadas = coordenadas;
        super.coorX = coorX;
        super.coorY = coorY;
        this.nombre = nombre;
        this.tipo_planeta = tipo_planeta;
        //this.temperatura = temperatura;

    }

    @Override
    public String toString() {
        return "Planeta{" +
                "name='" + nombre + '\'' +
                ", tipo='" + tipo_planeta + '\'' +
                '}';
    }

//          switch (num){
//        case 0: temp = "A"; break;
//        case 1: temp= "B"; break;
//        case 2: temp ="C"; break;






} //fin Planeta

class Asteroide extends CuerpoCeleste{

    public Asteroide(int coorX, int coorY) {
        super.coorX = coorX;
        super.coorY = coorY;
    }
    public String toString() {
        return "Asteroide";
    }

} //fin Asteroide


class Vacio extends CuerpoCeleste{

    public Vacio (int coorX, int coorY) {
        super.coorX = coorX;
        super.coorY = coorY;
    }
    public String toString() {
        return "Vacío";
    }

} //fin Asteroide
