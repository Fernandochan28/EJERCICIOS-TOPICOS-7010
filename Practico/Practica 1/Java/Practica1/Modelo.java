package Practicas.Java.Practica1;
//Se importan los paquetes necesarios para trabajar con Ventanas, así como con eventos.
import java.awt.*;
import java.awt.event.*;
//Se crea la clase principal de la interfaz gráfica de usuario.
public class Modelo extends Frame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //Se definen cada uno de los parametros que nos serviran para la calculadora.
    protected TextField txt_in;//TextField en el que se ingresan y muestran los datos.
    protected Button btn_0;
    protected Button btn_1;
    protected Button btn_2;
    protected Button btn_3;
    protected Button btn_4;//Se crean los botones de los numeros del 0-9
    protected Button btn_5;
    protected Button btn_6;
    protected Button btn_7;
    protected Button btn_8;
    protected Button btn_9;
    protected Button btn_suma;
    protected Button btn_resta;
    protected Button btn_multi;//Se crean los botones propios a las operaciones y al resultado de estas.
    protected Button btn_div;
    protected Button btn_cuadrado;
    protected Button btn_igual;
    protected Label lbl_c1;
    protected Label lbl_c2;
    protected Label lbl_c3;///Se crean los botones propios a las operaciones y al resultado de estas.
    protected Label lbl_op;
    protected Panel panel_central;
    protected Panel panel_superior;//Paneles para poner cada uno de los componentes.

    public Modelo (String nombre){
        initComponents(nombre);
    }

    //Métoodo que define e inicializa todos los componentes.
    public void initComponents(String nombre) {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        panel_superior = new Panel();
        panel_central = new Panel();
        panel_superior.setLayout(new GridLayout());//Creación de los paneles y definicón del tipo de
        panel_central.setLayout(new GridLayout());//Layout que usarán.
        btn_0 = new Button ("0");//Se nombran los botones y se les añade un actionlister para que al ser presionados hagan algo
        btn_0.addActionListener(this);//Así con todos los botones.
        btn_1 = new Button ("1");
        btn_1.addActionListener(this);
        btn_2 = new Button ("2");
        btn_2.addActionListener(this);
        btn_3 = new Button ("3");
        btn_3.addActionListener(this);
        btn_4 = new Button ("4");
        btn_4.addActionListener(this);
        btn_5 = new Button ("5");
        btn_5.addActionListener(this);
        btn_6 = new Button ("6");
        btn_6.addActionListener(this);
        btn_7 = new Button ("7");
        btn_7.addActionListener(this);
        btn_8 = new Button ("8");
        btn_8.addActionListener(this);
        btn_9 = new Button ("9");
        btn_9.addActionListener(this);
        btn_suma = new Button ("+");
        btn_suma.addActionListener(this);
        btn_resta = new Button ("-");
        btn_resta.addActionListener(this);
        btn_multi = new Button ("*");
        btn_multi.addActionListener(this);
        btn_div = new Button ("/");
        btn_div.addActionListener(this);
        btn_cuadrado = new Button ("^");
        btn_cuadrado.addActionListener(this);
        btn_igual = new Button ("=");
        btn_igual.addActionListener(this);
        lbl_c1 = new Label ("C1");
        lbl_c2 = new Label ("C2");
        lbl_c3 = new Label ("C3");//Se pone el texto correspondiente a cada Label.
        lbl_op = new Label ("Op");
        txt_in = new TextField();//Se crea el TextField.
        txt_in.setForeground(Color.GRAY);//Con las especificaciones de la práctica.
        txt_in.setText("0123456789");
        panel_superior.setLayout(new GridLayout(1,1));
        panel_superior.add(txt_in, 0,0);//Se añade el TextField al panel superior
        panel_central.setLayout(new GridLayout(5,4));
        panel_central.add(lbl_c1);//Se añaden los label así como los botones al panel central
        panel_central.add(lbl_c2);//cuidando el orden ya establecido.
        panel_central.add(lbl_c3);
        panel_central.add(lbl_op);
        panel_central.add(btn_1);
        panel_central.add(btn_2);
        panel_central.add(btn_3);
        panel_central.add(btn_suma);
        panel_central.add(btn_4);
        panel_central.add(btn_5);
        panel_central.add(btn_6);
        panel_central.add(btn_resta);
        panel_central.add(btn_7);
        panel_central.add(btn_8);
        panel_central.add(btn_9);
        panel_central.add(btn_div);
        panel_central.add(btn_multi);
        panel_central.add(btn_0);
        panel_central.add(btn_cuadrado);
        panel_central.add(btn_igual);
        this.setLayout(new BorderLayout());
        this.add(panel_superior, BorderLayout.NORTH);//Se añaden los paneles con un border layout
        this.add(panel_central, BorderLayout.CENTER);
        this.setSize(500,400);//Se especifican las propiedades de la ventana, como tamaño y que se muestre.
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle(nombre);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
