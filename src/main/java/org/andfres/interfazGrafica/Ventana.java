package  org.andfres.interfazGrafica;

import javax.swing.*;

public class Ventana extends JFrame   {



    public final int SIZE_TOTAL_X = 800;
    public final int SIZE_TOTAL_Y = 850;
    public static final int SIZE_TOTAL_SS = 600;


    VPanelDerecho panelDerecho;
    VPanelAbajo panelAbajo;
    VPanelSS panelUniverso;


    public Ventana(){

        //El orden de la creación de objetos es importante - NO cambiar

        panelDerecho = new VPanelDerecho(this);
        panelAbajo = new VPanelAbajo(this);
        panelUniverso = new VPanelSS(this);

        this.setTitle("Tap Space");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SIZE_TOTAL_X,SIZE_TOTAL_Y);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        panelUniverso.setBounds(0,0,SIZE_TOTAL_SS,SIZE_TOTAL_SS);
        this.add(panelUniverso);

        this.setVisible(true);

    }
}

