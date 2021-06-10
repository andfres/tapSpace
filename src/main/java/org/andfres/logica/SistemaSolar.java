package org.andfres.logica;

public class SistemaSolar {

    //Integer id;
    //static int xAnterior;
    //static int yAnterior;
    Integer Id = null;
    int x;
    int y;
    String name;

    public CuerpoCeleste [] cuerpoCelestes;

    public SistemaSolar(int X , int Y, String name){
        this.x = X;
        this.y = Y;
        this.cuerpoCelestes = CuerposCelestesGenerador.crear_SS();
        this.name = name;
    }

    public SistemaSolar(Integer Id, int X , int Y, String name){
        this.x = X;
        this.y = Y;
        //aqui cargar cuerpos celestes
        this.cuerpoCelestes = CuerposCelestesGenerador.crear_SS();
        this.name = name;
        this.Id = Id;
    }





    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Integer getId(){
        return this.Id;
    }

    public String getName(){
        return this.name;
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
