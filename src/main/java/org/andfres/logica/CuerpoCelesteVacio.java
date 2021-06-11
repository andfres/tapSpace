package org.andfres.logica;


class CuerpoCelesteVacio extends CuerpoCeleste{

    public CuerpoCelesteVacio(SistemaSolar sistemaSolar, int numeroCC, Coordenada coordenada) {

        super(sistemaSolar,coordenada);
        this.numeroCC = numeroCC;
        this.nombre_imagen = "void.jpg";
    }
    public String toString() {
        return mostrarCoordenada() + "Vacío";
    }


    public String toString_detallado() {
        String s = String.format("""
            <html>
                %s
                <p style="font-size: 16"> Sólo el vacío.</p>
            </html>
            """,mostrarCoordenada2() );
        return s;
    }

} //fin Asteroide
