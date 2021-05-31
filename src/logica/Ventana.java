package logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana extends JFrame implements ActionListener {



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
            JLabel nuevoboton = new JLabel();
            nuevoboton.setSize(10,10);

            String nombre_imagen = Universo.galaxia[i].nombre_imagen;
            String path_imagen = "src/imagenes/" + nombre_imagen;


            //ImageIcon img = new ImageIcon("src/imagenes/planeta_03.jpg");
            ImageIcon img = new ImageIcon(path_imagen);
            Icon icono = new ImageIcon(img.getImage().getScaledInstance(nuevoboton.getWidth(), nuevoboton.getHeight(), Image.SCALE_DEFAULT));

            nuevoboton.setIcon(img);


            nuevoboton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Has hecho click en " + nombre_imagen);
                }
            });


            panel.add(nuevoboton);
            nuevoboton.setVisible(true);
        }

        this.add(panel, BorderLayout.CENTER);

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

            boton2.setText("alto = " + panelCental.getHeight() + "\r ancho" + panelCental.getWidth()) ;
        }


    }


}
