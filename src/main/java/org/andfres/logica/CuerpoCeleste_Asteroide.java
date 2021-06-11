package org.andfres.logica;

public class CuerpoCeleste_Asteroide extends CuerpoCeleste{

    public CuerpoCeleste_Asteroide(SistemaSolar sistemaSolar, int numeroCC, Coordenada coordenada) {
        super(sistemaSolar,coordenada);

        this.numeroCC = numeroCC;
        this.nombre_imagen = "asteroide.jpg";
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