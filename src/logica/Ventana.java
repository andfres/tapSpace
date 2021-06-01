//esto es mio, deberia eliminarse

package logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {

    JPanel panelIzq = new JPanel();
    JPanel panelCental = new JPanel();
    JPanel panelDerecho = new JPanel();
    JPanel panelArriba = new JPanel();
    JPanel panelAbajo = new JPanel();

    public static JLabel labelInfo = new JLabel();
    JLabel label = new JLabel();

    JButton boton1 = new JButton();
    JButton boton2 = new JButton();







    public Ventana(){

        this.setTitle("Tap Space");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);

        this.setLocationRelativeTo(null);
        //this.setLayout(new BorderLayout());
        //this.pack();
        this.setResizable(false);
        this.setLayout(null);

        panelCentroUI();
        panelIzqUI();

        panelAbajoUI();



        this.setVisible(true);
        //this.pack();
        this.repaint();
    }

    public void panelCentroUI(){

        JPanel panel = panelCental;
        //panel.setPreferredSize(new Dimension(450,450));
        panel.setBounds(0,0,500,500);
        panel.setBackground(Color.red);

        int numCuerposCelestes = Universo.galaxia.length;
        GridLayout grid = new GridLayout(Universo.NUMxLado,Universo.NUMxLado);
        panel.setLayout(grid);



        for (int i = 0; i < numCuerposCelestes; i++) {

            Boton nuevoBoton = new Boton(i);
            panel.add(nuevoBoton);
            nuevoBoton.setVisible(true);
        }

        this.add(panel);
    }




    public void panelIzqUI (){
        JPanel panel = panelIzq;
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

        boton1.addActionListener(this);
        boton2.addActionListener(this);

        panelIzq.add(boton1);
        panelIzq.add(boton2);

    }

//    public void panelDerechoUI (){
//        JPanel panel = panelDerecho;
//        panel.setBackground(Color.green);
//        panel.setPreferredSize(new Dimension(200,450));
//        this.add(panel, BorderLayout.EAST);
//    }


    public void panelAbajoUI (){
        JPanel panel = panelAbajo;
        panel.setBackground(Color.magenta);
        //panel.setPreferredSize(new Dimension(850,200));
        panel.setBounds(0, 500, 500 , 200);

        panelAbajo.add(labelInfo);
        this.add(panel);
    }


    public void textAbajo (){


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1) {
            System.out.println("creando uni");
            Universo.crear_galaxia();
            this.repaint();
        }

        if(e.getSource()==boton2) {

            boton2.setText("alto = " + panelCental.getHeight() + "\r ancho" + panelCental.getWidth()) ;
        }


    }
}

