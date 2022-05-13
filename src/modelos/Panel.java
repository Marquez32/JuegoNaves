
package modelos;

import static ejecuciones.Main.aleatorio;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;


//Clase Panel
public class Panel extends JPanel implements KeyListener{ //KeyListener
    
    ArrayList v;
    ArrayList ast = new ArrayList();
    NaveGrafico nave;
    
    //coordenadas que sirven para el movimiento a izquierda y a derecha
    Coordenada movIzq = new Coordenada(-25, 0);
    Coordenada movDcha = new Coordenada(25, 0);
    Coordenada movNulo = new Coordenada(0, 0);
    
    boolean finJuego = false;
    
    RectanguloGrafico asteroide;
    
    int contadorAsteroides = 5;
    
    int score;
    int vida = 3;
    
    int mov = 10;
    int MAXAST = 5;
    
    //Textos que se muestra por pantalla
    TextoGrafico puntos;
    TextoGrafico vidas;
    TextoGrafico fin;
    
    //Constructor
    public Panel(ArrayList vectorDe0) {
        this.v = vectorDe0;
        this.addKeyListener(this);
        setFocusable(true);
    }
    
    //Función que sirve para pintar 
    @Override
    public void paint(Graphics g) {
        
        Dimension d = getSize(); //obtenemos el tamaño
        Image imagen = createImage(d.width, d.height); //creamos la imagen con su ancho y su alto
        Graphics buff = imagen.getGraphics(); //le ponemos los gráficos
        
        Dibujable dib;
        for (int i = 0; i < v.size(); i++) {
            dib = (Dibujable) v.get(i); 
            dib.dibujar(buff); //dibujamos los gráficos a partir de su interfaz
        }
        
        //finalmente mostramos todos los gráficos por pantalla
        g.drawImage(imagen, 0, 0, null);
        
    }
    
    //Función que nos actualiza lo que hay pintado en la pantalla
    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    //Función que da el significado cuando pulsas las teclas
    @Override
    public void keyPressed(KeyEvent e) {
        
        //obtenemos el código de la tecla
        int tecla = e.getKeyCode();
        
        //si pulsas la flecha de la izquierda
        if(tecla == KeyEvent.VK_LEFT) {
            this.nave.mover(movIzq); //la nave se mueve la izquierda
        }
        
        //si pulsas la flecha de la derecha 
        if(tecla == KeyEvent.VK_RIGHT) {
            this.nave.mover(movDcha); //la nave se mueve a la derecha
        }
        
        //si pulsas la Q o la barra espaciadora la nave disparas
        if(tecla == KeyEvent.VK_Q || tecla == KeyEvent.VK_SPACE) {
            CirculoGrafico bala = nave.bala(); //creamos la bala
            nave.balas.add(bala); //la añadimos a las listas
            v.add(bala);
        }
        
    }
    
    //Función que da el significado cuando dejas de pulsar las teclas
    @Override
    public void keyReleased(KeyEvent e) {
        
        //obtenemos el código de la tecla
        int tecla = e.getKeyCode();
        
        //si dejas de pulsar la tecla de la flecha izquierda
        if(tecla == KeyEvent.VK_LEFT) {
            this.nave.mover(movNulo); //la nave se queda quieta
        }
        
        //si dejas de pulsar la tecla de la flecha derecha
        if(tecla == KeyEvent.VK_RIGHT) {
            this.nave.mover(movNulo); //la nave se queda quieta
        }
        
        //si dejas de pulsar la tecla Q o la barra espaciadora la nave no dispara
        if(tecla == KeyEvent.VK_Q || tecla == KeyEvent.VK_SPACE) {
            
        }
        
    }
    
    //función para asignar la nave
    public void refNave(NaveGrafico n) {
        this.nave = n;
    }
    
    //función que añade los asteroides(rectángulos que están cayendo)
    public void refAst(RectanguloGrafico a) {
        ast.add(a); //añade el asteroide a la lista
    }
    
