package org.andfres.logica;

public class CuerpoCeleste_Asteroide extends CuerpoCeleste{

    public CuerpoCeleste_Asteroide(int numeroCC, Coordenada coordenada) {
        super.numeroCC = numeroCC;
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