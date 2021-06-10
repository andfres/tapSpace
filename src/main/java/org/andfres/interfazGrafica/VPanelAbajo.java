package org.andfres.interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class VPanelAbajo extends JPanel {

    Ventana ventana;
    JLabel labelInfo;
    JLabel labelInfo2;


    VPanelAbajo(Ventana ventana){

        this.ventana = ventana;
        //this.setBackground(Color.cyan);


        this.setLayout(new GridBagLayout());
        this.setBackground(Color.magenta);
        this.setBounds(0,ventana.SIZE_TOTAL_SS,ventana.SIZE_TOTAL_SS ,ventana.SIZE_TOTAL_Y - ventana.SIZE_TOTAL_SS);

        Dimension d = new Dimension(this.getWidth() /2 , this.getHeight());

        this.labelInfo = new LabelPersonalizado(d , Color.green , this);
        this.labelInfo2 = new LabelPersonalizado(d , new Color(102,57,177) , this);

        ventana.add(this);

    }

}

