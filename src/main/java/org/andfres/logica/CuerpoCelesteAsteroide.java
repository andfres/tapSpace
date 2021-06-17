package org.andfres.logica;

public class CuerpoCelesteAsteroide extends CuerpoCeleste{

    public CuerpoCelesteAsteroide(SistemaSolar sistemaSolar, Coordenada coordenada) {
        super(sistemaSolar,coordenada);


        this.nombre_imagen = "asteroide.jpg";
    }
    public String toString() {
        return mostrarCoordenada() +"Asteroide";
    }


    public String toString_detallado() {
        return String.format("""
            <html>
                %s
                <p style="font-size: 16"> Un simple asteroide. </p>
            </html>
            """,mostrarCoordenada2() );
    }


} //fin Asteroide