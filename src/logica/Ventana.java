package logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {

    public final int SIZE_TOTAL_X = 0;
    public final int SIZE_TOTAL_Y = 700;
    public final int SIZE_TOTAL_SS = 0;

    JPanel panelSS = new JPanel();
    JPanel panelDerecha = new JPanel();
    JPanel panelAbajo = new JPanel();

    public static JLabel labelInfo = new JLabel();

    JButton boton1 = new JButton();
    JButton boton2 = new JButton();



//    public Ventana(){
//
//        this.setTitle("Tap Space");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(SIZE_TOTAL_X,SIZE_TOTAL_Y);
//
//        //this.setLocationRelativeTo(null);
//        //this.setResizable(false);
//        this.setLayout(null);
//
//        panelSSUI();
//        panelDerechaUI();
//        panelAbajoUI();
//
//        this.setVisible(true);
//        //this.pack();
//        //this.repaint();//    }

    public void panelSSUI(){

//        JPanel panel = panelSS;
//        panel.setBounds(0,0,SIZE_TOTAL_SS,SIZE_TOTAL_SS);
//        panel.setBackground(Color.red);
//
//        int numCuerposCelestes = Universo.cuerpoCelestes.length;
//        GridLayout grid = new GridLayout(Universo.NUMxLado,Universo.NUMxLado);
//        panel.setLayout(grid);
//
//        for (int i = 0; i < numCuerposCelestes; i++) {
//
//            Casilla nuevoCasilla = new Casilla(i);
//            panel.add(nuevoCasilla);
//            nuevoCasilla.setVisible(true);
//        }
//
//        this.add(panel);
    }


    public void panelDerechaUI (){
        JPanel panel = panelDerecha;
        panel.setBackground(Color.cyan);
        panel.setBounds(SIZE_TOTAL_SS,0,SIZE_TOTAL_X - SIZE_TOTAL_SS ,SIZE_TOTAL_Y);

        this.add(panel);

        Dimension dboton = new Dimension();
        dboton.setSize(150, 50);

        boton1.setSize(dboton);
        boton2.setSize(dboton);

        boton1.setText("Crear Universo");
        boton2.setText("Tamaño medio ");

        boton1.addActionListener(this);
        boton2.addActionListener(this);

        panelDerecha.add(boton1);
        panelDerecha.add(boton2);

    }



    public void panelAbajoUI (){
        JPanel panel = panelAbajo;
        panel.setBackground(Color.magenta);
        panel.setBounds(0, SIZE_TOTAL_SS, SIZE_TOTAL_SS , SIZE_TOTAL_Y - SIZE_TOTAL_SS);

        panelAbajo.add(labelInfo);
        this.add(panel);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1) {
            System.out.println("creando uni");
            Universo.crear_galaxia();
            this.repaint();
        }


    }
}

