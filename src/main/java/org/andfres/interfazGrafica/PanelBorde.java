package org.andfres.interfazGrafica;

import javax.swing.*;
import java.awt.*;


class PanelBorde extends  JLabel{

    PanelBorde(int X, int Y){
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.black);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(X,Y));

    }
}

