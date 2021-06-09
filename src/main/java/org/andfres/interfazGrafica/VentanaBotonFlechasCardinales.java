package org.andfres.interfazGrafica;

import org.andfres.logica.SistemaSolar;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;


class VentanaBotonFlechasCardinales extends JLabel {

    VentanaContenedorPanelBorder parent;
    private int IDboton;
    VentanaBotonFlechasCardinales boton = this;
    Color color = Color.darkGray;

    VentanaBotonFlechasCardinales(VentanaContenedorPanelBorder parent, int IDboton, String imagen, int X , int Y){

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
                    TimeUnit.MILLISECONDS.sleep(10);
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

        int cambioCoordenadaX = 0;
        int cambioCoordenadaY = 0;

        switch (this.IDboton){
            case 1:
                imprimir(Ventana.labelInfo, "apretaste boton arriba");
                cambioCoordenadaX = 0;
                cambioCoordenadaY = 1;

                break;

            case 2:
                imprimir(Ventana.labelInfo, "apretaste boton abajo");
                cambioCoordenadaX = 0;
                cambioCoordenadaY = -1;

                break;

            case 3:
                imprimir(Ventana.labelInfo, "apretaste boton izquierda");
                cambioCoordenadaX = 0;
                cambioCoordenadaY = -1;
                break;

            case 4:
                imprimir(Ventana.labelInfo, "apretaste boton derecha");
                cambioCoordenadaX = 0;
                cambioCoordenadaY = 1;

                break;
        }

        SistemaSolar sistemaSolar = new SistemaSolar(cambioCoordenadaX, cambioCoordenadaY );
        this.parent.refrescar(sistemaSolar);

    }


} //Fin BotonFlechasCardinales

