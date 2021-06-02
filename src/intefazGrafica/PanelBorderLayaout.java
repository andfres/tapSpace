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

    private JButton botonNorte = new JButton();
    JButton botonSur = new JButton();
    JButton botonOeste = new JButton();
    JButton botonEste= new JButton();


    PanelBorderLayaout(){

        this.setLayout(new BorderLayout());
        this.setBackground(Color.yellow);


        panelNorteUI();
        panelSurUI();
        panelOesteUI();
        panelEsteUI();
        panelCentroUI();
        botonesFlechas();

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

    public void botonesFlechas(){

        String path_imagen = "src/imagenes/flecha.png";
        int sizeA = 100;
        int sizeB = 25;
        botonNorte.setSize(sizeA,sizeB);
        botonSur.setSize(sizeA, sizeB);
        botonEste.setSize(sizeB, sizeA);
        botonOeste.setSize(sizeB, sizeA);


        ImageIcon img = new ImageIcon(path_imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(botonNorte.getWidth(), botonNorte.getHeight(), Image.SCALE_DEFAULT));

        botonNorte.setIcon(icono);
        botonSur.setIcon(icono);
        botonEste.setIcon(icono);
        botonOeste.setIcon(icono);



        panelnorte.add(botonNorte);
        panelsur.add(botonSur);
        paneleste.add(botonEste);
        paneloeste.add(botonOeste);
//
    }

}
