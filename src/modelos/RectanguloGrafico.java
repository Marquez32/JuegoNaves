
package modelos;

import java.awt.Color;
import java.awt.Graphics;

//Clase que nos sirve para pintar el rectángulo en la pantalla
public class RectanguloGrafico extends Rectangulo implements Dibujable{
    
    Color color;
    
    //Constructor
    public RectanguloGrafico(Coordenada cor, float x, float y, Color uncolor) {
        super(cor,x,y);
        this.color = uncolor;
    }
    
    //Interfaz para dibujar el rectángulo
    @Override
    public void dibujar(Graphics dw) {
        dw.setColor(color);
        dw.fillRect((int)this.getX(), (int)this.getY(), (int)this.getLado(1), (int)this.getLado(2));
    }
    
    //función que define la velocidad de caida de los rectángulos
    public void ciclo(int mov) {
        float y = this.getY();
        this.setY(y += mov);
    }
    
    //función para darle color
    public void pintar(Color a) {
        this.color = a;
    }
    
}
