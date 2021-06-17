package org.andfres.logica;

public class CuerpoCelestePlaneta extends CuerpoCeleste{

    //Parámetros
    private String nombre;
    private final int tipo_planeta;
    private final String [] []  array_nombres_fotos = {
         {"planeta_03.jpg" , "planeta_04.jpg", "planeta_16.jpg", "planeta_18.jpg" },
         {"planeta_02.jpg" , "planeta_07.jpg", "planeta_08.jpg", "planeta_14.jpg" },
         {"planeta_01.jpg" , "planeta_05.jpg", "planeta_12.jpg", "planeta_13.jpg" },
         {"planeta_10.jpg" , "planeta_11.jpg" }};

    private final String [] tipo_planeta_string = {"Roca" , "Agua" , "bosque", "Fuego"};

    //Constructor
    public CuerpoCelestePlaneta(SistemaSolar sistemaSolar , Coordenada coordenada, String nombre, int tipo_planeta, String imagen) {

        super(sistemaSolar,coordenada);

        this.nombre = nombre;
        this.tipo_planeta = tipo_planeta;


        if (imagen == null){
            super.nombre_imagen = elegirFoto();
        }
        else{
            super.nombre_imagen = imagen;
        }
    }

    // Método para aleatorizar imagen
    public String elegirFoto(){

        int size = array_nombres_fotos[tipo_planeta].length;
        int num = Aleatorizador.int_aleatorio(0,size);
        return array_nombres_fotos[tipo_planeta][num];
    }

    @Override
    public String toString() {
        return mostrarCoordenada() +
                "Planeta{" +
                "name='" + nombre + '/' +
                ", tipo='" + tipo_planeta + '/' +
                '}';
    }


    public String toString_detallado() {

        return String.format("""
            <html>
                %s
                <p>Planeta <span style="font-size: 18"> %s </span>  </p>
                <p>Bioma de tipo <span style="font-size: 18"> %s </span>  </p>
                
            </html>
            
            """,mostrarCoordenada2(), nombre,  tipo_planeta_string[tipo_planeta]  );
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipo() {
        return tipo_planeta;
    }
} //fin Planeta

