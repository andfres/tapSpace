package org.andfres.logica;

public class SistemaSolar {

    //Integer id;
    static int xAnterior;
    static int yAnterior;

    int x;
    int y;

    public CuerpoCeleste [] cuerpoCelestes;

    public SistemaSolar(int cambioCordenadaX , int cambioCordenadaY){
        this.x = xAnterior+cambioCordenadaX;
        this.y = yAnterior+cambioCordenadaY;
        this.cuerpoCelestes = CuerposCelestesGenerador.crear_SS();
    }






    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }



    public String toString(){
        return "  SS [" + this.x + " , " + this.y + "] ";

    }



    public void inspeccionar_galaxia(){

        for (int x = 1; x < cuerpoCelestes.length; x++) {
            System.out.println(cuerpoCelestes[x].toString());

        }

    }//fin inspeccionar
}
