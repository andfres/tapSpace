package intefazGrafica;

import logica.Universo;

import javax.swing.*;
import java.awt.*;

public class PanelBorderLayaout extends JPanel {

    JPanel panelnorte = new JPanel();
    JPanel panelsur = new JPanel();
    JPanel paneloeste = new JPanel();
    JPanel paneleste = new JPanel();
    JPanel panelcentro = new JPanel();

    PanelBorderLayaout(){

        this.setLayout(new BorderLayout());
        //this.setBounds(0,0,500,500);
        this.setBackground(Color.yellow);

        panelNorteUI();
        panelSurUI();
        panelOesteUI();
        panelEsteUI();
        panelCentroUI();

        this.setVisible(true);
    }

    int sizeA = 50;
    int sizeB = 450;
    Color color = new Color(0,0,0);

    public void panelNorteUI (){
        JPanel panel = panelnorte;
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(sizeB,sizeA));
        this.add(panel, BorderLayout.NORTH);
    }
    public void panelSurUI (){
        JPanel panel = panelsur;
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(sizeB,sizeA));
        this.add(panel, BorderLayout.SOUTH);
    }
    public void panelOesteUI (){
        JPanel panel = paneloeste;
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(sizeA,sizeB));
        this.add(panel, BorderLayout.WEST);
    }
    public void panelEsteUI (){
        JPanel panel = paneleste;
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(sizeA,sizeB));
        this.add(panel, BorderLayout.EAST);
    }




    public void panelCentroUI(){
        JPanel panel = panelcentro;
        //panel.setPreferredSize(new Dimension(450,450));
        //panel.setBounds(0,0,500,500);
        panel.setBackground(Color.red);

        int numCuerposCelestes = Universo.galaxia.length;
        GridLayout grid = new GridLayout(Universo.NUMxLado,Universo.NUMxLado);
        panel.setLayout(grid);

        for (int i = 0; i < numCuerposCelestes; i++) {

            Boton nuevoBoton = new Boton(i);
            panel.add(nuevoBoton);
            nuevoBoton.setVisible(true);
        }

        this.add(panel, BorderLayout.CENTER);
    }
}
