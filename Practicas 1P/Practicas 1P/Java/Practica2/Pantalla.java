package Practicas.Java.Practica2;

import java.awt.Frame;
import java.awt.event.*;
//Creación de la parte visual.
public class Pantalla extends Frame implements MouseListener, MouseMotionListener, KeyListener{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Contenedor obj_pintable;//Objeto de la clase contenedor.
    int maxX, maxY, minX, minY;//Bordes del contendor.
    
    public Pantalla() {
        initComponents();
        maxX=maxY=400;//Se inicia con las medidas totales de la ventana.
        minX=minY=0;
    }
    //Inicialización de los componentes.
    public void initComponents() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        obj_pintable = new Contenedor();
        obj_pintable.addMouseListener(this);
        obj_pintable.addMouseMotionListener(this);
        obj_pintable.addKeyListener(this);
        this.addKeyListener(this);
        this.add(obj_pintable);
        this.setSize(450,450);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        Pantalla p = new Pantalla();//Main.
    }
    private void collisionChek()
    {//Si el objeto entra al area del contendor, asigna como maximo las medidas de este.
        if(obj_pintable.getX() <= 130 && obj_pintable.getY() <= 320){
            maxX=130;
            maxY=320;
        }//Hace que el objeto no pueda pasar por el maximo.
        if(obj_pintable.getX() >= maxX)
        {
            obj_pintable.setX(maxX);
        }
        if(obj_pintable.getY() >= maxY)
        {
            obj_pintable.setY(maxY);
        }//Realiza lo mismo pero con los mínimos.
        if(obj_pintable.getX() >= 10 && obj_pintable.getY() >= 100){
            minX=10;
            minY=100;
        }//Hace que el objeto no pueda salir del área.
        if(obj_pintable.getX() <= minX)
        {
            obj_pintable.setX(minX);
        }
        if(obj_pintable.getY() <= minY)
        {
            obj_pintable.setY(minY);
        }
    }
    //Si se hace clic sobre el botón, manda al objeto arrastrable a su pos original.
    @Override//Y hace que los maximos y minimos sean de toda la ventana.
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("Clicked");
        if (obj_pintable.isClicked()) {
            obj_pintable.setW(arg0.getX());
            obj_pintable.setH(arg0.getY());
            obj_pintable.repaint();
        } else {
            obj_pintable.setX(250);
            obj_pintable.setY(270);
            maxX=maxY=400;
            minX=minY=0;
        }
        obj_pintable.setClicked();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Entrando");
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Saliendo");
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Presionado");
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Liberado");
    }
    //Método para arrastrar el objeto.
    @Override
    public void mouseDragged(MouseEvent arg0) {
        if(!obj_pintable.isClicked()) {
            obj_pintable.setX(arg0.getX());
            obj_pintable.setY(arg0.getY());
            collisionChek();
            obj_pintable.repaint();
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        System.out.println("Mover");
    }
    //Si presiona la letra "d" del teclado hace lo mismo que el botón.
    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Presionando " + arg0.getKeyChar());
        if (!obj_pintable.isClicked()) {
            switch(arg0.getKeyChar()) {
                case 'd':
                case 'D':
                    obj_pintable.setX(250);
                    obj_pintable.setY(270);
                    maxX=maxY=400;
                    minX=minY=0;
            }//Manda al objeto a su posición original y pone max y min toda la ventana.
            obj_pintable.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Liberando " + arg0.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Tecleada: " + arg0.getKeyChar());
    }
}
