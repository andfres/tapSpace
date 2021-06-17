package org.andfres.interfazGrafica;

import org.andfres.App;
import org.andfres.logica.CuerpoCelestePlaneta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventanilla extends JDialog {

    Ventanilla(CuerpoCelestePlaneta cuerpoCeleste){


        this.setTitle("Cambiar nombre");
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(2,1));


        JTextField campo = new JTextField();
        campo.setSize(60,40);
        //campo.setText("hola adsfa sdfsdf");

        campo.setText(cuerpoCeleste.getNombre());
        campo.setVisible(true);



        this.add(campo);

        Button boton = new Button("Aceptar");
        this.add(boton);


        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String nombre = campo.getText();
                Global.imprimir(VPanelDerecho.label4 ,"nombre cambiado: " + nombre);
                cuerpoCeleste.setNombre(nombre);

                App.ssdb.cambiar_nombre(cuerpoCeleste, nombre);
                dispose();

            }
        });


        this.setSize(200,100);
        this.setVisible(true);
    }






}
