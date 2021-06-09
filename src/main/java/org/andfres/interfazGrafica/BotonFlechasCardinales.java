package org.andfres.interfazGrafica;

import org.andfres.logica.Global;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;


class BotonFlechasCardinales extends JLabel {

    PanelBorderLayaout parent;
    private int IDboton;
    BotonFlechasCardinales boton = this;
    Color color = Color.darkGray;

    BotonFlechasCardinales(PanelBorderLayaout parent, int IDboton, String imagen, int X , int Y){

        this.parent = parent;
        this.IDboton = IDboton;
        this.setSize(X,Y);

        ImageIcon img = new ImageIcon(Global.rutaImagenes + imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        this.setIcon(icono);

        this.setOpaque(true);
        this.setBackground(color);

        this.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mousePressed(java.awt.event.MouseEvent e){
                boton.setBackground(Color.lightGray);
                cambiarCordenadasSS();
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e){

                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                    boton.setBackground(color);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }

        });//fin this.addMouseListener

    } // Fin constructor


    private static void imprimir (JLabel label , String info){
        label.setText(info);
    }

    private void cambiarCordenadasSS (){

        switch (this.IDboton){
            case 1:
                imprimir(Ventana.labelInfo, "apretaste boton arriba");
                //panelUniverso.refrescar();

                break;

            case 2:
                imprimir(Ventana.labelInfo, "apretaste boton abajo");

                break;

            case 3:
                imprimir(Ventana.labelInfo, "apretaste boton izquierda");

                break;

            case 4:
                imprimir(Ventana.labelInfo, "apretaste boton derecha");

                break;
        }


        this.parent.refrescar();

    }


} //Fin BotonFlechasCardinales

