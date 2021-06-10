package org.andfres.interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class Ventanilla extends JDialog {

    Ventanilla(){


        this.setTitle("Cambiar nombre");
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(2,1));


        JTextField campo = new JTextField();
        campo.setSize(60,40);
        campo.setText("hola adsfa sdfsdf");
        campo.setVisible(true);
        this.add(campo);



        Button boton = new Button("Aceptar");
        this.add(boton);




        this.setSize(200,100);
        this.setVisible(true);
    }
}
