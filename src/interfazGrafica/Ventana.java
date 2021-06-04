package interfazGrafica;

import logica.Universo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {


    public final int SIZE_TOTAL_X = 800;
    public final int SIZE_TOTAL_Y = 800;
    public static final int SIZE_TOTAL_SS = 600;

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
        this.setSize(SIZE_TOTAL_X,SIZE_TOTAL_Y);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        //panelUniverso.setBounds(0,0,500,500);

        panelUniverso.setBounds(0,0,SIZE_TOTAL_SS,SIZE_TOTAL_SS);
        this.add(panelUniverso);
        panelDerechaUI();
        panelAbajoUI();

        this.setVisible(true);
        this.repaint();
    }



    public void panelDerechaUI (){
        JPanel panel = panelDerecha;
        panel.setBackground(Color.cyan);

        //panel.setBounds(500,0,200,700);
        panel.setBounds(SIZE_TOTAL_SS,0,SIZE_TOTAL_X - SIZE_TOTAL_SS,SIZE_TOTAL_Y);

        this.add(panel);
        Dimension dboton = new Dimension();
        dboton.setSize(150, 50);

        boton1.setSize(dboton);
        boton2.setSize(dboton);

        boton1.setText("Crear Universo");
        boton2.setText("Tamaño medio ");
        boton3.setText("soy tontito ");

        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);

        panelDerecha.add(boton1);
        panelDerecha.add(boton2);
        panelDerecha.add(boton3);

    }


    public void panelAbajoUI (){

        JPanel panel = panelAbajo;
        panel.setLayout(null);
        panel.setBackground(Color.magenta);
        //panel.setBounds(0, 500, 500 , 200);
        panel.setBounds(0,SIZE_TOTAL_SS,SIZE_TOTAL_SS ,SIZE_TOTAL_Y- SIZE_TOTAL_SS);


        // Panel Verde
        labelInfo.setVerticalTextPosition(JLabel.TOP);
        labelInfo.setHorizontalTextPosition(JLabel.LEFT);
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

