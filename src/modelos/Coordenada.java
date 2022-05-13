
package modelos;

//Clase Coordenadas
public class Coordenada {
    
    //Ejes x e y
    private float x;
    private float y;
    
    //Constructores
    public Coordenada() {
        this.x = 0;
        this.y = 0;
    }
    
    public Coordenada(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public Coordenada(Coordenada nva) {
        this.x = nva.x;
        this.y = nva.y;
    }

    //Getters y Setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    //Función que suma las coordenadas de la nave
    //Esta función sirve para implementar el movimiento de la nave
    public Coordenada suma(Coordenada s) {
        float sumX = this.x + s.getX();
        float sumY = this.y + s.getY();
        
        Coordenada cor = new Coordenada(sumX, sumY);
        
        return cor;
    }
}
