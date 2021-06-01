
package org.andfres.models;


public class SolarSystem {
  

    Integer id;
    int x;
    int y;
    String name;


    public SolarSystem(int id, int x, int y, String name){

        this.id = id;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public SolarSystem(int x, int y, String name){
        
        this.id = null;
        this.x = x;
        this.y = y;
        this.name = name;
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

    public String getName(){
        return this.name;
    }


    public void setName(String name){
        this.name = name;
    }




    public String xxx(){

        return "SS[" + this.x + "," + this.y + "] " + this.name;

    }




}
