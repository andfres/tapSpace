package org.andfres.interfazGrafica;


import javax.swing.*;
import java.awt.*;

public class LabelPersonalizado extends JLabel {



    LabelPersonalizado(Dimension dimension, Color color, JPanel panel) {

        this.setPreferredSize(dimension);
        this.setBackground(color);
        this.setOpaque(true);

        panel.add(this);
    }

}