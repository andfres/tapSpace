package org.andfres.interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class VPanelDerecho extends JPanel {

    Ventana ventana;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;

    VPanelDerecho(Ventana ventana){

        this.ventana = ventana;


        this.setBounds(ventana.SIZE_TOTAL_SS,0,ventana.SIZE_TOTAL_X - ventana.SIZE_TOTAL_SS,ventana.SIZE_TOTAL_Y);
        this.setBackground(Color.cyan);


        this.setLayout(new GridLayout(4,1));



         Dimension d = new Dimension(this.getWidth()  , (ventana.SIZE_TOTAL_Y - 100)  /4 );
        //Dimension d = new Dimension(1, 1 );

        this.label1 = new LabelPersonalizado(d , Color.green , this);
        this.label2 = new LabelPersonalizado(d , Color.blue , this);
        this.label3 = new LabelPersonalizado(d , Color.green , this);
        this.label4 = new LabelPersonalizado(d , Color.blue , this);


        ventana.add(this);

    }


}
