package Practicas.Java.Practica1;
//Se importan los paquetes necesarios para trabajar con Ventanas, así como con eventos.
import java.awt.event.*;
//Se crea la clase principal de la interfaz gráfica de usuario.
public class CalculadoraGUI extends Modelo {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int dat1;//Numero 1 ingresado.
    private int dat2;//Numero 2 ingresado.
    private String op;//Tipo de operación a realizar.
    private Controlador ope;//Objeto de la clase operaciones.
    //Constructor de la clase.
    public CalculadoraGUI(String nombre){
        super(nombre);
        ope = new Controlador();
    }

    //Método que permite dar funciones al presionar los botones.
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == btn_0){
            txt_in.setText(txt_in.getText() + "0");
        }//Al presionar algún boton con un número se muestra lo que está en el TextField seguido del número que se presionó.
        if (arg0.getSource() == btn_1){
            txt_in.setText(txt_in.getText() + "1");
        }
        if (arg0.getSource() == btn_2){
            txt_in.setText(txt_in.getText() + "2");
        }
        if (arg0.getSource() == btn_3){
            txt_in.setText(txt_in.getText() + "3");
        }
        if (arg0.getSource() == btn_4){
            txt_in.setText(txt_in.getText() + "4");
        }
        if (arg0.getSource() == btn_5){
            txt_in.setText(txt_in.getText() + "5");
        }
        if (arg0.getSource() == btn_6){
            txt_in.setText(txt_in.getText() + "6");
        }
        if (arg0.getSource() == btn_7){
            txt_in.setText(txt_in.getText() + "7");
        }
        if (arg0.getSource() == btn_8){
            txt_in.setText(txt_in.getText() + "8");
        }
        if (arg0.getSource() == btn_9){
            txt_in.setText(txt_in.getText() + "9");
        }//Al presionar una operación se guarda el numero que se ingreso y se pide el siguiente.
        if (arg0.getSource() == btn_suma){
            String nose = txt_in.getText();
            if(ope.isNumber(nose)){//Primero se hace una comprobación para saber si lo que se guarda si es un número.
                dat1=Integer.parseInt(nose);
                op = "+";//Según la operación se define el operador.
                txt_in.setText("");
            }
            else
            txt_in.setText("Por favor ingresa solo números o datos de maximo 20 digitos");
        }
        if (arg0.getSource() == btn_resta){
            String nose = txt_in.getText();
            if(ope.isNumber(nose)){
                dat1=Integer.parseInt(nose);
                op = "-";
                txt_in.setText("");
            }
            else
            txt_in.setText("Por favor ingresa solo números o datos de maximo 20 digitos");
        }
        if (arg0.getSource() == btn_multi){
            String nose = txt_in.getText();
            if(ope.isNumber(nose)){
                dat1=Integer.parseInt(nose);
                op = "*";
                txt_in.setText("");
            }
            else
            txt_in.setText("Por favor ingresa solo números o datos de maximo 20 digitos");
        }
        if (arg0.getSource() == btn_div){
            String nose = txt_in.getText();
            if(ope.isNumber(nose)){
                dat1=Integer.parseInt(nose);
                op = "/";
                txt_in.setText("");
            }
            else
            txt_in.setText("Por favor ingresa solo números o datos de maximo 20 digitos");
        }
        if (arg0.getSource() == btn_cuadrado){
            String nose = txt_in.getText();
            if(ope.isNumber(nose)){
                dat1=Integer.parseInt(nose);
                op = "^";
                txt_in.setText("");
            }
            else
            txt_in.setText("Por favor ingresa solo números o datos de maximo 20 digitos");
        }//Al presionar el igual, guarada el segundo número y llama al método Operac de la clase Operaciones.
        if (arg0.getSource() == btn_igual){
            String nose = txt_in.getText();
            if(ope.isNumber(nose)){//Comprobación.
                dat2=Integer.parseInt(nose);
                txt_in.setText(ope.Operac(dat1, dat2, op));//Llamada al método.
            }
            else
            txt_in.setText("Por favor ingresa solo números o datos de maximo 20 digitos");
        }
    }
}