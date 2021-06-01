package intefazGrafica;

import logica.Universo;

import javax.swing.*;
import java.awt.*;

public class Boton extends JLabel  {

    private int num_boton;

    Boton(int num_boton){

        this.num_boton = num_boton;
        int tamaño_aproxiado = 450/ Universo.NUMxLado;

        //no se como escalar la imagen, da igual que sea 2 o 64

        //this.setSize(2,2);
        this.setSize(tamaño_aproxiado,tamaño_aproxiado);

        String nombre_imagen = Universo.galaxia[this.num_boton].nombre_imagen;
        String path_imagen = "src/imagenes/" + nombre_imagen;

        ImageIcon img = new ImageIcon(path_imagen);
        //Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));

        this.setIcon(img);

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
                String info = Universo.galaxia[num_boton].toString_detallado();
                //System.out.println(info);
                imprimir(Ventana.labelInfo, info);
            }

        });//fin this.addMouseListener

    }//fin constructor


    public static void imprimir (JLabel label , String info){
        label.setText(info);
    }

}//fin clase





