package interfazGrafica;

import logica.Universo;

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

    JPanel panelcentro = new JPanel(new GridBagLayout());


    BotonFlechasCardinales botonNorte = new BotonFlechasCardinales  ("flecha_N.png", sizeC, sizeD);
    BotonFlechasCardinales botonSur = new BotonFlechasCardinales  ("flecha_S.png", sizeC, sizeD);
    BotonFlechasCardinales botonOeste = new BotonFlechasCardinales  ("flecha_O.png", sizeD, sizeC);
    BotonFlechasCardinales botonEste = new BotonFlechasCardinales  ("flecha_E.png", sizeD, sizeC);

    //GridBagConstraints c = new GridBagConstraints();

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


    public void panelCentroUI(){
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

    BotonFlechasCardinales(String imagen, int X , int Y){
        this.setSize(X,Y);
        this.setBackground(Color.black);
        ImageIcon img = new ImageIcon("src/imagenes/" + imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        this.setIcon(icono);
    }

} //Fin BotonFlechasCardinales

