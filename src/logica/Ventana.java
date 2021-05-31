package logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {

    Dimension d100 = new Dimension(100,100);

    JPanel panelIzq = new JPanel();
    JPanel panelCental = new JPanel();
    JPanel panelDerecho = new JPanel();
    JPanel panelArriba = new JPanel();
    JPanel panelAbajo = new JPanel();

    JButton boton1 = new JButton();

    JLabel label = new JLabel();

    JButton boton2 = new JButton();
    JButton boton3 = new JButton();
    JButton boton4 = new JButton();



    public Ventana(){

        this.setTitle("Tap Space");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400,200,750,750);


        //this.pack();
        this.setLayout(new BorderLayout());


        panelIzqUI();
        galaxiarUI();
        panelDerechoUI();
        panelAbajoUI();

        this.setVisible(true);
        //this.pack();


    }

    public void galaxiarUI(){

        JPanel panel = panelCental;
        panel.setPreferredSize(d100);
        panel.setBackground(Color.red);

        int numCuerposCelestes = Universo.galaxia.length;
        GridLayout grid = new GridLayout(Universo.NUMxLado,Universo.NUMxLado);
        panel.setLayout(grid);

        ImageIcon img = new ImageIcon("planeta_02.jpg");


        for (int i = 0; i < numCuerposCelestes; i++) {
            JButton nuevoboton = new JButton("" + i);
            nuevoboton.setIcon(img);

            panel.add(nuevoboton);

        }


        this.add(panel, BorderLayout.CENTER);


    }

    public void panelIzqUI (){
        JPanel panel = panelIzq;
        panel.setBackground(Color.cyan);
        panel.setPreferredSize(d100);

        this.add(panel, BorderLayout.WEST);

        Dimension dboton = new Dimension();
        dboton.setSize(150, 50);

        boton1.setSize(dboton);
        boton2.setSize(dboton);


        boton1.setText("Crear Universo");
        boton2.setText("Crear Coordenadas");

        boton1.addActionListener(this);
        boton2.addActionListener(this);

        panelIzq.add(boton1);
        panelIzq.add(boton2);

    }

    public void panelDerechoUI (){

        JPanel panel = panelDerecho;
        panel.setBackground(Color.green);
        panel.setPreferredSize(d100);

        this.add(panel, BorderLayout.EAST);

    }

    public void panelAbajoUI (){
        JPanel panel = panelAbajo;
        panel.setBackground(Color.magenta);
        panel.setPreferredSize(d100);

        this.add(panel, BorderLayout.SOUTH);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1) {
            System.out.println("creando uni");
            Universo.crear_galaxia();        }

        if(e.getSource()==boton2) {
            //System.out.println("creando coordenadas");
            Universo.crear_galaxia();

        }
    }
}
