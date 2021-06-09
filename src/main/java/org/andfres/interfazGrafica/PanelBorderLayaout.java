package org.andfres.interfazGrafica;

import org.andfres.logica.Universo;

import javax.swing.*;
import java.awt.*;

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

    BotonFlechasCardinales botonNorte = new BotonFlechasCardinales  (this, 1, "flecha_N.png", sizeC, sizeD);
    BotonFlechasCardinales botonSur = new BotonFlechasCardinales  (this, 2, "flecha_S.png", sizeC, sizeD);
    BotonFlechasCardinales botonOeste = new BotonFlechasCardinales  (this, 3, "flecha_O.png", sizeD, sizeC);
    BotonFlechasCardinales botonEste = new BotonFlechasCardinales  (this, 4, "flecha_E.png", sizeD, sizeC);


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
