package logica;

public class SistemaSolar {

    Integer id;
    static int xAnterior;
    static int yAnterior;

    int x;
    int y;


    public SistemaSolar(int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public SistemaSolar(int x, int y){
        this.id = null;
        this.x = x;
        this.y = y;
    }


    public SistemaSolar generarSistemaSolar  (int cambioCordenadaX , int cambioCordenadaY){

        SistemaSolar nuevoSistemaSolar = new SistemaSolar (
                this.xAnterior+cambioCordenadaX ,
                this.yAnterior+cambioCordenadaY);

        return nuevoSistemaSolar;
    }


    public Integer getId(){
        return this.id;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }



    public String toString(){
        return "SS[" + this.x + "," + this.y + "] ";

    }
}
//
//class GenerarSistemaSolar{
//
//    int x;
//    int y;
//
//    GenerarSistemaSolar(int x, int y){
//        this.x = x;
//        this.y = y;
//
//    }
//
//    public
//
//}