    //función para asignar el texto de los puntos
    public void refPuntos(TextoGrafico a) {
        this.puntos = a;
    }
    
    //función para asignar el texto de las vidas
    public void refVidas(TextoGrafico b) {
        this.vidas = b;
    }
    
    //función para asignar el texto del final del juego
    public void refFinal(TextoGrafico c) {
        this.fin = c;
    }
    
    //función para describir las colisiones entre el disparo(círculo) con el asteroide(rectángulo)
    public void colision() {
        
        for (int i = 0; i < nave.balas.size(); i++) { //recorremos las balas
            CirculoGrafico bala = (CirculoGrafico) nave.balas.get(i); //obtenemos las balas
            for (int j = 0; j < ast.size(); j++) { //recorremos los asteroides
                RectanguloGrafico aste = (RectanguloGrafico) ast.get(j); //obtenemos los asteroides
                
                //obetenemos la coordenada de la bala
                Coordenada corBala = new Coordenada(bala.getX(), bala.getY());
                
                //mediante estas coordenadas definimos el cuerpo del asteroide (rectángulo)
                //básicamente estas son las coordenadas de la hitbox de los asteroides
                Coordenada derecha = new Coordenada(aste.getX() + 30, aste.getY());
                Coordenada izquierda = new Coordenada(aste.getX() - 15, aste.getY());
                Coordenada medio = new Coordenada(aste.getX(), aste.getY());
                
                //si una bala impacta alcanza al asteoroide
                if(corBala.getX() > izquierda.getX() && corBala.getX() < derecha.getX() &&
                        corBala.getY() < medio.getY()) {
                    aste.pintar(Color.white); 
                    bala.pintar(Color.white);
                    aste.setY(-100);
                    bala.setY(-100);
                    
                    nave.balas.remove(bala); //borramos la bala
                    ast.remove(aste); // y el asteroide
                    
                    contadorAsteroides--; //disminuimos en 1 ek contador de asteroides
                    
                    score += 5; //aumentamos la puntuación del jugador
                    puntos.setColor(Color.white);
                    String nuevoScore = score + "";
                    //sobreescribimos los puntos del jugador
                    TextoGrafico numPuntos = new TextoGrafico(nuevoScore, Color.red, 1700, 350);
                    numPuntos.setSize(40);
                    puntos = numPuntos;
                    v.add(puntos); //añadimos los nuevos puntos al arrayList
                    
                }
                
                //Si un asteroide impacta contra nuestra nave
                if((medio.getY() > 470 && medio.getY() < 550) && 
                        (nave.cor1.getX() < medio.getX() && nave.cor2.getX() > medio.getX())) {
                    
                    score = score - 5; //restamos puntuación al jugador
                    vida--; //el jugador pierde una vida
                    
                    String nuevoScore = score + "";
                    String nuevasVidas = vida + "";
                    vidas.setColor(Color.white);
                    puntos.setColor(Color.white);
                    
                    //actualizamos el texto del número de vidas
                    TextoGrafico numVidas = new TextoGrafico(nuevasVidas, Color.red, 1700, 150);
                    numVidas.setSize(40);
                    vidas = numVidas;
                    
                    //actualizamos el texto del número de puntos
                    TextoGrafico numPuntos = new TextoGrafico(nuevoScore, Color.red, 1700, 350);
                    numPuntos.setSize(40);
                    puntos = numPuntos;
                    
                    v.add(vidas); //añadimos los textos al arrayList
                    v.add(puntos);
                    
                    ast.remove(aste); //eliminamos el asteroide de la pantalla
                    aste.setY(2000);
                    contadorAsteroides--; //disminuimos en 1 el contador de asteoides
                    
                }
                
            }
        }
        
    }
    
