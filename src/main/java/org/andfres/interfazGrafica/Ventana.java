package  org.andfres.interfazGrafica;

import javax.swing.*;

public class Ventana extends JFrame   {

    VContenedor contenedor;
    String texto;

    public Ventana(String nombrePalenta){

        this.texto = nombrePalenta;
        contenedor = new VContenedor();
        this.setTitle("Tap Space");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setLocationRelativeTo(contenedor);
        this.setBounds(350,250,0,0);
        //this.setLayout(null);

        //this.setSize(1000,1000);

        this.add(contenedor);
        this.setVisible(true);
        this.pack();

    }
}

