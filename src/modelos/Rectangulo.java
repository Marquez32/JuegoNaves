
package modelos;

//Clase de los rectángulos que caen
public class Rectangulo extends Coordenada{
    
    private float lado1;
    private float lado2;
    
    //Constructores
    public Rectangulo() {
        super();
        this.lado1 = 0;
        this.lado2 = 0;
    }
    
    public Rectangulo(Coordenada cor, float x, float y) {
        super(cor);
        this.lado1 = x;
        this.lado2 = y;
    }
    
    public Rectangulo(Rectangulo nuevo) {
        super(nuevo.getX(), nuevo.getY());
        this.lado1 = nuevo.getX();
        this.lado2 = nuevo.getY();
    }
    
    //obetenemos los lados del rectángulo
    public float getLado(int lado) {
        if(lado == 1) {
            return this.lado1;
        }
        else if(lado == 2) {
            return this.lado2;
        }
        else {
            return 0;
        }
    }
}
