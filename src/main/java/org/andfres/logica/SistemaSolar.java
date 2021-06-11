package org.andfres.logica;

import org.andfres.App;
import org.andfres.database.BaseDatos;

public class SistemaSolar  {

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
        this.cuerpoCelestes = CuerposCelestesGenerador.crear_SS(this);
        this.name = name;

        System.out.println("Nuevo sistema solar generado");
    }

    public SistemaSolar(Integer Id, int X , int Y, String name){
        this.x = X;
        this.y = Y;
        //aqui cargar cuerpos celestes
        this.cuerpoCelestes  = new CuerpoCeleste[0] ;
        this.name = name;
        this.Id = Id;

        System.out.printf("creado objeto de SS");
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



    public static SistemaSolar cargarSS(int x , int y) {


        BaseDatos ssdb = App.ssdb;
        //Cargo sistema solar
        SistemaSolar ss = ssdb.load(x, y);
        //Si no hay lo creo
        if (ss == null) {

            System.out.println("No hay SS en  (" + x + "," + y + "), creando uno");
            ss = new SistemaSolar(x, y, "Alpha Centauri");
            ssdb.save(ss);

        } else {
            System.out.println("Cargando SS: " + ss.toString());

        }

        return ss;
    }





}
