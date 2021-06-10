package org.andfres.interfazGrafica;

import org.andfres.database.Cargar_o_Generar_SistemaSolar;
import org.andfres.logica.CuerposCelestesGenerador;
import org.andfres.logica.SistemaSolar;

import javax.swing.*;
import java.awt.*;

public class VPanelSS extends JPanel {


    SistemaSolar sistemaSolar = Cargar_o_Generar_SistemaSolar.cargarPrimerPlaneta();
    //SistemaSolar sistemaSolar = new SistemaSolar(0,0, "el primero");
    //recoger de la base de datos el ultimo sistema solar



    VContenedor ventana;
    JLabel panelInfo;

    int sizeA = 450;
    int sizeB = 50;
    int sizeC = 300;
    int sizeD = 30;

    VSSPanelBorde panelnorte = new VSSPanelBorde(sizeA, sizeB);
    VSSPanelBorde panelsur = new VSSPanelBorde(sizeA, sizeB);
    VSSPanelBorde paneloeste = new VSSPanelBorde(sizeB, sizeA);
    VSSPanelBorde paneleste = new VSSPanelBorde(sizeB, sizeA);

    JPanel panelcentro;

    VBotonFlechas botonNorte = new VBotonFlechas(this, 1, "flecha_N.png", sizeC, sizeD);
    VBotonFlechas botonSur = new VBotonFlechas(this, 2, "flecha_S.png", sizeC, sizeD);
    VBotonFlechas botonOeste = new VBotonFlechas(this, 3, "flecha_O.png", sizeD, sizeC);
    VBotonFlechas botonEste = new VBotonFlechas(this, 4, "flecha_E.png", sizeD, sizeC);


    VPanelSS(VContenedor ventana){

        this.ventana = ventana;
        panelInfo = ventana.panelDerecho.label1 ;

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

        panelInfo.setText(sistemaSolar.toString());

        this.setVisible(true);
    }

    // Refresco el panel panel del centro y traigo un nuevo SS
    public void refrescar(SistemaSolar sistemaSolar){

        this.sistemaSolar = sistemaSolar;
        panelInfo.setText(sistemaSolar.toString());
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

            Casilla nuevoCasilla = new Casilla(ventana, i , sistemaSolar.cuerpoCelestes[i] );
            panel.add(nuevoCasilla);
            nuevoCasilla.setVisible(true);
        }
        this.add(panel, BorderLayout.CENTER);
    }



    class VSSPanelBorde extends  JLabel{

        VSSPanelBorde(int X, int Y){
            this.setLayout(new GridBagLayout());
            this.setBackground(Color.black);
            this.setOpaque(true);
            this.setPreferredSize(new Dimension(X,Y));

        }
    }


} //Fin PanelSS
