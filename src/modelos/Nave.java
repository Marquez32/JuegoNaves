
package modelos;

import java.util.ArrayList;

//Clase de la nave que dispara
public class Nave extends Coordenada{
    
    public Coordenada cor1 = new Coordenada(); //toma el lugar de la coordenada de la izquierda
    public Coordenada cor2 = new Coordenada(); //toma el lugar de la coordenada de la derecha
    
    ArrayList balas = new ArrayList<>(); //arraylist que va a contener los disparos
    
    //La coordenada que heredamos va a tomar el lugar de la punta de la nave
    
    //Constructores
    public Nave() {
        super();
        this.cor1.setX(0);
        this.cor1.setY(0);
        
        this.cor2.setX(0);
        this.cor2.setY(0);
    }
    
    public Nave(Coordenada a, Coordenada b, Coordenada c) {
        super(a.getX(), a.getY());
        
        this.cor1.setX(b.getX());
        this.cor1.setY(b.getY());
        
        this.cor2.setX(c.getX());
        this.cor2.setY(c.getY());
    }
    
    public Nave(Nave c) {
        super(c.getX(), c.getY());
        
        this.cor1.setX(c.getX());
        this.cor1.setY(c.getY());
        
        this.cor2.setX(c.getX());
        this.cor2.setY(c.getY());
    }
    
    //Función que sirve para colocar los vértices en la pantalla
    public void setVertice(Coordenada nueva, int lado) {
        if(lado == 1) {
            this.setX(nueva.getX());
            this.setY(nueva.getY());
        }
        if(lado == 2) {
            this.cor1.setX(nueva.getX());
            this.cor1.setY(nueva.getY());
        }
        if(lado == 3) {
            this.cor2.setX(nueva.getX());
            this.cor2.setY(nueva.getY());
        }
    }
    
    //Función que nos proporciona el movimiento a izquierda y derecha de la nave
    public void mover(Coordenada nuevaCor) {
        setVertice((this.suma(nuevaCor)), 1);
        setVertice((this.cor1.suma(nuevaCor)), 2);
        setVertice((this.cor2.suma(nuevaCor)), 3);
    }
}
