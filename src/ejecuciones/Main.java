
package ejecuciones;

import java.awt.Color;
import java.util.ArrayList;
import modelos.*;

public class Main {
    
    //Función que le da al asteroide una posición aleatoria dentro del eje X
    public static int aleatorio(int max, int min) {
        return (int) (Math.random() * (max-min));
    }
    
    public static void main(String[] args) {
        
        Ventana v = new Ventana("Juego de naves"); //iniciamos la ventana
        ArrayList arrayObjetos = new ArrayList<>();
        
        //nave
        Coordenada cor3 = new Coordenada(475, 500); //la punta
        Coordenada cor4 = new Coordenada(425, 575); //esquina izquierda
        Coordenada cor5 = new Coordenada(525, 575); //esquina derecha
        
        //iniciamos la nave
        NaveGrafico nave = new NaveGrafico(cor3, cor4, cor5, Color.black);
        
        //iniciamos los textos y los añadimos al arrayList
        TextoGrafico vidas = new TextoGrafico("Vidas", Color.black, 1700, 50);
        vidas.setSize(35);
        arrayObjetos.add(vidas);
        
        TextoGrafico score = new TextoGrafico("Puntos", Color.black, 1700, 250);
        score.setSize(35);
        arrayObjetos.add(score);
        
        TextoGrafico puntaje = new TextoGrafico("0", Color.red, 1700, 350);
        puntaje.setSize(40);
        arrayObjetos.add(puntaje);
        
        TextoGrafico numVidas = new TextoGrafico("3", Color.red, 1700, 150);
        numVidas.setSize(40);
        arrayObjetos.add(numVidas);
        
        TextoGrafico textoFinal = new TextoGrafico("GAME OVER", Color.red, 900, 500);
        textoFinal.setSize(100);
                
        arrayObjetos.add(nave); //añadimos la nave al arrayList
        
        Panel p = new Panel(arrayObjetos); //iniciamos el panel con el arrayList de objetos
        
        p.refNave(nave); //asignamos la nave al panel
        
        for (int i = 0; i < 5; i++) {
            int rango = aleatorio(800,50); //ponemos los asteroides en un rango aleatorio
            Coordenada salida = new Coordenada(rango, 0);
            RectanguloGrafico asteroide = new RectanguloGrafico(salida, 25, 25, Color.red);
            arrayObjetos.add(asteroide); //añadimos los asteroides al arrayList
            p.refAst(asteroide); //asignamos los asteroides al panel
        }
        
        //asignamos los textos a la aplicación
        p.refFinal(textoFinal);
        p.refVidas(numVidas);
        p.refPuntos(puntaje);
        
        v.add(p); //añadimos el panel a la ventana
        v.setSize(1000,600);
        v.setVisible(true);
        
        p.iniciar(); //iniciamos el juego
    }
    
}
