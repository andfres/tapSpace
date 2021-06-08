package org.andfres.interfazGrafica;

import org.andfres.logica.Universo;
import org.andfres.logica.Global;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class PanelBorderLayaout extends JPanel {

    int sizeA = 450;
    int sizeB = 50;
    int sizeC = 300;
    int sizeD = 30;

    PanelBorde panelnorte = new PanelBorde(sizeA, sizeB);
    PanelBorde panelsur = new PanelBorde(sizeA, sizeB);
    PanelBorde paneloeste = new PanelBorde(sizeB, sizeA);
    PanelBorde paneleste = new PanelBorde(sizeB, sizeA);

    JPanel panelcentro;

    BotonFlechasCardinales botonNorte = new BotonFlechasCardinales  (1, "flecha_N.png", sizeC, sizeD);
    BotonFlechasCardinales botonSur = new BotonFlechasCardinales  (2, "flecha_S.png", sizeC, sizeD);
    BotonFlechasCardinales botonOeste = new BotonFlechasCardinales  (3, "flecha_O.png", sizeD, sizeC);
    BotonFlechasCardinales botonEste = new BotonFlechasCardinales  (4, "flecha_E.png", sizeD, sizeC);


    PanelBorderLayaout(){

        this.setLayout(new BorderLayout());
        this.setBackground(Color.yellow);

        panelCentroUI();

        this.add(panelnorte, BorderLayout.NORTH);
        this.add(panelsur, BorderLayout.SOUTH);
        this.add(paneloeste, BorderLayout.WEST);
        this.add(paneleste, BorderLayout.EAST);

        panelnorte.add(botonNorte);
        panelsur.add(botonSur);
        paneleste.add(botonEste);
        paneloeste.add(botonOeste);

        this.setVisible(true);
    }

    public void refrescar(){

        this.remove(panelcentro);
        panelCentroUI();
        this.validate();
        this.repaint();

    }


    public void panelCentroUI(){

        this.panelcentro = new JPanel(new GridBagLayout());

        JPanel panel = panelcentro;
        panel.setBackground(Color.red);
        int numCuerposCelestes = Universo.cuerpoCelestes.length;

        GridLayout grid = new GridLayout(Universo.NUMxLado, Universo.NUMxLado);
        panel.setLayout(grid);

        for (int i = 0; i < numCuerposCelestes; i++) {

            Casilla nuevoCasilla = new Casilla(i);
            panel.add(nuevoCasilla);
            nuevoCasilla.setVisible(true);
        }
        this.add(panel, BorderLayout.CENTER);
    }
} //Fin PanelBorderLayaout


class PanelBorde extends  JLabel{

    PanelBorde(int X, int Y){
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.black);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(X,Y));

    }
}

class BotonFlechasCardinales extends JLabel{

    private int IDboton;
    BotonFlechasCardinales boton = this;
    Color color = Color.darkGray;

    BotonFlechasCardinales(int IDboton, String imagen, int X , int Y){

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

    }


} //Fin BotonFlechasCardinales

