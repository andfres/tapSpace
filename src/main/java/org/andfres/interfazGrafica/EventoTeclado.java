package org.andfres.interfazGrafica;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class EventoTeclado implements KeyListener {

    VMenu menu ;

    public EventoTeclado(VMenu menu) {
        this.menu = menu;
    }

    public EventoTeclado(){

    }


    @Override
    public void keyPressed(KeyEvent e ) {


        System.out.println(e.getKeyCode());
        //System.out.println(e.getKeyChar());
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){

            System.out.println("Esc");

            if (menu.isVisible()){
                System.out.println("esta abierta.. cerrando?");
                //menu.dispose();
                menu.setVisible(false);
            }else{
                System.out.println("esta cerrada.. la abri?");
                menu.setVisible(true);

            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }
}

