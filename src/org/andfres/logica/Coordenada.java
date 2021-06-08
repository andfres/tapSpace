package org.andfres.logica;

public class Coordenada {

    protected int coorX;
    protected int coorY;


    public Coordenada(int coorX, int coorY) {
        this.coorX = coorX;
        this.coorY = coorY;
    }

    public String toString() {
        return coorX +"/"+ coorY + " ";
    }
}
