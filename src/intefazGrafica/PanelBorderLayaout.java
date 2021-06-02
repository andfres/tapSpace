package intefazGrafica;

import logica.Universo;

import javax.swing.*;
import java.awt.*;

public class PanelBorderLayaout extends JPanel {

    JPanel panelnorte = new JPanel();
    JPanel panelsur = new JPanel(new GridBagLayout());
    JPanel paneloeste = new JPanel(new GridBagLayout());
    JPanel paneleste = new JPanel(new GridBagLayout());
    JPanel panelcentro = new JPanel(new GridBagLayout());

//  private JButton botonNorte = new JButton();
//    JButton botonSur = new JButton();
//    JButton botonOeste = new JButton();
//    JButton botonEste= new JButton();
    JLabel botonNorte = new JLabel();
    JLabel botonSur = new JLabel();
    JLabel botonOeste = new JLabel();
    JLabel botonEste= new JLabel();

    GridBagConstraints c = new GridBagConstraints();

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
    Color color1 = new Color(200,200, 200);
    Color color = new Color(0, 0, 0);

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

        int sizec = 200;
        int sized = 15;
        botonNorte.setSize(sizec,sizec);
        botonSur.setSize(sizec, sizec);
        botonEste.setSize(sized, sized);
        botonOeste.setSize(sized, sized);

        botonNorte.setBackground(color1);
        botonSur.setBackground(color1);
        botonEste.setBackground(color1);
        botonOeste.setBackground(color1);

        botonNorte.setOpaque(true);
        botonSur.setOpaque(true);
        botonEste.setOpaque(true);
        botonOeste.setOpaque(true);

        ImageIcon img = new ImageIcon("src/imagenes/flecha.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(botonNorte.getWidth(), botonNorte.getHeight(), Image.SCALE_REPLICATE));


        ImageIcon img1 = new ImageIcon("src/imagenes/flecha_arriba.png");
        Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(botonNorte.getWidth(), botonNorte.getHeight(), Image.SCALE_REPLICATE));


        ImageIcon img2 = new ImageIcon("src/imagenes/flecha_abajo.png");
        Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(botonNorte.getWidth(), botonNorte.getHeight(), Image.SCALE_REPLICATE));

        ImageIcon img3 = new ImageIcon("src/imagenes/flecha_izq.png");
        Icon icono3 = new ImageIcon(img3.getImage().getScaledInstance(botonNorte.getWidth(), botonNorte.getHeight(), Image.SCALE_REPLICATE));

        ImageIcon img4 = new ImageIcon("src/imagenes/flecha_derecha.png");
        Icon icono4 = new ImageIcon(img4.getImage().getScaledInstance(botonNorte.getWidth(), botonNorte.getHeight(), Image.SCALE_REPLICATE));



        botonNorte.setIcon(icono1);
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
