package logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {

    JPanel panelIzq = new JPanel();
    JButton boton1 = new JButton();
    JButton boton2 = new JButton();
    JButton boton3 = new JButton();
    JButton boton4 = new JButton();



    public Ventana(){

        this.setTitle("Tap Space");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400,200,500,500);
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        panelIzq.setBackground(Color.CYAN);
        panelIzq.setPreferredSize(new Dimension(150 , 100));
        panelIzq.setOpaque(true);


        Dimension dboton = new Dimension();
        dboton.setSize(150, 50);

        boton1.setSize(dboton);
        boton2.setSize(dboton);
        boton3.setSize(dboton);


        boton1.setText("Crear Universo");
        boton2.setText("Crear Coordenadas");
        boton3.setText("no valgo para nada");

        boton1.addActionListener(this);
        boton2.addActionListener(this);


        panelIzq.add(boton1);
        panelIzq.add(boton2);
        panelIzq.add(boton3);
        panelIzq.add(boton4);

        this.add(panelIzq, BorderLayout.WEST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1) {
            System.out.println("creando uni");
            Universo.crear_universo();        }

        if(e.getSource()==boton2) {
            //System.out.println("creando coordenadas");
            Universo.crear_universo();

        }
    }


}
