package logica;

import javax.swing.*;
import java.awt.*;

public class Boton extends JLabel  {

    private int num_boton;

    Boton(int num_boton){

        this.num_boton = num_boton;

        this.setSize(10,10);

        String nombre_imagen = Universo.galaxia[this.num_boton].nombre_imagen;
        String path_imagen = "src/imagenes/" + nombre_imagen;

        ImageIcon img = new ImageIcon(path_imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));

        this.setIcon(img);

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                //System.out.println("Has hecho click en " + nombre_imagen);
                System.out.println(Universo.galaxia[num_boton].toString());
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){

                //String info = Universo.galaxia[num_boton].toString();
                String info = Universo.galaxia[num_boton].toString_detallado();

                System.out.println(info);


                imprimir(Ventana.labelInfo, info);

            }



        });//fin this.addMouseListener

    }//fin constructor


    public static void imprimir (JLabel label , String info){

        label.setText(info);

    }

}//fin clase





