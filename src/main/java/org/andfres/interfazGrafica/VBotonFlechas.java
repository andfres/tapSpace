package org.andfres.interfazGrafica;

import org.andfres.logica.SistemaSolar;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;


class VBotonFlechas extends JLabel {

    VPanelSS parent;
    private int IDboton;
    VBotonFlechas boton = this;
    Color color = Color.darkGray;

    VBotonFlechas(VPanelSS parent, int IDboton, String imagen, int X , int Y){

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

//
//    private void calcularNuevasCorrdenadas (int cambioX , int cambioY){
//
//    }

    private static void imprimir (JLabel label , String info){
        label.setText(info);
    }

    private void cambiarCordenadasSS (){

        int cambioCoordenadaX = 0;
        int cambioCoordenadaY = 0;
        int Xactual = parent.sistemaSolar.getX();
        int Yactual = parent.sistemaSolar.getY();


        switch (this.IDboton){
            case 1:
                //imprimir(Ventana.labelInfo, "apretaste boton arriba");
                cambioCoordenadaX = 0 + Xactual;
                cambioCoordenadaY = 1 + Yactual;

                break;

            case 2:
                //imprimir(Ventana.labelInfo, "apretaste boton abajo");
                cambioCoordenadaX = 0 + Xactual;
                cambioCoordenadaY = -1 + Yactual;

                break;

            case 3:
                //imprimir(Ventana.labelInfo, "apretaste boton izquierda");
                cambioCoordenadaX = -1 + Xactual;
                cambioCoordenadaY = 0 + Yactual;
                break;

            case 4:
                //imprimir(Ventana.labelInfo, "apretaste boton derecha");
                cambioCoordenadaX = 1 + Xactual ;
                cambioCoordenadaY = 0 + Yactual;

                break;
        }

        SistemaSolar sistemaSolar = SistemaSolar.cargarSS(cambioCoordenadaX, cambioCoordenadaY);
        //SistemaSolar sistemaSolar = new SistemaSolar(cambioCoordenadaX, cambioCoordenadaY , "sin nombre");
        this.parent.refrescar(sistemaSolar);

    }


} //Fin BotonFlechasCardinales

