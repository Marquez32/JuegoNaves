
package modelos;

import java.awt.Color;
import java.awt.Graphics;

//Clase que nos sirve para pintar el círculo en la pantalla
public class CirculoGrafico extends Circulo implements Dibujable{

    Color color;
    
    //Constructor
    public CirculoGrafico(Coordenada cor, float radio, Color uncolor) {
        super(cor, radio);
        this.color = uncolor;
    }
    
    
    //Interfaz para dibujar el círculo 
    @Override
    public void dibujar(Graphics dw) {
        dw.setColor(color);
        dw.fillOval((int) (this.getX() - this.getRadio()), (int) (this.getY() - this.getRadio()), 
                (int) (2 * this.getRadio()), (int) (2 * this.getRadio()));
    }
    
    //función para darle color al círculo
    public void pintar(Color a) {
        this.color = a;
    }
    
}
