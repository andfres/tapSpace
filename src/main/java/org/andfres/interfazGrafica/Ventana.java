package  org.andfres.interfazGrafica;


import javax.swing.*;

public class Ventana extends JFrame   {

    VContenedor contenedor;
    String texto;
    EventoTeclado tecla;

    public Ventana(){


        contenedor = new VContenedor();
        this.setTitle("Tap Space");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setLocationRelativeTo(contenedor);
        this.setBounds(350,250,0,0);


        this.add(contenedor);
        this.setVisible(true);
        this.pack();

        //Menú configuracion
        VMenu menu = new VMenu();
        //Creo objeto del evento que muestra el menú al pulsar Esc
        tecla = new EventoTeclado(menu);
        addKeyListener(tecla);

        menu.prueba(tecla);


    }
}
