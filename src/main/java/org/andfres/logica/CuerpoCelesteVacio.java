package org.andfres.logica;


public class CuerpoCelesteVacio extends CuerpoCeleste{

    public CuerpoCelesteVacio(SistemaSolar sistemaSolar,  Coordenada coordenada) {

        super(sistemaSolar,coordenada);

        this.nombre_imagen = "void.jpg";
    }
    public String toString() {
        return mostrarCoordenada() + "Vacío";
    }


    public String toString_detallado() {
        return String.format("""
            <html>
                %s
                <p style="font-size: 16"> Sólo el vacío.</p>
            </html>
            """,mostrarCoordenada2() );
    }

} //fin Asteroide
