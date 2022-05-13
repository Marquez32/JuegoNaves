
package modelos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

//Clase que nos imprime los textos en la pantalla
public class TextoGrafico implements Dibujable{

    String s;
    Color color;
    int anchoV;
    int altoV;
    int size;
    
    //Constructor
    public TextoGrafico(String texto, Color uncolor, int a, int h) {
        this.s = texto;
        this.color = uncolor;
        this.size = 10;
        this.anchoV = a;
        this.altoV = h;
    }
    
    //Función que nos borra los textos que hay en la pantalla
    public void borrarTexto(Graphics g, String txt) {
        g.setColor(Color.white); //da color a la letra
        g.setFont(new Font("Algerian", Font.PLAIN, this.getSize())); //da estilo de la letra
        int ancho = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
        int alto = (int) g.getFontMetrics().getAscent();
        int x = this.anchoV/2 - ancho/2;
        int y = this.altoV/2 + alto/4;
        g.drawString(txt, x, y); 
    }
    
    //Función que nos imprime el texto en la pantalla
    public void pintarTexto(Graphics g, String txt) {
        g.setColor(Color.red); //da color a la letra
        g.setFont(new Font("Algerian", Font.PLAIN, this.getSize())); //da estilo de la letra
        int ancho = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
        int alto = (int) g.getFontMetrics().getAscent();
        int x = this.anchoV/2 - ancho/2;
        int y = this.altoV/2 + alto/4;
        g.drawString(txt, x, y);
    }
    
    //Interfaz que dibuja el texto por pantalla
    @Override
    public void dibujar(Graphics g) {
        g.setColor(color); //da color a la letra
        g.setFont(new Font("Monospaced", Font.PLAIN, this.getSize())); //da estilo de la letra
        int ancho = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
        int alto = (int) g.getFontMetrics().getAscent();
        int x = this.anchoV/2 - ancho/2;
        int y = this.altoV/2 + alto/4;
        g.drawString(s, x, y);
    }
    
    //Setter y Getter del tamaño
    public void setSize(int nuevoSize) {
        size = nuevoSize;
    }
    
    public int getSize() {
        return size;
    }
    
    //función que sirve para darle color
    public void setColor(Color a) {
        this.color = a;
    }
}
