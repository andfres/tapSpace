package org.andfres.interfazGrafica;

import org.andfres.logica.CuerpoCeleste;
import org.andfres.logica.CuerpoCelestePlaneta;
import org.andfres.logica.CuerposCelestesGenerador;
import org.andfres.logica.SistemaSolar;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Casilla extends JLabel  {

    public int num_casilla;
    private VContenedor ventana;
    JPopupMenu pop;

    public Casilla(VContenedor ventana, int num_boton , CuerpoCeleste cuerpoCeleste){

        this.ventana = ventana;
        this.num_casilla = num_boton;
        int size = ventana.SIZE_TOTAL_SS / CuerposCelestesGenerador.NUMxLado;

        pop = new JPopupMenu();
        JMenuItem cambiarNombre = new JMenuItem("Cambiar nombre");
        pop.add(cambiarNombre);

        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //new Ventanilla(cuerpoCeleste[num_boton].get);

                if (cuerpoCeleste instanceof CuerpoCelestePlaneta){

                    //new Ventanilla(  (CuerpoCelestePlaneta) cuerpoCeleste.getNombre() );

                }
            }
        };
        cambiarNombre.addActionListener(ac);


        setComponentPopupMenu(pop);

        this.setSize(size,size);


        final String path_imagen = Global.rutaImagenes + cuerpoCeleste.nombre_imagen;

        ImageIcon img = new ImageIcon(path_imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));

        this.setIcon(icono);

        int ancho = this.getWidth();



        java.awt.event.MouseAdapter listener = new java.awt.event.MouseAdapter() {
            @Override

                public void mouseClicked(java.awt.event.MouseEvent e) {

                    String info = cuerpoCeleste.toString_detallado();
                    imprimir(ventana.panelDerecho.label3,  info);



//                if (SwingUtilities.isRightMouseButton(e)){
//
//                    imprimir(ventana.panelDerecho.label3,  "diste al derecho");
//                    new Desplegable();}
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){

                String info = cuerpoCeleste.toString_detallado();
                imprimir(ventana.panelDerecho.label2,  info);
            }

            @Override
            public void mouseExited (java.awt.event.MouseEvent e){

                imprimir(ventana.panelDerecho.label2,  " Fuera de rango ");
            }
        };

        this.addMouseListener(listener);

    }//fin constructor


    public static void imprimir (JLabel label , String info){
        label.setText(info);
    }

}//fin clase


