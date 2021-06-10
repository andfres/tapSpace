package org.andfres.interfazGrafica;

import javax.swing.*;
import java.awt.*;

public class VContenedor extends JPanel{

    public final int SIZE_TOTAL_X = 850;
    public final int SIZE_TOTAL_Y = SIZE_TOTAL_SS;
    public static final int SIZE_TOTAL_SS = 600;


    VPanelDerecho panelDerecho;
    //VPanelAbajo panelAbajo;
    VPanelSS panelUniverso;

    public  VContenedor(){


        //El orden de la creación de objetos es importante - NO cambiar

        panelDerecho = new VPanelDerecho(this);
        //panelAbajo = new VPanelAbajo(this);
        panelUniverso = new VPanelSS(this);


        //this.setSize(SIZE_TOTAL_X,SIZE_TOTAL_Y);
        Dimension d = new Dimension(SIZE_TOTAL_X,SIZE_TOTAL_Y);

        this.setPreferredSize(d);
        this.setBackground(Color.magenta);


        this.setLayout(null);

        panelUniverso.setBounds(0,0,SIZE_TOTAL_SS,SIZE_TOTAL_SS);


        this.setVisible(true);
        this.setOpaque(true);

        this.add(panelUniverso);

    }
}
