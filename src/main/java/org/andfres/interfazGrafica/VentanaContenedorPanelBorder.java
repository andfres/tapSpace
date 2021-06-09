package org.andfres.interfazGrafica;

import org.andfres.logica.CuerposCelestesGenerador;
import org.andfres.logica.SistemaSolar;

import javax.swing.*;
import java.awt.*;

public class VentanaContenedorPanelBorder extends JPanel {

    SistemaSolar sistemaSolar = new SistemaSolar(0,0);
    //recoger de la base de datos el ultimo sistema solar

    int sizeA = 450;
    int sizeB = 50;
    int sizeC = 300;
    int sizeD = 30;

    VentanaPanelBorde panelnorte = new VentanaPanelBorde(sizeA, sizeB);
    VentanaPanelBorde panelsur = new VentanaPanelBorde(sizeA, sizeB);
    VentanaPanelBorde paneloeste = new VentanaPanelBorde(sizeB, sizeA);
    VentanaPanelBorde paneleste = new VentanaPanelBorde(sizeB, sizeA);

    JPanel panelcentro;

    VentanaBotonFlechasCardinales botonNorte = new VentanaBotonFlechasCardinales(this, 1, "flecha_N.png", sizeC, sizeD);
    VentanaBotonFlechasCardinales botonSur = new VentanaBotonFlechasCardinales(this, 2, "flecha_S.png", sizeC, sizeD);
    VentanaBotonFlechasCardinales botonOeste = new VentanaBotonFlechasCardinales(this, 3, "flecha_O.png", sizeD, sizeC);
    VentanaBotonFlechasCardinales botonEste = new VentanaBotonFlechasCardinales(this, 4, "flecha_E.png", sizeD, sizeC);


    VentanaContenedorPanelBorder(){

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

    // Refresco el panel panel del centro y traigo un nuevo SS
    public void refrescar(SistemaSolar sistemaSolar){

        this.sistemaSolar = sistemaSolar;
        System.out.println("mostrando nuevo SS" + sistemaSolar.toString());
        this.remove(panelcentro);
        panelCentroUI();
        this.validate();
        this.repaint();

    }


    public void panelCentroUI(){

        this.panelcentro = new JPanel(new GridBagLayout());

        JPanel panel = panelcentro;
        panel.setBackground(Color.red);
        int numCuerposCelestes = CuerposCelestesGenerador.NUMCUERPOS;

        GridLayout grid = new GridLayout(CuerposCelestesGenerador.NUMxLado, CuerposCelestesGenerador.NUMxLado);
        panel.setLayout(grid);

        for (int i = 0; i < numCuerposCelestes; i++) {

            Casilla nuevoCasilla = new Casilla(i , sistemaSolar.cuerpoCelestes[i] );
            panel.add(nuevoCasilla);
            nuevoCasilla.setVisible(true);
        }
        this.add(panel, BorderLayout.CENTER);
    }
} //Fin PanelBorderLayaout
