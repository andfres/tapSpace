package org.andfres.interfazGrafica;


import org.andfres.App;
import org.andfres.logica.SistemaSolar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VMenu extends JDialog {

    Boton boton;
    Boton boton1;
    Boton boton2;
    Boton boton3;

    public VMenu(){

        this.setTitle("menu");
        this.setLocationRelativeTo(null);

        this.setResizable(false);
        GridLayout layaout = new GridLayout(4,2,10,10);

        this.setLayout(layaout);

        this.getContentPane().setBackground(Color.darkGray);


         boton = new Boton("Nuevo Juego", this);
         boton1 = new Boton("Configuración" , this);
         boton2 = new Boton("Controles", this);
         boton3 = new Boton("Audio", this);



        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getSource()==boton){

                    App.ssdb.borrarTablas();
                    App.ssdb.crearTablas();
                    System.out.println("Juego reiniciado");

                    SistemaSolar sistemaSolar = SistemaSolar.cargarSS(0, 0);
                    App.ventana.contenedor.panelUniverso.refrescar(sistemaSolar);

                }

            }
        });


        this.setSize(200,500);
        this.setVisible(false);

    }


    public void prueba(EventoTeclado tecla){
        addKeyListener(tecla);
        this.boton.addKeyListener(tecla);
        this.boton1.addKeyListener(tecla);
        this.boton2.addKeyListener(tecla);
        this.boton3.addKeyListener(tecla);
    }

}



class Boton extends JButton{

    Boton (String cadena, Container contenedor){


        this.setText(cadena);

        this.setBackground(Color.black);
        this.setForeground(Color.green);
        this.setBorder(
                BorderFactory.createLineBorder(Color.GREEN, 5)
        );
        contenedor.add(this);
    }


}