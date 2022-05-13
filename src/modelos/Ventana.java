
package modelos;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

//Clase Ventana
public class Ventana extends JFrame implements WindowListener{
    
    //Constructor de la Ventana
    public Ventana(String titulo) {
        super(titulo);
        setSize(500,500);
        addWindowListener(this);
        setBackground(Color.white);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    //Al pulsar la X finaliza el programa
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
       
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
}
