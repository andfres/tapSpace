package intefazGrafica;

import logica.Universo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {

    JPanel panelDerecha = new JPanel();
    JPanel panelAbajo = new JPanel();
    //JPanel panelCental = new JPanel();

    PanelBorderLayaout panelUniverso = new PanelBorderLayaout();

    public static JLabel labelInfo = new JLabel();
    JLabel labelInfo2 = new JLabel();

    JButton boton1 = new JButton();
    JButton boton2 = new JButton();
    JButton boton3 = new JButton();


    public Ventana(){

        this.setTitle("Tap Space");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        panelUniverso.setBounds(0,0,500,500);
        this.add(panelUniverso);
        //panelCentroUI();
        panelDerechaUI();
        panelAbajoUI();

        this.setVisible(true);
        this.repaint();
    }

//
//    public void panelCentroUI(){
//        JPanel panel = panelCental;
//        //panel.setPreferredSize(new Dimension(450,450));
//        //panel.setBounds(0,0,500,500);
//        panel.setBackground(Color.red);
//
//        int numCuerposCelestes = Universo.galaxia.length;
//        GridLayout grid = new GridLayout(Universo.NUMxLado,Universo.NUMxLado);
//        panel.setLayout(grid);
//
//        for (int i = 0; i < numCuerposCelestes; i++) {
//
//            Boton nuevoBoton = new Boton(i);
//            panel.add(nuevoBoton);
//            nuevoBoton.setVisible(true);
//        }
//
//        this.add(panel);
//    }
//


    public void panelDerechaUI (){
        JPanel panel = panelDerecha;
        panel.setBackground(Color.cyan);
        //panel.setPreferredSize(new Dimension(200,450));
        panel.setBounds(500,0,200,700);

        //this.add(panel, BorderLayout.WEST);
        this.add(panel);

        Dimension dboton = new Dimension();
        dboton.setSize(150, 50);

        boton1.setSize(dboton);
        boton2.setSize(dboton);

        boton1.setText("Crear Universo");
        boton2.setText("Tamaño medio ");
        boton3.setText("T abajo ");

        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);

        panelDerecha.add(boton1);
        panelDerecha.add(boton2);
        panelDerecha.add(boton3);

    }

//    public void panelDerechoUI (){
//        JPanel panel = panelDerecho;
//        panel.setBackground(Color.green);
//        panel.setPreferredSize(new Dimension(200,450));
//        this.add(panel, BorderLayout.EAST);
//    }


    public void panelAbajoUI (){
        JPanel panel = panelAbajo;
        panel.setLayout(null);
        panel.setBackground(Color.magenta);
        panel.setBounds(0, 500, 500 , 200);


        labelInfo.setVerticalTextPosition(JLabel.TOP);
        labelInfo.setHorizontalTextPosition(JLabel.LEFT);
        //SwingConstants


        labelInfo.setSize(450, 100);

        labelInfo.setBackground(Color.green);
        panelAbajo.add(labelInfo);
        labelInfo.setVisible(true);
        labelInfo.setOpaque(true);

        this.add(panel);
    }






    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1) {
            System.out.println("creando uni");
            Universo.crear_galaxia();
            this.repaint();
        }

        if(e.getSource()==boton2) {

            //boton2.setText("alto: " + panelCental.getHeight() + "\r ancho: " + panelCental.getWidth()) ;
        }

        if(e.getSource()==boton3) {

            //boton3.setText("alto: " + panelAbajo.getHeight() + "\r ancho: " + panelAbajo.getWidth()) ;
            boton3.setText("alto: " + labelInfo.getHeight() + "\r ancho: " + labelInfo.getWidth()) ;
        }
    }
}

