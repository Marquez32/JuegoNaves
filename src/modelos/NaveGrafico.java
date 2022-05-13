
package modelos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

//Clase que nos sirve para pintar la nave en la pantalla
public class NaveGrafico extends Nave implements Dibujable{
    
    Color color;
    
    //Constructor
    public NaveGrafico(Coordenada a, Coordenada b, Coordenada c, Color uncolor) {
        super(a,b,c);
        this.color = uncolor;
    }
    
    //Interfaz que nos sirve para dibujar el triángulo de la nave
    @Override
    public void dibujar(Graphics dw) {
        dw.setColor(color);
        
        int x[] = {(int) this.getX(), (int) this.cor1.getX(), (int) this.cor2.getX()};
        int y[] = {(int) this.getY(), (int) this.cor1.getY(), (int) this.cor2.getY()};
        
        Polygon p = new Polygon(x, y, 3);
        
        dw.fillPolygon(p);
    }
    
    //Función que le da color a la nave
    public void pintar(Graphics dw, Color uncolor) {
        dw.setColor(uncolor);
        
        int x[] = {(int) this.getX(), (int) this.cor1.getX(), (int) this.cor2.getX()};
        int y[] = {(int) this.getY(), (int) this.cor1.getY(), (int) this.cor2.getY()};
        
        Polygon p = new Polygon(x, y, 3);
        
        dw.fillPolygon(p);
    }
    
    //Función que sirve para disparar una bala(círculo
    public CirculoGrafico bala() {
        Coordenada salida = new Coordenada(this.getX(), this.getY());
        CirculoGrafico bala = new CirculoGrafico(salida, 10, Color.blue);
        return bala;
    }
    
    //Función que nos da la velocidad de movimiento de las balas(círculos) que salen de la nave
    public void ciclo() {
        for (int i = 0; i < this.balas.size(); i++) {
            CirculoGrafico y = (CirculoGrafico) this.balas.get(i);
            float x = y.getY();
            y.setY(x -= 20);
        }
    }
}