    //Función para que el juego se mantenga en funcionamiento
    public void iniciar() {
        
        while(!finJuego) { //mientras no se acabe el juego
            try {
                //si hay balas
                if(!nave.balas.isEmpty()) {
                    nave.ciclo(); //las balas avanzan a una cierta velocidad
                }
                
                //recorremos los asteroides (rectángulos)
                for (int i = 0; i < ast.size(); i++) {
                    RectanguloGrafico rect = (RectanguloGrafico) ast.get(i);
                    rect.ciclo(mov); //definimos la velocidad de caida de los asteroides

                    if(rect.getY() > 525) {
                        int rango = aleatorio(800, 50); //sacamos mas asteroides
                        rect.setY(0);
                        rect.setX(rango);
                    }
                }
                
                //mientras haya menos asteroides que el máximo permitido
                if(contadorAsteroides < MAXAST) {
                    int rango = aleatorio(800, 50); //sacamos más asteroides
                    Coordenada inicio = new Coordenada(rango, 0);
                    RectanguloGrafico nuevo = new RectanguloGrafico(inicio, 25, 25, Color.red);
                    
                    ast.add(nuevo); //añadimos el asteroide a las listas
                    v.add(nuevo);
                    nuevo.ciclo(mov); //y le damos velocidad de movimiento
                    
                    contadorAsteroides++; //aumentamos en uno la cantidad de asteroides
                }
                
                int nivel = 1;
                String niveles = nivel + "";
                
                //Definimos los texors
                TextoGrafico textoNivel = new TextoGrafico("NIVEL", Color.black, 1700, 500);
                textoNivel.setSize(50);
                
                TextoGrafico textoNumNivel = new TextoGrafico(niveles, Color.red, 1700, 600);
                textoNumNivel.setSize(50);
                
                v.add(textoNivel); //los mostramos por pantalla
                v.add(textoNumNivel);
                
                //Cuando superemos los 50 puntos pasamos al nivel 2
                if(score > 50 && score <= 100) {
                    nivel = 2;
                    String nuevoNivel = nivel + "";
                    textoNumNivel.setColor(Color.white);
                    
                    //actualizamos texto del número de nivel
                    TextoGrafico numeroNivel = new TextoGrafico(nuevoNivel, Color.red, 1700, 600);
                    numeroNivel.setSize(50);
                    
                    textoNumNivel = numeroNivel;
                    v.add(textoNumNivel);
                    mov = 12; //aumentamos la velocidad de movimiento y la cantidad de asteroides
                    MAXAST = 6;
                    
                    for (int i = 0; i < ast.size(); i++) {
                        RectanguloGrafico rect = (RectanguloGrafico) ast.get(i);
                        rect.pintar(Color.green); //cambiamos el color de los asteroides
                    }
                }
                
                //Si superamos los 100 puntos pasamos al nivel 2
                if(score > 100) {
                    nivel = 3;
                    String nuevoNivel = nivel + "";
                    textoNumNivel.setColor(Color.white);
                    
                    //actualizamos texto del número de nivel
                    TextoGrafico numeroNivel = new TextoGrafico(nuevoNivel, Color.red, 1700, 600);
                    numeroNivel.setSize(50);
                    
                    textoNumNivel = numeroNivel;
                    v.add(textoNumNivel);
                    mov = 14; //aumentamos la velocidad de movimiento y la cantidad de asteroides
                    MAXAST = 7;
                    
                    for (int i = 0; i < ast.size(); i++) {
                        RectanguloGrafico rect = (RectanguloGrafico) ast.get(i);
                        rect.pintar(Color.orange); //cambiamos el color de los asteroides
                    }
                }
                
                //Si perdemos todas las vidas
                if(vida <= 0) {
                    finJuego = true; //el juego se acaba
                    v.add(fin); //mostramos por pantalla el texto de final del juego
                }
                
                colision(); //iniciamos la función colisión 
                
                //dormimos el hilo unos pocos milisegundos para que no vaya tan rápido
                //la aplicación
                Thread.sleep(50); 
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            repaint(); //volvemos a pintar
        }
        
    }
}
