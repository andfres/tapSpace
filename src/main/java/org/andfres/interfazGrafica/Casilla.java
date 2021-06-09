package org.andfres.interfazGrafica;

import org.andfres.logica.CuerpoCeleste;
import org.andfres.logica.CuerposCelestesGenerador;
import org.andfres.logica.SistemaSolar;


import javax.swing.*;
import java.awt.*;

public class Casilla extends JLabel  {

    public int num_casilla;

    public Casilla(int num_boton , CuerpoCeleste cuerpoCeleste){

        this.num_casilla = num_boton;
        int size = Ventana.SIZE_TOTAL_SS / CuerposCelestesGenerador.NUMxLado;

        this.setSize(size,size);



//        String nombre_imagen = sistemaSolar.cuerpoCelestes[this.num_casilla].nombre_imagen;
        final String path_imagen = Global.rutaImagenes + cuerpoCeleste.nombre_imagen;

        ImageIcon img = new ImageIcon(path_imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));

        this.setIcon(icono);

        int ancho = this.getWidth();
        int alto = this.getHeight();


        java.awt.event.MouseAdapter listener = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {

                //System.out.println("Has hecho click en " + nombre_imagen);
                //System.out.println(Universo.galaxia[num_boton].toString());

                String info = "dimensiones del botón  \n  ancho: " +ancho + " alto: " + alto;
                imprimir(Ventana.labelInfo, info);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){

                String info = cuerpoCeleste.toString_detallado();
                imprimir(Ventana.labelInfo, info);
            }
        };

        this.addMouseListener(listener);

    }//fin constructor


    public static void imprimir (JLabel label , String info){
        label.setText(info);
    }

}//fin clase


