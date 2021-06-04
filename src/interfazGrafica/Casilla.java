package interfazGrafica;

import logica.Universo;
import javax.swing.*;
import java.awt.*;

public class Casilla extends JLabel  {

    public int num_casilla;

    public Casilla(int num_boton){

        this.num_casilla = num_boton;
        int tamano_aproximado = 450/ Universo.NUMxLado;

        this.setSize(tamano_aproximado,tamano_aproximado);

        String nombre_imagen = Universo.cuerpoCelestes[this.num_casilla].nombre_imagen;
        String path_imagen = "src/imagenes/" + nombre_imagen;

        ImageIcon img = new ImageIcon(path_imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));

        this.setIcon(icono);

        int ancho = this.getWidth();
        int alto = this.getHeight();

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {

                //System.out.println("Has hecho click en " + nombre_imagen);
                //System.out.println(Universo.galaxia[num_boton].toString());

                String cadena = "dimensiones del botón  \n  ancho: " +ancho + " alto: " + alto;

                imprimir(Ventana.labelInfo, cadena);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){

                //String info = Universo.galaxia[num_boton].toString();
                String info = Universo.cuerpoCelestes[num_boton].toString_detallado();
                //System.out.println(info);
                imprimir(Ventana.labelInfo, info);
            }

        });//fin this.addMouseListener

    }//fin constructor


    public static void imprimir (JLabel label , String info){
        label.setText(info);
    }

}//fin clase


