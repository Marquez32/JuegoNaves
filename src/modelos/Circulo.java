
package modelos;

//Clase de los circulos que dispara la nave
public class Circulo extends Coordenada{
    
    private float radio;
    
    //Constructores
    public Circulo() {
        super();
        this.radio = 0;
    }
    
    public Circulo(Coordenada nuevo, float r) {
        super(nuevo);
        this.radio = r;
    }
    
    public Circulo(Circulo cir) {
        super(cir);
        this.radio = cir.radio;
    }

    //Getter y setter del radio
    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
    
    //Función para obtener el centro del círculo
    public Coordenada getCentro() {
        Coordenada nueva = new Coordenada(this.getX(), this.getY());
        return nueva;
    }
    
    
    
}
